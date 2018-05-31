package com.photo.contest.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dao.CategoryDAO;
import com.photo.contest.dao.DiscountDataDAO;
import com.photo.contest.dao.FileDetailDAO;
import com.photo.contest.dao.PayStatusDAO;
import com.photo.contest.dao.UsersDAO;
import com.photo.contest.dto.CategoryCountMap;
import com.photo.contest.dto.ClubDTO;
import com.photo.contest.dto.DisplayFileDTO;
import com.photo.contest.dto.EditTableDataDTO;
import com.photo.contest.dto.FileDTO;
import com.photo.contest.dto.GetPassword;
import com.photo.contest.dto.Login;
import com.photo.contest.dto.LogingResponseDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.dto.UserStatusDisplayDTO;
import com.photo.contest.exception.BusinessException;
import com.photo.contest.exception.ErrorCode;
import com.photo.contest.exception.PayStatusNotFoundException;
import com.photo.contest.exception.UserNotFoundException;
import com.photo.contest.model.Category;
import com.photo.contest.model.DiscountData;
import com.photo.contest.model.File;
import com.photo.contest.model.PayStatus;
import com.photo.contest.model.Users;
import com.photo.contest.utility.CommonUtil;


@Service
public class DbServices {
	
	static Map<String, Integer> results = new HashMap<String, Integer>();
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

	@Transactional
	public Users saveUserData(UserDTO userDTO) throws IOException {
		Users users = new Users();
		users.setUserId(commonUtil.getUserId());
		users.setFirstName(userDTO.getFirstname());
		users.setLastName(userDTO.getLastname());
		users.setGender(userDTO.getGender());
		users.setAddress(userDTO.getAddress());
		users.setCity(userDTO.getCity());
		users.setState(userDTO.getPin());
		users.setCountry(userDTO.getCountry());
		users.setClub(userDTO.getClub());
		users.setHoner(userDTO.getHoner());
		users.setEmail(userDTO.getEmail());
		users.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		users.setCreatedOn(commonUtil.sqlDateTime());
		users.setLastLoggin(commonUtil.sqlDateTime());
		users.setRole("participate");
		
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
		
		return users;
		
		// commonService.sendRegistrationConfirmMail(users);
		//System.out.println(users.toString());
	}

/*	@Transactional
	public List<Users> getUserData(Login login) throws IOException {
		Users users = new Users();
		users.setEmail(login.getUsername());
		users.setPassword(login.getPassword());
		@SuppressWarnings("unchecked")
		List<Users> userData = usersDAO.findByExample(users);
		return userData;

	}*/

	
	@Transactional
	public LogingResponseDTO getUserData(Login login) throws IOException {
		
		LogingResponseDTO logingResponseDTO = new LogingResponseDTO(); 
		
		Users users = new Users();
		users.setEmail(login.getUsername());
		users.setPassword(login.getPassword());
		@SuppressWarnings("unchecked")
		List<Users> userData = usersDAO.findByExample(users);
		
		if(userData.size()==1) {
			logingResponseDTO.setUser(userData.get(0));						
			Users currentUser = userData.get(0);
			Set<File> fileSet = currentUser.getFiles();
					
		 if( fileSet.size()>0 && currentUser.getRole().equals("participate")) {
			 HashMap<String,DisplayFileDTO> hm = new HashMap<String, DisplayFileDTO>();
			 for(File file : fileSet) {
				 DisplayFileDTO displayFileDTO = new DisplayFileDTO();
				 displayFileDTO.setCatagoryName(file.getCategory().getCategoryName());
				 displayFileDTO.setFileId(file.getFileId());
				 displayFileDTO.setEncodedString(new String(Base64.encodeBase64( file.getFile())));
				 displayFileDTO.setPositionName(file.getCategoryIndex());
				 displayFileDTO.setTitel(file.getTitel());
				 
				 hm.put(file.getCategory().getCategoryName()+file.getCategoryIndex(), displayFileDTO);				 
			    }
			 logingResponseDTO.setHm(hm);					
			
		   }else {
			       logingResponseDTO.setHm(new HashMap<String, DisplayFileDTO>() );
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
	public LogingResponseDTO getUserData(String email) throws IOException {
		
		LogingResponseDTO logingResponseDTO = new LogingResponseDTO(); 
		
		Users users = new Users();
		users.setEmail(email);
		/*users.setPassword(login.getPassword());*/
		@SuppressWarnings("unchecked")
		List<Users> userData = usersDAO.findByExample(users);
		
		if(userData.size()==1) {
			logingResponseDTO.setUser(userData.get(0));						
			Users currentUser = userData.get(0);
			Set<File> fileSet = currentUser.getFiles();
					
		 if( fileSet.size()>0 && currentUser.getRole().equals("participate")) {
			 HashMap<String,DisplayFileDTO> hm = new HashMap<String, DisplayFileDTO>();
			 for(File file : fileSet) {
				 DisplayFileDTO displayFileDTO = new DisplayFileDTO();
				 displayFileDTO.setCatagoryName(file.getCategory().getCategoryName());
				 displayFileDTO.setFileId(file.getFileId());
				 displayFileDTO.setEncodedString(new String(Base64.encodeBase64( file.getFile())));
				 displayFileDTO.setPositionName(file.getCategoryIndex());
				 displayFileDTO.setTitel(file.getTitel());
				 
				 hm.put(file.getCategory().getCategoryName()+file.getCategoryIndex(), displayFileDTO);				 
			    }
			 logingResponseDTO.setHm(hm);					
			
		   }else {
			       logingResponseDTO.setHm(new HashMap<String, DisplayFileDTO>() );
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
	public Integer saveFileData(FileDTO fileDTO, UserDTO userDTO) throws IOException {

		File fileDetail = new File();	
		String[] arry = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		int totalNimberofEntry = 0;
		Users user = usersDAO.findById(userDTO.getUserid());

		Category catagory = new Category();
		catagory.setCategoryId(results.get(fileDTO.getCatagoryName()));
		
		fileDetail.setUsers(user);
		fileDetail.setTitel(fileDTO.getTitel());
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
				           List<CategoryCountMap> fileDetailList = fileDetailDAO.getCategoryWiseFileCount(fileDetail);
				           
				           
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
	
	
	
	//@Transactional
		/*public void updatePayStatusforNonZeroEntry(PayStatus payStatus, List<CategoryCountMap> fileDetailList) {
			System.out.println("I am in a writre palce");
			int totalNimberofEntry = 0;
			String[] arry = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
			PayStatus updatedpayStatus = new PayStatus();
			updatedpayStatus.setPayId(payStatus.getPayId());

			if (fileDetailList.size() > 0) {
				for (CategoryCountMap c : fileDetailList) {
					totalNimberofEntry = totalNimberofEntry + c.getFile_id();
				}
				updatedpayStatus.setAttemptSection(fileDetailList.size());
				updatedpayStatus.setTotalEntry(totalNimberofEntry);
				if (payStatus.getCourencyType().equals(configProperty.getNetiveCurrencyName()))
					updatedpayStatus.setTotalAmount(Integer
							.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()] + "Netive")));
				else
					updatedpayStatus.setTotalAmount(
							Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()])));

				updatedpayStatus.setDiscountAmount(updatedpayStatus.getTotalAmount());

			} else {
				updatedpayStatus.setAttemptSection(0);
				updatedpayStatus.setTotalEntry(0);
				updatedpayStatus.setTotalAmount(0);
				updatedpayStatus.setDiscountAmount(0);
			}
			updatedpayStatus.setCourencyType(payStatus.getCourencyType());
			updatedpayStatus.setCouponCodeNumber("");
			updatedpayStatus.setEntryCreatedTime(payStatus.getEntryCreatedTime());
			updatedpayStatus.setLastUpdateTime(commonUtil.sqlDateTime());
			updatedpayStatus.setUsers(payStatus.getUsers());
			updatedpayStatus.setPayingStatus("Being Check");
			updatedpayStatus.setRecivedAmont(0);
			updatedpayStatus.setRecivedCourencyType(null);
			System.out.println("updatedpayStatus=" + updatedpayStatus.toString());
			payStatusDAO.attachDirty(updatedpayStatus);
		}
	*/
	

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
		    	                    
		    	      
		    	         int section = commonUtil.getNumbrtofSection(fileset.size());
						 payStatus.setAttemptSection(section);
				         payStatus.setTotalEntry(fileset.size());
				         
				         if (payStatus.getCourencyType().equals(configProperty.getNetiveCurrencyName()))
				        	 payStatus.setTotalAmount(Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[section] + "Netive")));
							else
								payStatus.setTotalAmount(Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[section])));
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
		    	       
		             }			
			return "Success";
		} else {
			return "Unable to delete.";
		}

	}

   
	@Transactional
	public void getCategoryMap() {
		
		results = categoryDAO.getCategoryMap();
		
		//System.out.println(results);
	}
	
	/*public Integer getCategoryIDfromCategoryName(FileDTO fileDTO) {

		return categoryDAO.getCategoryID(fileDTO.getCatagoryName());
	}
*/
	

	@Transactional
	public List<File> getUpLoadedFileDetailOfAUser(UserDTO userDTO) {

		File fileDetail = new File();
		Users user = new Users();
		user.setUserId(userDTO.getUserid());
		fileDetail.setUsers(user);
		List<File> fileDetailList = fileDetailDAO.findByExample(fileDetail);
		return fileDetailList;
	}

	/*@Transactional
	public void updatePayStatusOfAUser(UserDTO userDTO) {

		Users user = new Users();
		user.setEmail(userDTO.getEmail());
		List<Users> usersList = usersDAO.findByExample(user);
		System.out.println(user.toString());
		if (usersList.size() > 0) {
			File fileDetail = new File();
			fileDetail.setUsers(user);
			List<CategoryCountMap> fileDetailList = fileDetailDAO.getCategoryWiseFileCount(fileDetail);

			PayStatus currentUserPayStatus = payStatusDAO.findByUserId(user);

			if (currentUserPayStatus == null && fileDetailList.size() == 0) { // if entry not found and number of entry
																				// zero, 1st login
				System.out.println("I am on my way ");
				savePayStatusforZeroEntry(user);
			} else if (currentUserPayStatus != null) {
				updatePayStatusforNonZeroEntry(currentUserPayStatus, fileDetailList);
			}

		}

	}*/

	//@Transactional
	/*public void savePayStatusforZeroEntry(Users user) {

		PayStatus payStatus = new PayStatus();
		payStatus.setAttemptSection(0);
		payStatus.setCouponCodeNumber("");
		List<String> netiveCountryList = Arrays.asList(configProperty.getNetiveCountry().split(","));
		if (netiveCountryList.contains(user.getCountry().toUpperCase()))
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
		payStatus.setUsers(user);
		payStatus.setPayingStatus("Being Check");
		System.out.println("payStatus=" + payStatus.toString());
		payStatusDAO.persist(payStatus);

	}*/

	

	@Transactional
	public List<UserStatusDisplayDTO> getUserDateForStatusTable() {

		String sql = "SELECT ps.user_id, usr.first_name, usr.last_name, usr.club, usr.country,ps.attempt_section, ps.total_entry, ps.paying_status "
				+ "FROM salontest.pay_status ps, salontest.users usr "
				+ "where ps.user_id=usr.user_id and attempt_section > 0";

		List<UserStatusDisplayDTO> userStatusDisplayDTOList = payStatusDAO.fetchSql(sql);

		return userStatusDisplayDTOList;

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
	
	
	/*@Transactional
	public List<String> getUserIdofCreatedCouponCode(String columnName) {

		List<DiscountData> discountDataList = discountDataDAO.findAColumn(columnName);
		List<String> existingCouponCodeList = new ArrayList();
		if (discountDataList.size() > 0) {
			for (DiscountData dd : discountDataList) {
				existingCouponCodeList.add(dd.getUsers().toString());
			}
		}
		System.out.println("existingCouponCodeList=" + existingCouponCodeList);
		return existingCouponCodeList;

	}*/
	

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
				      //System.out.println("IN else");				      
				      //DiscountData ndiscountData = new DiscountData(); 
				      //ndiscountData.setDiscountId(discountData.getDiscountId());
				      //ndiscountData.setCouponCode(discountData.getCouponCode());
					  //ndiscountData.setUsers(u);
					  discountData.setDiscountPersent(Integer.parseInt(persent));
					  //ndiscountData.setCreatedBy(createorUserId);					  
					  discountDataDAO.attachDirty(discountData);
					  //commonService.sendCreateCouponCodeMailforaUser(u,discountData.getCouponCode(),adminEmail);
				      
			        }
			
		    }
		
		
		
		
		//List<String> getUserIdofCreatedCouponCode = getUserIdofCreatedCouponCode("usrID");
	/*	for (Users u : usersList) {
			DiscountData discountData = new DiscountData();
			String couponcode = commonService.createCouponCode(u.getUserId(), u.getFirstName(), u.getLastName());
			discountData.setCouponCode(couponcode);
			discountData.setUsers(u);
			discountData.setDiscountPersent(Integer.parseInt(persent));
			discountData.setCreatedBy(createorUserId);

			if (getUserIdofCreatedCouponCode.contains(Integer.toString(u.getUserId()))) {
				System.out.println("in if ");
				DiscountData discountData_exist = new DiscountData();
				discountData_exist.setUsers(u);
				List<DiscountData> DiscountData_existList = discountDataDAO.findByExample(discountData_exist);
				discountData.setDiscountId(DiscountData_existList.get(0).getDiscountId());
				discountDataDAO.attachDirty(discountData);
				// commonService.sendCreateCouponCodeMailforaUser(u,couponcode,adminEmail);
			} else {
				    System.out.println("in if ");
				    discountDataDAO.persist(discountData);
				// commonService.sendCreateCouponCodeMailforaUser(u,couponcode,adminEmail);
			}

		}*/

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

		String sql = "SELECT club, count(user_id) members_count FROM salontest.users where role!='admin' and club != '' group by club";
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
			  editTableDataDTO.setClub(users.getClub());
			  if(users.getPayStatus()!=null)
			  editTableDataDTO.setPayingStatus(users.getPayStatus().getPayingStatus());
			  
			  editTableDataDTOList.add(editTableDataDTO);
			  }
		  }
		}
		return editTableDataDTOList;
		
	}


}



