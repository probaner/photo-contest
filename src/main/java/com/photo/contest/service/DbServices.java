package com.photo.contest.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.mail.MessagingException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.config.HibernateConfig;
import com.photo.contest.dao.CategoryDAO;
import com.photo.contest.dao.DiscountDataDAO;
import com.photo.contest.dao.FileDetailDAO;
import com.photo.contest.dao.ImageRatingDAO;
import com.photo.contest.dao.JudgeDAO;
import com.photo.contest.dao.OrganizerClubDAO;
import com.photo.contest.dao.PayStatusDAO;
import com.photo.contest.dao.PaymentResponseDAO;
import com.photo.contest.dao.UsersDAO;
import com.photo.contest.dto.CategoryCountMap;
import com.photo.contest.dto.ClubDTO;
import com.photo.contest.dto.DisplayReatingImageDTO;
import com.photo.contest.dto.EditTableDataDTO;
import com.photo.contest.dto.FileDTO;
import com.photo.contest.dto.GetPassword;
import com.photo.contest.dto.JudgeCreationDTO;
import com.photo.contest.dto.JudgeRegisterDTO;
import com.photo.contest.dto.JudgeTableDTO;
import com.photo.contest.dto.LogingResponseDTO;
import com.photo.contest.dto.OrganizerClubDTO;
import com.photo.contest.dto.PayPalPaymentResponseDTO;
import com.photo.contest.dto.PaystatusGraphDTO;
import com.photo.contest.dto.ReatingStatusTableDTO;
import com.photo.contest.dto.ResponseDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.dto.UserFileTitelListDTO;
import com.photo.contest.dto.UserStatusDisplayDTO;
import com.photo.contest.exception.ApplicationException;
import com.photo.contest.exception.BusinessException;
import com.photo.contest.exception.ErrorCode;
import com.photo.contest.exception.ImageNotFoundException;
import com.photo.contest.exception.PayStatusNotFoundException;
import com.photo.contest.exception.UserNotFoundException;
import com.photo.contest.model.Category;
import com.photo.contest.model.DiscountData;
import com.photo.contest.model.File;
import com.photo.contest.model.ImageRating;
import com.photo.contest.model.Judge;
import com.photo.contest.model.OrganizerClub;
import com.photo.contest.model.PayStatus;
import com.photo.contest.model.PaymentResponse;
import com.photo.contest.model.Users;
import com.photo.contest.utility.CommonUtil;
import com.photo.contest.utility.ResultPDFUtility;


@Service
public class DbServices {
	
	public static Map<String, Integer> results = new HashMap<String, Integer>();
	public static Map<String, TreeSet<Integer>> imageIdMap = new HashMap<>();
	public static TreeSet<Integer> judgeIdList = new TreeSet<Integer>();
	
	public static String dbname =null;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private CommonServices commonService;
	@Autowired
	private FileDetailDAO fileDetailDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private PayStatusDAO payStatusDAO;
	@Autowired
	private DiscountDataDAO discountDataDAO;
	@Autowired
	private OrganizerClubDAO organizerClubDAO;
	@Autowired
	private JudgeDAO judgeDAO;
	@Autowired
	PaymentResponseDAO paymentResponseDAO;
	@Autowired
	ImageRatingDAO imageRatingDAO;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	ResultPDFUtility resultPDFUtility;
	
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}

	public void setCommonService(CommonServices commonService) {
		this.commonService = commonService;
	}

	public void setFileDetailDAO(FileDetailDAO fileDetailDAO) {
		this.fileDetailDAO = fileDetailDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setPayStatusDAO(PayStatusDAO payStatusDAO) {
		this.payStatusDAO = payStatusDAO;
	}

	public void setDiscountDataDAO(DiscountDataDAO discountDataDAO) {
		this.discountDataDAO = discountDataDAO;
	}
	
	
	public void setOrganizerClubDAO(OrganizerClubDAO organizerClubDAO) {
		this.organizerClubDAO = organizerClubDAO;
	}
		

	public void setJudgeDAO(JudgeDAO judgeDAO) {
		this.judgeDAO = judgeDAO;
	}
		
	public void setPaymentResponseDAO(PaymentResponseDAO paymentResponseDAO) {
		this.paymentResponseDAO = paymentResponseDAO;
	}

	public  String getDBName() {
		dbname= HibernateConfig.resourceBundle.getString("db.name");
		return dbname;
	}
	
	
	
	 

	@Transactional
	public Users saveUserData(UserDTO userDTO) throws IOException {
		
		
		Users users = new Users();
		users.setUserId(commonUtil.getUserId());
		users.setFirstName(userDTO.getFirstname().trim());
		users.setLastName(userDTO.getLastname().trim());
		users.setGender(userDTO.getGender());
		users.setAddress(userDTO.getAddress().trim());
		users.setCity(userDTO.getCity().trim());
		users.setState(userDTO.getPin().trim());
		users.setCountry(userDTO.getCountry());
		users.setClub(userDTO.getClub().trim().toUpperCase());
		users.setHoner(userDTO.getHoner().trim());
		users.setEmail(userDTO.getEmail().trim());
		users.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		users.setCreatedOn(commonUtil.sqlDateTime());
		users.setLastLoggin(commonUtil.sqlDateTime());
		users.setRole("participate");
		users.setCreatedBy("own");
		
		PayStatus payStatus = new PayStatus();
		payStatus.setAttemptSection(0);
		payStatus.setCouponCodeNumber("");
		List<String> netiveCountryList = Arrays.asList(configProperty.getNetiveCountry().split(","));
		if (netiveCountryList.contains(userDTO.getCountry().toUpperCase()))
			payStatus.setCourencyType(configProperty.getNetiveCurrencyName());
		else
			payStatus.setCourencyType(configProperty.getForeignCurrencyName());
		payStatus.setDiscountAmount(0);
		payStatus.setEntryCreatedTime(commonUtil.sqlDateTime());
		payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
		// payStatus.setPayTime(commonUtil.sqlDateTime());
		payStatus.setPayingStatus(null);
		payStatus.setRecivedAmont(0);
		payStatus.setRecivedCourencyType(null);
		payStatus.setTotalAmount(0);
		payStatus.setTotalEntry(0);
		payStatus.setPayingStatus("Being Check");
		payStatus.setUsers(users);
		users.setPayStatus(payStatus);
		
		Integer id =usersDAO.persist(users);
		
		users.setUserId(id);
				
		try {
			  String message=  commonService.sendUserRegistrationConfirmMail(users, userDTO.getPassword());
			  System.out.println("messagein dbService:"+ message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(users.toString());
		
		return users;
	}

	@Transactional
	public Users getUserDataByToken(String token) throws IOException {
		Users user = usersDAO.findByforgetPasswAuthToken(token);		
		return user;

	}

	
	@Transactional
	//public LogingResponseDTO getUserData(Login login) throws IOException {
	public LogingResponseDTO getUserData(String email) throws IOException {
		
		LogingResponseDTO logingResponseDTO = new LogingResponseDTO(); 
		List<String> keys  = new ArrayList();
		
		Users users = new Users();
		users.setEmail(email);
		@SuppressWarnings("unchecked")
		List<Users> userData = usersDAO.findByExample(users);
		
		if(userData.size()==1) {
			logingResponseDTO.setUser(userData.get(0));						
			Users currentUser = userData.get(0);
			Set<File> fileSet = currentUser.getFiles();
					
		 if( fileSet.size()>0 && currentUser.getRole().equals("participate")) {//file has and role participate
			 
			 HashMap<String,FileDTO> hm = new HashMap<String, FileDTO>();
			 
			 if(commonService.getExpairStatus()) { // before expair date if 
			 for(File file : fileSet) {
				 FileDTO displayFileDTO = new FileDTO();
				 displayFileDTO.setCatagoryName(file.getCategory().getCategoryName());
				 displayFileDTO.setFileId(file.getFileId());
				 displayFileDTO.setEncodedString(new String(Base64.encodeBase64( file.getFile())));
				 displayFileDTO.setPositionName(file.getCategoryIndex());
				 displayFileDTO.setTitel(file.getTitel());
				 displayFileDTO.setEditable(true);
				 hm.put(file.getCategory().getCategoryName()+file.getCategoryIndex(), displayFileDTO);
				 keys.add(file.getCategory().getCategoryName()+file.getCategoryIndex());
			    }
			 
			 
			 for (Entry<String, Integer> pair : results.entrySet()) {
				 if(currentUser.getPayStatus().getPayingStatus().equals("Paid")) {
					 List<String> currentKeyNotInHM = new ArrayList();
					 for(int i =1; i<=4 ; i++) {
						  if(!keys.contains(pair.getKey()+pair.getKey()+i)) {
							  currentKeyNotInHM.add(pair.getKey()+pair.getKey()+i);
						    }
					     }
					 if(currentKeyNotInHM.size()==4) {
						for(String key: currentKeyNotInHM) 
							hm.put(key, new FileDTO());				   
					   }
					 else if(currentKeyNotInHM.size()>0 && currentKeyNotInHM.size()<4){
						     for(String key: currentKeyNotInHM) {
						    	 FileDTO fdto = new FileDTO();
						    	 fdto.setEditable(true);
						    	 hm.put(key, fdto);
						        }
					        }
					 
					 
				   }else if(currentUser.getPayStatus().getPayingStatus().equals("Being Check")){
					   for(int i =1; i<=4 ; i++) {
					      if(!hm.containsKey(pair.getKey()+pair.getKey()+i) ){
					       FileDTO fd =new FileDTO();
					       fd.setEditable(true);
					       hm.put(pair.getKey()+pair.getKey()+i, fd);
				          }
					   }
					      
				         }
			 }
			
			
			 }else { // after expair date all display status is false.				
					 for(File file : fileSet) {
						 FileDTO displayFileDTO = new FileDTO();
						 displayFileDTO.setCatagoryName(file.getCategory().getCategoryName());
						 displayFileDTO.setFileId(file.getFileId());
						 displayFileDTO.setEncodedString(new String(Base64.encodeBase64( file.getFile())));
						 displayFileDTO.setPositionName(file.getCategoryIndex());
						 displayFileDTO.setTitel(file.getTitel());
						 displayFileDTO.setEditable(false);
						 hm.put(file.getCategory().getCategoryName()+file.getCategoryIndex(), displayFileDTO);				 
					    }
					 for (Entry<String, Integer> pair : results.entrySet()) {
						   //System.out.println(pair.getKey());
						   for(int i =1; i<=4 ; i++) {
							   if(!hm.containsKey(pair.getKey()+pair.getKey()+i) ) {					   
								   hm.put(pair.getKey()+pair.getKey()+i, new FileDTO());
							      }
						   }}
			 }
			 
			 logingResponseDTO.setHm(hm);					
			
		   }else if(fileSet.size()==0 && currentUser.getRole().equals("participate")) {
			   if(commonService.getExpairStatus()) {
				   logingResponseDTO.setHm(new HashMap<String, FileDTO>() );
			      }
			   else {
				     HashMap<String,FileDTO> hm = new HashMap<String, FileDTO>();
				      for (Entry<String, Integer> pair : results.entrySet()) {
					   //System.out.println(pair.getKey());
					   for(int i =1; i<=4 ; i++) {
						   if(!hm.containsKey(pair.getKey()+pair.getKey()+i) ) {					   
							   hm.put(pair.getKey()+pair.getKey()+i, new FileDTO());
						      }
					   }}
				      
				      logingResponseDTO.setHm(hm);
			        }
			   
		   }
		 
		    else {
			       logingResponseDTO.setHm(new HashMap<String, FileDTO>() );
		         }
			
			currentUser.setLastLoggin(commonUtil.sqlDateTime());
			usersDAO.attachDirty(currentUser);
					   
		}else {
			    
			    logingResponseDTO.setUser(null);
			    logingResponseDTO.setHm(null);
		      }
					
			return logingResponseDTO;
	}
	
	
	
	
		
	
	@Transactional
	public List<String> getListOfAColumn(String columnName) throws IOException {
		List<Users> usersList = usersDAO.findAColumn(columnName);
		List<String> emailList = new ArrayList<String>();
		// System.out.println(usersList.toString());
		if (usersList.size() > 0) {
			for (Users users : usersList) {
				emailList.add(users.getEmail());
			}
		}
		System.out.println(emailList);
		return emailList;
		// return null;

	}

	@Transactional
	public void updateCurrentTimeStamp(Users user) {
		Users users = new Users();
		users.setUserId(user.getUserId());
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setGender(user.getGender());
		users.setAddress(user.getAddress());
		users.setCity(user.getCity());
		users.setState(user.getState());
		users.setCountry(user.getCountry());
		users.setClub(user.getClub());
		users.setHoner(user.getHoner());
		users.setEmail(user.getEmail());
		users.setPassword(user.getPassword());
		users.setCreatedOn(user.getCreatedOn());
		users.setLastLoggin(commonUtil.sqlDateTime());
		users.setRole(user.getRole());
		usersDAO.attachDirty(users);

	}
	
	@Transactional
	public void updateForgetPasswAuthToken(Users user, String data) {		
		usersDAO.attachDirty(user);	
		if(data.contains("token=")) {
		   try {
			commonService.sendforgetPassWordMail(user, data);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }else {
			      try {
					commonService.sendPasswordChangeConfirmMail(user, data);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        }
	}

	@Transactional
	public Integer saveFileData(FileDTO fileDTO, UserDTO userDTO) throws IOException {

		File fileDetail = new File();	
		String[] arry = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		
		int totalNimberofEntry = 0;
		Users user = usersDAO.findById(userDTO.getUserid());

		Category catagory = new Category();
		catagory.setCategoryId(results.get(fileDTO.getCatagoryName()));
		
		fileDetail.setUsers(user);
		fileDetail.setTitel(fileDTO.getTitel().trim().toUpperCase());
		fileDetail.setFile(fileDTO.getImages().getBytes());
		// fileDetail.setOriginalFileName(fileDTO.getPositionName()+"_"+fileDTO.getImages().getOriginalFilename());
		fileDetail.setCategoryIndex(fileDTO.getPositionName());
		fileDetail.setOriginalFileName(fileDTO.getImages().getOriginalFilename());
		fileDetail.setUploadTime(commonUtil.sqlDateTime());
		fileDetail.setCategory(catagory);
		
		// save file
		List<String> listOfTitel = fileDetailDAO.findTitelListOfaCatagory(fileDetail);
		
		
		if(listOfTitel.size() == 0 || !listOfTitel.contains(fileDetail.getTitel())){
			Integer fileid = fileDetailDAO.persist(fileDetail);
			
			if(fileid>0) {				           
				           PayStatus  payStatus = user.getPayStatus();				          
				          // payStatus.setUsers(user);
				           String sql = "select  category_id, count(category_id) file_id from "+getDBName()+".file where user_id="+fileDetail.getUsers().getUserId() +" group by category_id";
				           List<CategoryCountMap> fileDetailList = fileDetailDAO.getCategoryWiseFileCount( sql);
				           if (fileDetailList.size() > 0) {
								for (CategoryCountMap c : fileDetailList) {
									 totalNimberofEntry = totalNimberofEntry + c.getFile_id();
								    }
								 payStatus.setAttemptSection(fileDetailList.size());
						         payStatus.setTotalEntry(totalNimberofEntry);
						         
						         if (payStatus.getCourencyType().equals(configProperty.getNetiveCurrencyName()))
						        	 payStatus.setTotalAmount(Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()] + "Netive")));
									else
										payStatus.setTotalAmount(Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()])));
						                payStatus.setDiscountAmount(payStatus.getTotalAmount());
						                payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
						                //System.out.println("payStatus="+payStatus.toString()); 
						                payStatusDAO.attachDirty(payStatus);
						                return fileid;
								}
			             }
			
		}
			  		
		return 0;	

	}
	
	
	
	

	@Transactional
	public String deleteFileData(FileDTO fileDTO,  UserDTO userDTO) {

		//File fileDetail = new File();
		
		String[] arry = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		
		if (fileDTO.getFileId() != null) {	
			fileDetailDAO.deletebyID(fileDTO.getFileId());
			Users user = usersDAO.findById(userDTO.getUserid());			
		     Set<File> fileset = user.getFiles();
		     PayStatus payStatus = new PayStatus();
		     payStatus = user.getPayStatus();
		     if(fileset.size()>0) {
		    	                    
		    	      
		    	         //int section = commonUtil.getNumbrtofSection(fileset.size());
		    	 String sql = "select  category_id, count(category_id) file_id from "+getDBName()+".file where user_id="+user.getUserId() +" group by category_id";	
		    	         List<CategoryCountMap> fileDetailList = fileDetailDAO.getCategoryWiseFileCountUsingUserID(sql);
		    	         if(fileDetailList.size()>0) {
						 payStatus.setAttemptSection(fileDetailList.size());
				         payStatus.setTotalEntry(fileset.size());
				         
				         if (payStatus.getCourencyType().equals(configProperty.getNetiveCurrencyName()))
				        	 payStatus.setTotalAmount(Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()] + "Netive")));
							else
								payStatus.setTotalAmount(Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()])));
				                payStatus.setDiscountAmount(payStatus.getTotalAmount());
				                payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
				                //System.out.println("payStatus="+payStatus.toString()); 
				                payStatusDAO.attachDirty(payStatus);
		    	         }else {
		    	        	    payStatus.setAttemptSection(0);
				    	        payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
				    	        payStatus.setTotalAmount(0);
				    	        payStatus.setTotalEntry(0);
				    	        payStatus.setDiscountAmount(0);
				    	        payStatusDAO.attachDirty(payStatus);
		    	               }
						
		    	 
		    	 
		    	 
		       }else {
		    	       payStatus.setAttemptSection(0);
		    	       payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
		    	       payStatus.setTotalAmount(0);
		    	       payStatus.setTotalEntry(0);
		    	       payStatus.setDiscountAmount(0);
		    	       payStatusDAO.attachDirty(payStatus);
		             }			
			return "Success";
		} else {
			     return "Unable to delete.";
		       }

	}
  
	
	@Transactional
	public Users getUser(String email) {
		
		Users user = usersDAO.findByEmail(email);				
			return user;
	}
   
	
	@Transactional
	public void updateImageTitel(FileDTO fileDTO) throws UserNotFoundException, ImageNotFoundException {
		File file = fileDetailDAO.findById(fileDTO.getFileId());
		if(file != null) {
		   file.setTitel(fileDTO.getTitel());
		   fileDetailDAO.attachDirty(file);
		  }else {
			      ErrorCode errorCode = new ErrorCode("Please contact System Admin.","User Not found.",500);
	              throw new ImageNotFoundException(errorCode);
		        }		
	}
	
	
	
	@Transactional
	public void getCategoryMap() {
		
		results = categoryDAO.getCategoryMap();		
	}
	

	@Transactional
	public List<File> getUpLoadedFileDetailOfAUser(UserDTO userDTO) {

		File fileDetail = new File();
		Users user = new Users();
		user.setUserId(userDTO.getUserid());
		fileDetail.setUsers(user);
		List<File> fileDetailList = fileDetailDAO.findByExample(fileDetail);
		return fileDetailList;
	}

	

	

	@Transactional
	public List<UserStatusDisplayDTO> getUserDateForStatusTable() {

		String sql = "SELECT ps.user_id, usr.first_name, usr.last_name, usr.club, usr.country,ps.attempt_section, ps.total_entry, ps.paying_status FROM "
				+getDBName()+".pay_status ps, "+getDBName()+".users usr "
				+ "where ps.user_id=usr.user_id and attempt_section > 0";

		List<UserStatusDisplayDTO> userStatusDisplayDTOList = payStatusDAO.fetchSql(sql);

		return userStatusDisplayDTOList;

	}
	
	
	
	@Transactional
	public Map<String,List<?>> getPaystatusCountryWise() {

		/*String sql = "select dset1.country, \n" + 
				"CASE WHEN dset1.paying_status='Paid' THEN dset1.user_cnt ELSE 0 END 'paid', \n" + 
				"CASE WHEN dset1.paying_status='Being Check' THEN dset1.user_cnt ELSE 0 END 'unpaid' \n" + 
				"from \n" + 
				"(\n" + 
				"select usr.country, pst.paying_status, count(pst.user_id) user_cnt from \n" + 
				getDBName()+".pay_status pst inner join "+getDBName()+".users usr \n" + 
				"on pst.user_id=usr.user_id group by usr.country, pst.paying_status\n" + 
				") dset1 ";*/
		
		
		String sql = "select dset1.country, \n" + 
				"CASE WHEN dset1.paying_status='Paid' and dset1.role='participate' THEN dset1.user_cnt ELSE 0 END 'paid', \n" + 
				"CASE WHEN dset1.paying_status='Being Check' and dset1.role='participate' THEN dset1.user_cnt ELSE 0 END 'unpaid' \n" + 
				"from \n" + 
				"(\n" + 
				"select usr.country, usr.role, pst.paying_status, count(pst.user_id) user_cnt from \n" + 
				getDBName()+".pay_status pst inner join "+getDBName()+".users usr \n" + 
				"on pst.user_id=usr.user_id group by usr.country, usr.role, pst.paying_status\n" + 
				") dset1 ";

		//List<PaystatusGraphDTO> paystatusGraphDTOList = payStatusDAO.fetchSql(sql);
		List<PaystatusGraphDTO> paystatusGraphDTOList =usersDAO.fetchSqlforGraph(sql);
		
		//System.out.println("paystatusGraphDTOList="+paystatusGraphDTOList);
		
		Map<String,List<?>> map = commonService.formatGraphData(paystatusGraphDTOList);

		return map;

	}
	

	@Transactional
	public int getDiscountPersent(UserDTO userDTO) {

		DiscountData discountData = new DiscountData();
		discountData.setUsers(usersDAO.findById(userDTO.getUserid()));
		@SuppressWarnings("unchecked")
		List<DiscountData> discountDataList = discountDataDAO.findByExample(discountData);
		if (discountDataList.size() > 0) {
			return discountDataList.get(0).getDiscountPersent();
		}

		return 0;

	}

	@Transactional
	public String getPassword(GetPassword getPassword) {
		String password = usersDAO.findPassword(getPassword.getEmail());
		return password;
	}
	
	@Transactional
	public List<OrganizerClub> getOrganizerClubList() {
		List<OrganizerClub> organizerClubList = organizerClubDAO.getOrganizerClubList("OrganizerClub");
		//System.out.println("organizerClubList="+organizerClubList.size());
		return organizerClubList;
	}

	@Transactional
	public String createSingleCouponeCode(String userId, String persent, Integer createorUserId, String adminEmail) {
	   Users user = usersDAO.findById(Integer.parseInt(userId));	
		if (user!=null) {		
			DiscountData discountData = user.getDiscountData();					
			if (discountData != null) {
				return "CouponCode for the user already exist for userId: " + userId;
			   } else{			
				String couponcode = commonService.createCouponCode(user.getUserId(),user.getFirstName(), user.getLastName());
				DiscountData ndiscountData = new DiscountData();
				ndiscountData.setCouponCode(couponcode);
				ndiscountData.setUsers(user);
				ndiscountData.setDiscountPersent(Integer.parseInt(persent));
				ndiscountData.setCreatedBy(createorUserId);
				discountDataDAO.persist(ndiscountData);
				// commonService.sendCreateCouponCodeMailforaUser(user,couponcode,adminEmail);
				return "CouponCode Created for userID: " + userId;
			}
		} else {
			return "UserId Not Found";
		}
	
	}
	
	
	@Transactional
	public HashMap<String,List<FileDTO>> getAllImagesOfaUser(String userId) throws ApplicationException , BusinessException{
		
		HashMap<String,List<FileDTO>> map = new HashMap<String, List<FileDTO>>();
		
   try {
		Users user =usersDAO.findById(Integer.parseInt(userId));
		
		if(user!=null) {
		Set<File> files = user.getFiles();
		
		if(files.size()>0) {
		    	
			for(File file : files) {				
				if(map.containsKey(file.getCategory().getCategoryName())){
					List<FileDTO>  l = map.get(file.getCategory().getCategoryName());
					 FileDTO displayFileDTO = new FileDTO();
					 displayFileDTO.setCatagoryName(file.getCategory().getCategoryName());
					 displayFileDTO.setFileId(file.getFileId());
					 displayFileDTO.setEncodedString(new String(Base64.encodeBase64( file.getFile())));
					 displayFileDTO.setPositionName(file.getCategoryIndex());
					 displayFileDTO.setTitel(file.getTitel());
					 displayFileDTO.setEditable(true);
					 l.add(displayFileDTO);
					 map.put(file.getCategory().getCategoryName(), l);
				  }
				else {
					   List<FileDTO>  l  = new ArrayList<FileDTO>();
					   FileDTO displayFileDTO = new FileDTO();
						 displayFileDTO.setCatagoryName(file.getCategory().getCategoryName());
						 displayFileDTO.setFileId(file.getFileId());
						 displayFileDTO.setEncodedString(new String(Base64.encodeBase64( file.getFile())));
						 displayFileDTO.setPositionName(file.getCategoryIndex());
						 displayFileDTO.setTitel(file.getTitel());
						 displayFileDTO.setEditable(true);
					     l.add(displayFileDTO);
					   map.put(file.getCategory().getCategoryName(), l);
				     }				
			    }			
		  }
		}else {
			    ErrorCode errorCode = new ErrorCode("Please contact System Admin.","User Not found.",500);
			    throw new UserNotFoundException(errorCode);
		      }
		}catch(NumberFormatException ex) {
			                               ErrorCode errorCode = new ErrorCode("Please contact System Admin.","NumberFormatException",500);		                               
			                                throw new ApplicationException(errorCode);
		                                 }
		
		return map;
	}
	

	@Transactional
	public void createClubCouponeCode(String clubName, String persent, Integer createorUserId, String adminEmail) {
		Users user = new Users();
		user.setClub(clubName);
		List<Users> usersList = usersDAO.findByExample(user);
					
		for (Users u : usersList) {
			 
			DiscountData discountData = u.getDiscountData();
			
			if(discountData==null) {
				 
				System.out.println("IN if");
				
				String couponcode = commonService.createCouponCode(u.getUserId(),u.getFirstName(), u.getLastName());
				DiscountData ndiscountData = new DiscountData();
				ndiscountData.setCouponCode(couponcode);
				ndiscountData.setUsers(u);
				ndiscountData.setDiscountPersent(Integer.parseInt(persent));
				ndiscountData.setCreatedBy(createorUserId);
				discountDataDAO.persist(ndiscountData);
				//commonService.sendCreateCouponCodeMailforaUser(u,couponcode,adminEmail);
			  }else {
				      
					  discountData.setDiscountPersent(Integer.parseInt(persent));
					  //ndiscountData.setCreatedBy(createorUserId);					  
					  discountDataDAO.attachDirty(discountData);
					  //commonService.sendCreateCouponCodeMailforaUser(u,discountData.getCouponCode(),adminEmail);
				      
			        }
			
		    }
		
	}


	
	@Transactional
	public void updateUserDataByEditTable(EditTableDataDTO editTableDataDTO) throws BusinessException {
		
		
		if(editTableDataDTO!= null) {
			
		Users user = usersDAO.findById(editTableDataDTO.getUserId());
		
		if(user!=null) {
		
		user.setAddress(editTableDataDTO.getAddress());
		user.setCity(editTableDataDTO.getCity());
		user.setState(editTableDataDTO.getState());
		user.setClub(editTableDataDTO.getClub());
		user.setFirstName(editTableDataDTO.getFirstName());
		user.setLastName(editTableDataDTO.getLastName());
		if(user.getPayStatus()!=null) {
		PayStatus payStatus = user.getPayStatus(); 
		payStatus.setPayingStatus(editTableDataDTO.getPayingStatus());
		user.setPayStatus(payStatus);
		usersDAO.attachDirty(user);
		}else {
			   ErrorCode errorCode = new ErrorCode("Please contact System Admin.","Paystatus record is not found for this user while updating User.",500);
			   throw new UserNotFoundException(errorCode);
		      }
		}else {
			   ErrorCode errorCode = new ErrorCode("Please contact System Admin.","User record is not found for this user while updating User.",500);
			   throw new PayStatusNotFoundException(errorCode);
		}
		}
	}
	
	
	
	
	@Transactional
	public List<ClubDTO> getClubData() {
		

		String sql = "SELECT club, count(user_id) members_count FROM "+getDBName()+".users where role!='admin' and club != '' group by club";
		List<ClubDTO> clubList = usersDAO.fetchSql(sql);
		return clubList;
	}

	@Transactional
	public File getImageData(Integer imageId) {

		File fileDetail = new File();
		fileDetail.setFileId(imageId);
		List<File> fileDetailList = fileDetailDAO.findByExample(fileDetail);
		return fileDetailList.get(0);
	}
	
	@Transactional
	public File getFile(Integer imageId) {
		
		
		return fileDetailDAO.findById(imageId);
		
	}
	
	
	@Transactional
	public List<EditTableDataDTO> getEditTableData() {
		List<Users> userList = usersDAO.getAllUsersList("Users");
		
		//System.out.println("userList.size="+userList.size());
		List<EditTableDataDTO> editTableDataDTOList = new ArrayList();
		if(userList.size() > 0) {
		  for(Users users : userList) {
			  if(users.getRole().equals("participate")) {
			  EditTableDataDTO editTableDataDTO = new EditTableDataDTO(); 
			  
			  editTableDataDTO.setUserId(users.getUserId());
			  editTableDataDTO.setFirstName(users.getFirstName());
			  editTableDataDTO.setLastName(users.getLastName());
			  editTableDataDTO.setAddress(users.getAddress());
			  editTableDataDTO.setCity(users.getCity());
			  editTableDataDTO.setCountry(users.getCountry());
			  editTableDataDTO.setState(users.getState());
			  editTableDataDTO.setClub(users.getClub());
			  editTableDataDTO.setEmail(users.getEmail());
			  if(users.getPayStatus()!=null)
			     editTableDataDTO.setPayingStatus(users.getPayStatus().getPayingStatus()); 
			     editTableDataDTOList.add(editTableDataDTO);
			 }
		  }
		}
		
		//for(EditTableDataDTO editTableDataDTO:  editTableDataDTOList)
			//System.out.println("editTableDataDTOList="+editTableDataDTOList.toString());
		
		return editTableDataDTOList;		
	}
	
	@Transactional
	public String createJudge(JudgeCreationDTO judgeRegistrationDTO, UserDTO userDTO, String token, String judgeRegisterUrl) throws IOException, MessagingException {
		
		OrganizerClub organizerClub = organizerClubDAO.findByOrganizerClubName(judgeRegistrationDTO.getOrganizerclubName());
		Users user = usersDAO.findById(userDTO.getUserid());
		Users judge = new Users();
		judge.setUserId(commonUtil.getUserId());
		judge.setEmail(judgeRegistrationDTO.getEmail());
		judge.setFirstName(judgeRegistrationDTO.getFirstname());
		judge.setLastName(judgeRegistrationDTO.getLastname());
		judge.setJudgeOrganizerClub(organizerClub);
		judge.setCreatedOn(commonUtil.sqlDateTime());
		judge.setLastLoggin(commonUtil.sqlDateTime());
		judge.setJudgeRegistrationToken(token);
		judge.setCreatedBy(String.valueOf(user.getUserId()));
		judge.setRole("judge");
		if(judgeRegistrationDTO.getCategory().size()>0) {
			Set<Category> categorySet = new HashSet<>();
			for(String categoryName : judgeRegistrationDTO.getCategory()) {
				if(results.containsKey(categoryName)){
				   Category category = new Category();
				   category.setCategoryName(categoryName);
				   category.setCategoryId(results.get(categoryName));
				   categorySet.add(category);
				  }
			   }
			judge.setJudgeCategoryMapping(categorySet);
		   }
		
		
		int id = usersDAO.persist(judge);
		
		
		if (id > 0) {
			          commonService.sendJudgeRegistrationURLMail(judgeRegisterUrl, judgeRegistrationDTO.getEmail());			            
			          return "ok";			          
		            }
		else {
			   return "not ok";
		     }
		
	}
	
	
	@Transactional
	public void updateJudgeTableData(JudgeTableDTO judgeTableDTO, UserDTO userDTO) {
		
		Users judge = usersDAO.findById(judgeTableDTO.getJudgeId());
	
		judge.setFirstName(judgeTableDTO.getJudgeFirstname());
		judge.setLastName(judgeTableDTO.getJudgeLastname());
		judge.setCreatedOn(commonUtil.sqlDateTime());
		Map<String, String> categoryMap = judgeTableDTO.getCategory();
		Set<Category> categorySet = new HashSet<>();
		for(Map.Entry<String,String> entry : categoryMap.entrySet()) {						
			   if(entry.getValue().toUpperCase().equals("Y")) {
			   Category category = new Category();
			   category.setCategoryName(entry.getKey());
			   category.setCategoryId(results.get(entry.getKey()));
			   categorySet.add(category);
			   //System.out.println("category="+category.toString());
			  }
			
		   }
		
		judge.setJudgeCategoryMapping(categorySet);
		judge.setCreatedBy(String.valueOf(userDTO.getUserid()));
		judge.setLastLoggin(commonUtil.sqlDateTime());
		if(judgeTableDTO.getOrganizerclubName()!=null) {
			OrganizerClub organizerClub = organizerClubDAO.findByOrganizerClubName(judgeTableDTO.getOrganizerclubName());
		    judge.setJudgeOrganizerClub(organizerClub);
		}
		System.out.println("judge="+judge.toString());
		usersDAO.attachDirty(judge);
		
	}


	@Transactional
	public Users getJudge(String email) {
		
		Users judge = usersDAO.findByEmail(email);	
		return judge;
		
		}
	
	
	
	@Transactional
	public Users getJudgeforRegister(String judgeRegisterURLToken) {
		Users judge = usersDAO.findJudgeByRegisterURLToken(judgeRegisterURLToken);
		return judge;
	}
	
	@Transactional
	public Judge getJudgeforChangePassword(String forgetPasswAuthToken) {
		Judge judge = judgeDAO.findByforgetPasswAuthToken(forgetPasswAuthToken);
		return judge;
	}
	
	@Transactional
	public void registerJudge(Users judge, JudgeRegisterDTO judgeRegisterDTO ) {
		if(judge != null)
		  {
			judge.setJudgeRegistrationToken(null);
			judge.setAddress(judgeRegisterDTO.getJudgeAddress());
			judge.setCity(judgeRegisterDTO.getJudgeCity());
			judge.setState(judgeRegisterDTO.getJudgePin());
			judge.setCountry(judgeRegisterDTO.getJudgeCountry());
			String pass = judgeRegisterDTO.getJudgePassword();
			judge.setPassword(bCryptPasswordEncoder.encode(judgeRegisterDTO.getJudgePassword()));
			judge.setLastLoggin(commonUtil.sqlDateTime());			
			usersDAO.attachDirty(judge);
			try {
				  commonService.sendJudgeRegistrationConfirmMail(judge, pass);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		  }	
		
		System.out.println("judge="+judge.toString());
	}
	
	@Transactional
	public List<String> getCategoryListofaJudge(int id) {
		
		Users judge = usersDAO.findById(id);
		Set<Category> categorySet = judge.getJudgeCategoryMapping();
		List<String> categoryList = new ArrayList();
		if (categorySet.size() > 0 ) {
		    for(Category c : categorySet) {
		    	categoryList.add(c.getCategoryName());
		       }
		   }
		
		return categoryList;
	}
	
	@Transactional
	public List<JudgeTableDTO> getJudgeTableData() {
		
		List<JudgeTableDTO> judgeTableData = new ArrayList<>();
		
		Optional<List<Users>> judgeList = usersDAO.findUserByRole("judge");
		
		 //if(judgeList.size()>0) {
		if(judgeList.isPresent()) {			
		   for(Users u : judgeList.get()) {
			   JudgeTableDTO judgeTableDTO = new JudgeTableDTO();
			   judgeTableDTO.setJudgeId(u.getUserId());
			   judgeTableDTO.setJudgeEmail(u.getEmail());
			   judgeTableDTO.setJudgeAddress(u.getAddress());
			   judgeTableDTO.setJudgeCity(u.getCity());
			   judgeTableDTO.setJudgeCountry(u.getCountry());
			   judgeTableDTO.setJudgeFirstname(u.getFirstName());
			   judgeTableDTO.setJudgeLastname(u.getLastName());
			   judgeTableDTO.setOrganizerclubName(u.getJudgeOrganizerClub().getOrganizerclubname());
			  		   
			   Set<Category> catmap = u.getJudgeCategoryMapping();
			   if(catmap.size() > 0) {
				   Map<String, String> catagoryMap = new HashMap<>();	
				   List<String> cl = new ArrayList<>(); 
				   for(Category c : catmap) {
					   cl.add(c.getCategoryName());
				      }
				   //judgeTableDTO.setCategory(cl);
				   for(Map.Entry e : results.entrySet()) {
					   if(!cl.contains(e.getKey()))
						  catagoryMap.put((String) e.getKey(), "N");
					   else
						   catagoryMap.put((String) e.getKey(), "Y");
				      }
				   
				   judgeTableDTO.setCategory(catagoryMap);
				   //System.out.println("judgeTableDTO="+judgeTableDTO.toString());
			     }
			   judgeTableData.add(judgeTableDTO);
		      }	
		  }	
		return judgeTableData;		
	}
	
	
	
	@Transactional
	public String savePaymentResponse(PayPalPaymentResponseDTO payPalPaymentResponseDTO, Users user) throws ParseException {
		
		ResponseDTO responseDTO = new ResponseDTO();
		String responce = "";
		if(payPalPaymentResponseDTO !=null) {
		PaymentResponse paymentResponse = new PaymentResponse();
		
        if(payPalPaymentResponseDTO.getParentPaymentId() != null && payPalPaymentResponseDTO.getPaymentAmount()!=null && 
           payPalPaymentResponseDTO.getPaymentCurrency()!=null && payPalPaymentResponseDTO.getTransactionsRelatedresourcesSaleCreatetime()!=null &&	
           payPalPaymentResponseDTO.getTransactionsRelatedresourcesSaleUpdatetime()!=null && payPalPaymentResponseDTO.getTransactionsRelatedresourcesSaleState()!=null &&
           payPalPaymentResponseDTO.getPayerPayerinfoEmail()!=null && payPalPaymentResponseDTO.getPayerPayerinfoName()!=null &&
           payPalPaymentResponseDTO.getTransactionsResponse()!=null && payPalPaymentResponseDTO.getUserid()!=null) {// check all the fields are available	    
		       paymentResponse.setId(payPalPaymentResponseDTO.getParentPaymentId());		  
		       paymentResponse.setTranssectionAmount(payPalPaymentResponseDTO.getPaymentAmount());
		       paymentResponse.setTranssectionCourency(payPalPaymentResponseDTO.getPaymentCurrency());
		       paymentResponse.setCreatedTime(payPalPaymentResponseDTO.getTransactionsRelatedresourcesSaleCreatetime());
		       paymentResponse.setUpdateTime(payPalPaymentResponseDTO.getTransactionsRelatedresourcesSaleUpdatetime());
		       paymentResponse.setState(payPalPaymentResponseDTO.getTransactionsRelatedresourcesSaleState());
		       paymentResponse.setPayerEmail(payPalPaymentResponseDTO.getPayerPayerinfoEmail());
		       paymentResponse.setPayerName(payPalPaymentResponseDTO.getPayerPayerinfoName());
		       paymentResponse.setPaymentResponse(payPalPaymentResponseDTO.getTransactionsResponse());
		       paymentResponse.setUserId(payPalPaymentResponseDTO.getUserid());
		       
		       String id = paymentResponseDAO.persist(paymentResponse);
		       
		       if (id.equals(payPalPaymentResponseDTO.getParentPaymentId())) {
					PayStatus payStatus = user.getPayStatus();
					payStatus.setPayingStatus("Paid");
					user.setPayStatus(payStatus);
					usersDAO.attachDirty(user);
					responce ="Payment process sucessful";
				   }
				else {
					  responce ="Find Problems in server response,"+"\n"
					   		     +"Kindly mail your payment recipt at: "+"\n"
							     +"microcircuit.asia@gmail.com";
					  
				     }
           }else {
        	        responce ="Find problems in payment response,"+"\n"
			   		     +"Kindly mail your payment recipt at: "+"\n"
					     +"microcircuit.asia@gmail.com";
                 }
        	
		}else {
			    responce ="Payment process fail";
		      }
		
		return responce;
	}
	
	
	
	@Transactional
	public String getImageTitelList(UserDTO userDTO) {
		
		Users user = usersDAO.findById(userDTO.getUserid());
		String response="";
		
		String sql = "SELECT titel, category_index FROM "+getDBName()+".file where user_id='"+user.getUserId()+"'";			
		List<UserFileTitelListDTO> findTitelListAndCategoryIndex = fileDetailDAO.findTitelListAndCategoryIndex(sql);
		if(findTitelListAndCategoryIndex.size()>0) {
			try {
				  commonService.sendEntryConfirmMail(user, findTitelListAndCategoryIndex,results, user.getPayStatus().getPayingStatus());
			    } catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response = "Mail send to your register mail id";			
		  }
		else {
			   response = "File is not uploaded yet";
		     }
		
		
		//for(UserFileTitelListDTO f : findTitelListAndCategoryIndex)
		//System.out.println(f.toString());			
		return response;
		
	}
	
	@Transactional
	public void selectAllImageCategoryWise(String payingStatus) throws IOException {
		System.out.println("I am fulty not calling");
	  	Category category = null;
	  	//Map<String ,List<File>> fileProcessDataList = new HashMap<>();
	  	Map<String ,List<Integer>> fileProcessDataList = new HashMap<>();
	  	List<String> catagoryNameList = new ArrayList<String>();
	  	List<Integer> categoryIdList = new ArrayList<>();
	  	List<File> fileProcessData = null;
		if (results.size()>0){			
			//for (Map.Entry<String,Integer> entry : results.entrySet()){							
				category = new Category();
				category.setCategoryId(4);
				category.setCategoryName("phototravel");
				/*category.setCategoryId(entry.getValue());
				category.setCategoryName(entry.getKey());
				catagoryNameList.add(entry.getKey());*/
				if(!payingStatus.equals("Paid")) {
				   categoryIdList=fileDetailDAO.findListOfFileIdOfCategory(category, null);
				    //fileProcessData = fileDetailDAO.getFileProcessData(category);
				   //System.out.println("fileProcessData="+categoryIdList.size());
				   
				 }else {
					      categoryIdList=fileDetailDAO.findListOfFileIdOfCategory(category, "Paid");					     
				       }
				
				
				
				
				   if(categoryIdList!=null && categoryIdList.size() >0)
				      fileProcessDataList.put("phototravel",categoryIdList);		
			      //}
			//System.out.println("fileProcessDataList="+fileProcessDataList.size());
		   }else{
		          System.out.println("File Not Found");
		        }
		
			System.out.println("I am going to save image");
			commonService.deleteExistingDirectory(results);
		    commonService.processImage(fileProcessDataList, catagoryNameList);
		
	}
	
	
	public Map<String, TreeSet<Integer>> processJudgingFile() throws IOException {		
		  Map<String, TreeSet<Integer>> imageIdMap = new HashMap<>();
			for (Map.Entry<String,Integer> entry : results.entrySet()){	
	             TreeSet<Integer>  idList = commonService.getSavedFileId(configProperty.getBasePath()+"/" + entry.getKey()); 
	             if(idList!=null && idList.size()>0)
	                imageIdMap.put(entry.getKey(), idList);
			    }
			
			return imageIdMap;
		  }
	
	
	@Transactional
	public String processJudgingData(String payingStatus) throws IOException {
		
	List<ImageRating> imageRatingList = new ArrayList<>();
	ImageRating imageRating = null;//.imageRating.new ImageRating();	
	 
	String responce=""; 
	Optional<List<Users>> judgeList =  usersDAO.findUserByRole("judge");
	Optional<List<Users>> adminList =  usersDAO.findUserByRole("admin");
	List<OrganizerClub> organizerClubList = organizerClubDAO.getOrganizerClubList("OrganizerClub");
	
		
	//check min-number of judges are ctrated for all club
	responce=commonService.judgeCreationStatus(judgeList,adminList,organizerClubList);	
	if(responce.length()==0) {
		//check all judes registration done for all club
		responce=commonService.judgeRegistrationStatus(judgeList,adminList,organizerClubList);
		//if(responce.length()==0) {
		/*if(imageRatingDAO.getCount()>0)
			imageRatingDAO.truncate(getDBName()+".image_rating");*/
		    //selectAllImageCategoryWise(payingStatus);
		    processJudgingFile();
			Map<Integer, List<String>> map=commonService.findCategoryForJudge(judgeList);
			Map<String, TreeSet<Integer>> imageIdMap =  processJudgingFile();
			if(map.size()>0) {
			  for(Map.Entry<Integer, List<String>> entry : map.entrySet()) {
				  List<String> judgeCatecoryList = entry.getValue();
				  for(String categoryName: judgeCatecoryList) {					  
					  TreeSet<Integer> categoryIdList = imageIdMap.get(categoryName);
					  if(categoryIdList!=null){
					  for(Integer imageid:categoryIdList) {
						   imageRating = new ImageRating();
						   imageRating.setFile(fileDetailDAO.findById(imageid));
						   imageRating.setJudgeId(entry.getKey());
						   imageRatingDAO.attachDirty(imageRating);						             
					      }
					    }
				     }					
				   }
			
			     }else {
			    	     responce ="judge process sucessful";
			    	     return responce;
			    	   }
	       // }
		  //}	
	  }	
	  return responce;
	}
	
	
	
	@Transactional
	public List<OrganizerClubDTO> getOrganizerClubDTOList() {
		List<OrganizerClubDTO> organizerClubDTOList = new ArrayList<>();
		List<OrganizerClub> organizerClubList=organizerClubDAO.getOrganizerClubList("OrganizerClub");
		if(organizerClubList.size()>0) {
			for(OrganizerClub organizerClub: organizerClubList) {
				OrganizerClubDTO organizerClubDTO = new OrganizerClubDTO();
				organizerClubDTO.setOrganizerClubId(organizerClub.getOrganizerclubid());
				organizerClubDTO.setOrganizerClubName(organizerClub.getOrganizerclubname());
				organizerClubDTOList.add(organizerClubDTO);
			   }
		}
		
		return organizerClubDTOList;
		
	}
	
	@Transactional
	public boolean getResultDataProcessStatus() {
		
		System.out.println("SIZE="+imageRatingDAO.getCount());
		if(imageRatingDAO.getCount()==0)
		   return true;			
		   return false;		
	}
	
	@Transactional
	public Map<String,String> getParticipentCount(Map<String,String> map) {
		//JudgeFileProcessDropDownDTO paid = new JudgeFileProcessDropDownDTO();
		/*paid.setCount("Paid");
		paid.setStatement("paid participant count: "+payStatusDAO.getTotalPaidPerticipentCount("Paid"));
		list.add(paid);
		
		JudgeFileProcessDropDownDTO all = new JudgeFileProcessDropDownDTO();
		all.setCount("All");
		all.setStatement("all perticipent count: "+usersDAO.getTotalPerticipentCount("participate"));
		list.add(all);*/
		
		map.put("Paid", "paid participant count: "+payStatusDAO.getTotalPaidPerticipentCount("Paid"));
		map.put("All", "all perticipent count: "+usersDAO.getTotalPerticipentCount("participate"));
		
		return map;
	}
	
	
	@Transactional
	public Map<String ,List<File>> getPaidUsersFileListCategoryWise(String payingStatus ) {
		 Map<String ,List<File>> fileProcessDataList = new HashMap<>();		
		 List<PayStatus> idList = payStatusDAO.paidUserId(payingStatus);
		 if(idList.size()>0) {
			for(PayStatus payStatus : idList) {
				if(payStatus.getUsers().getFiles()!=null) {
					for(File file: payStatus.getUsers().getFiles()) {
						if(fileProcessDataList.containsKey(file.getCategory().getCategoryName())) {
				    	    List<File> f = fileProcessDataList.get(file.getCategory().getCategoryName());
				    	    f.add(file);
				    		fileProcessDataList.put(file.getCategory().getCategoryName(), f);   
				    	    }
				    	 else {
				    		    List<File> f = new ArrayList<>();
				    		    f.add(file);
				    		    fileProcessDataList.put(file.getCategory().getCategoryName(), f);
				    	      }		
					   }
				  }
			   }
		     }
		
	     return fileProcessDataList;
	}
	
	
	@Transactional
	public void updateImageReating(List<DisplayReatingImageDTO> displayReatingImageDTOList,UserDTO userDTO) throws IOException {
		ImageRating imageRating = new ImageRating();
		
		imageRating.setJudgeId(userDTO.getUserid());
		for(DisplayReatingImageDTO displayReatingImageDTO : displayReatingImageDTOList){
		File file = fileDetailDAO.findById(displayReatingImageDTO.getImageId());
		imageRating.setFile(file);
		Optional<ImageRating> imageRating1 = imageRatingDAO.getImageRating(imageRating);
		
		if(imageRating1.isPresent()) {
			ImageRating imageRating2 = imageRating1.get();
			imageRating2.setRating(displayReatingImageDTO.getReating());
			imageRatingDAO.attachDirty(imageRating2);
		   }		
	     }
	}
	
	
	@Transactional
	public boolean getImageReatingStatus() throws IOException {
		if(imageRatingDAO.getCount()==0)
		   return true;
		
		return false;
		
	}
	
	
	@Transactional
	public Optional<List<ReatingStatusTableDTO>> getRoundOneJuddingStatus() throws IOException {
		int zeroReatedImageCount=0, nonZeroReatedImageCount=0, sectionWiseTotalCount=0;
		Map<String, TreeSet<Integer>> imageIdMap =  processJudgingFile();
		ReatingStatusTableDTO reatingStatusTableDTO = null;
		List<ReatingStatusTableDTO> list = new ArrayList<>();
		
		
		Optional<List<Users>> judgeList =  usersDAO.findUserByRole("judge");
				
		 if(judgeList.isPresent()) {			   
			  for(Users user : judgeList.get()) { 
				  Optional<List<ImageRating>> ratingList = imageRatingDAO.getRettinStatusofAJudge(user.getUserId());
				  Map<Integer, Integer> reatingMap = commonUtil.createImageReatingMap(ratingList);
				  Set<Category> categoryList = user.getJudgeCategoryMapping();
				  for(Category category:  categoryList) {
					  if(imageIdMap.containsKey(category.getCategoryName())){							
							TreeSet<Integer> ilist =	imageIdMap.get(category.getCategoryName());
							for(Integer imageId : ilist) {
								sectionWiseTotalCount=sectionWiseTotalCount+1;
								if(reatingMap.containsKey(imageId) && reatingMap.get(imageId)>0) {
									nonZeroReatedImageCount=nonZeroReatedImageCount+1;
								  }
								else if(reatingMap.containsKey(imageId) && reatingMap.get(imageId)==0) {
									     zeroReatedImageCount=zeroReatedImageCount+1 ;
								       }
							   }
							reatingStatusTableDTO = new ReatingStatusTableDTO();
							reatingStatusTableDTO.setClubName(user.getJudgeOrganizerClub().getOrganizerclubname());
							reatingStatusTableDTO.setJudgeName(user.getFirstName()+" "+user.getLastName());
							reatingStatusTableDTO.setCategoryName(category.getCategoryName());
							reatingStatusTableDTO.setTotalImageCount(""+sectionWiseTotalCount);
							reatingStatusTableDTO.setReatedImageCount(""+nonZeroReatedImageCount);
							reatingStatusTableDTO.setUnreatedImageCount(""+zeroReatedImageCount);
							list.add(reatingStatusTableDTO);
							zeroReatedImageCount=0; 
							nonZeroReatedImageCount=0;
							sectionWiseTotalCount=0;
						  }
				     }
				  
				  
				  
			     }
		 }
		return Optional.of(list);
		
	}
	
}



