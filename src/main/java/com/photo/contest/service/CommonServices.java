package com.photo.contest.service;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.MailRecipientDTO;
import com.photo.contest.dto.PaystatusGraphDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.dto.UserFileTitelListDTO;
import com.photo.contest.model.Category;
import com.photo.contest.model.OrganizerClub;
import com.photo.contest.model.Users;
import com.photo.contest.utility.CommonUtil;
import com.photo.contest.utility.FileCheckUtility;
import com.photo.contest.utility.HtmlData;
import com.photo.contest.utility.ImageResizeUtility;
import com.photo.contest.utility.SavelFileFromBlobUtility;

@Service
public class CommonServices {

	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	HtmlData htmlData;
	@Autowired
	SavelFileFromBlobUtility savelFileFromBlobUtility;
	@Autowired
	ImageResizeUtility imageResizeUtility;
	@Autowired
	FileCheckUtility fileCheckUtility;
	
	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}
	
	public boolean userIsNative(UserDTO userDTO) {
		List<String> netiveCountryList = Arrays.asList(configProperty.getNetiveCountry().split(","));
		if (netiveCountryList.contains(userDTO.getCountry().toUpperCase()))
			return true;
		else
			return false;

	}

	public String sendUserRegistrationConfirmMail(Users users , String password) throws MessagingException {

		String message=null;
		
		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();		
		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(users.getEmail());
		
			//mailRecipientDTO.setMessage(body.get());
		mailRecipientDTO.setMessage("Registration Sucessful \nRegistration Id:" + users.getUserId() + "\nUser Id: "
				+ users.getEmail() + "\n Password: " + password + " \n");
		mailRecipientDTO.setSubject("Registration Success");
		
		try {
			 message=  commonUtil.doSendEmail(mailRecipientDTO, null);
			  System.out.println("message="+message);
			  
		} catch (MailSendException | ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//}
		return message;
	}
	
	
	public void sendJudgeRegistrationConfirmMail(Users users , String password) throws MessagingException{

		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();

		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(users.getEmail());
		
		mailRecipientDTO.setMessage("Registration Sucessful \n" +"User Id: "
				+ users.getEmail() + "\n Password: " + password + 
				" \nJudgeing Page will open from: "+configProperty.getJudgingStartdate()+ " to: "+configProperty.getJudgingEnddate()+
				"\nURL: "+configProperty.getJudgloginurl());
		
		
		mailRecipientDTO.setSubject("Registration Success");
		try {
		commonUtil.doSendEmail(mailRecipientDTO, null);
		} catch (MailSendException | ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void sendPasswordChangeConfirmMail(Users users , String password) throws MessagingException{

		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();

		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(users.getEmail());
		mailRecipientDTO.setMessage("Password Change Sucessful. \nRegistration Id:" + users.getUserId() + "\nUser Id: "
				+ users.getEmail() + "\n Password: " + password + " \n");
		mailRecipientDTO.setSubject("Registration Success");
		try {
		commonUtil.doSendEmail(mailRecipientDTO, null);
		} catch (MailSendException | ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void sendforgetPassWordMail(Users users, String url) throws MessagingException{

		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();

		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(users.getEmail());
		mailRecipientDTO.setMessage("To reset your password, click the link below:\n" + url);
		mailRecipientDTO.setSubject("Password Reset Request");
		try {
		commonUtil.doSendEmail(mailRecipientDTO, null);
		} catch (MailSendException | ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void sendJudgeRegistrationURLMail(String url, String judgeMail) throws MessagingException{

		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();

		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(judgeMail);
		mailRecipientDTO.setMessage("To register your as a judge, click the link below URL:\n" + url);
		mailRecipientDTO.setSubject("Password Reset Request");
		try {
		commonUtil.doSendEmail(mailRecipientDTO, null);
		} catch (MailSendException | ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void sendJudgeRegistrationNotDone(String adminMail) throws MessagingException{
		
		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();
		
		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(adminMail);
		mailRecipientDTO.setMessage("\n Hi Admin, \n Kindly Compleate Judge Registration Activity \n"+
				                    " Minimum Number of Judge in Each Club: "+configProperty.getMinnumberjudgeforeachclub());
		mailRecipientDTO.setSubject("Create Judge Profile");
		try {
		commonUtil.doSendEmail(mailRecipientDTO, null);
		} catch (MailSendException | ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void sendCreateCouponCodeMailforaUser(Users users, String couponCode, String bcc) throws MessagingException{
		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();
		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(users.getEmail());
		mailRecipientDTO.setMessage("couponCode=" + couponCode);
		mailRecipientDTO.setSubject("Coupon Code Details");
		try {
		commonUtil.doSendEmail(mailRecipientDTO, bcc);
		} catch (MailSendException | ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendQueryEmail(MailRecipientDTO mailRecipientDTO) throws MessagingException{
		
		
		mailRecipientDTO.setRecipient(configProperty.getMailsender());
		//System.out.println(mailRecipientDTO.toString());
		try {
			System.out.println("mailRecipientDTO="+mailRecipientDTO.toString());
			MailRecipientDTO mailRecipientDTO1 = new MailRecipientDTO();
			mailRecipientDTO1.setRecipient(mailRecipientDTO.getSender());
			mailRecipientDTO1.setSender(mailRecipientDTO.getRecipient());
			mailRecipientDTO1.setSubject(mailRecipientDTO.getSubject());
			mailRecipientDTO1.setMessage(mailRecipientDTO.getMessage());
		commonUtil.doSendEmail(mailRecipientDTO1, null);
		} catch (MailSendException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserDTO createCurrentUserDTO(Users user, UserDTO userDTO) {

		userDTO.setUserid(user.getUserId());
		userDTO.setFirstname(user.getFirstName());
		userDTO.setLastname(user.getLastName());
		userDTO.setLastname(user.getLastName());
		userDTO.setCountry(user.getCountry());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		return userDTO;
	}

	public boolean checkPersentInpout(String value) {
		String pattern = "(\\d{1,2})";
		if (value.matches(pattern))
			return true;
		else
			return false;
	}

	public boolean checkNumberOnly(String value) {
		String regex = "\\d+";
		System.out.println(value.matches(regex));

		return value.matches(regex);
	}

	public String createCouponCode(Integer id, String fName, String lName) {

		return (lName.substring(lName.length() - 1, lName.length())
				+ fName.substring(fName.length() - 1, fName.length()) + "-" + id.toString().substring(1, 6));
	}

	public String saveFile(String directoryName, CommonsMultipartFile image) {

		String saveDirName = commonUtil.directoryCheck(directoryName);

		String fileName = image.getOriginalFilename();
		File uplodedFile = new File(saveDirName, fileName);
		try {
			image.transferTo(uplodedFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveDirName;
	}

	public void deleteFileFromDirectory(String fileName) {

		String filePath = configProperty.getBasePath() + File.separator + fileName;

		try {
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
				System.out.println(file.getName() + " is deleted!");
			} else {
				     System.out.println("Delete operation is failed.");
			        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getExpairStatus() {
		if (commonUtil.findNumberofDaysBetweenTwoDate(configProperty.getCloseDate(),
				commonUtil.getDateTime().substring(0, commonUtil.getDateTime().indexOf(" "))) >= 0)
			return true;
		else
			return false;
	}
	
	public boolean getJudgeOpeningDate() {
		
		long start = commonUtil.findNumberofDaysBetweenTwoDate(configProperty.getJudgingStartdate(),
				commonUtil.getDateTime().substring(0, commonUtil.getDateTime().indexOf(" ")));
		
		long end = commonUtil.findNumberofDaysBetweenTwoDate(configProperty.getJudgingEnddate(),
				commonUtil.getDateTime().substring(0, commonUtil.getDateTime().indexOf(" ")));
		
		System.out.println("START ="+start);
		
		System.out.println("END ="+end);
		
		if(end >=0 && start <=0)
			return true;
		else
			return false;
		
		
	}
	
	
	public Map<String,List<?>> formatGraphData(List<PaystatusGraphDTO> paystatusGraphDTOList) {
		
		Map<String,List<?>> map = new HashMap<>();
		
		if(paystatusGraphDTOList.size() > 0) {
			List<String> country = new ArrayList<>();
			List<Integer> paid = new ArrayList<>();
			List<Integer> unpaid = new ArrayList<>();
			
			for(PaystatusGraphDTO pg : paystatusGraphDTOList) {
				  
				if (country.contains(pg.getCountry())) {
					int index = country.indexOf(pg.getCountry());
					
					if(paid.get(index)==0 && pg.getPaid()!=0) {
						paid.set(index, pg.getPaid());
					  }
					else if(unpaid.get(index)==0 && pg.getUnpaid()!=0) {
						     unpaid.set(index, pg.getUnpaid());     
					       }
				   }else {
					       country.add(pg.getCountry());
					       paid.add(pg.getPaid());
					       unpaid.add(pg.getUnpaid());
				         }
			   }
			/*System.out.println(country);
			System.out.println(paid);
			System.out.println(unpaid);*/
			map.put("country", country);
			map.put("paid", paid);
			map.put("unpaid", unpaid);
		  }
		
		return map;
		
	}
	
	
	public void sendEntryConfirmMail(Users user, List<UserFileTitelListDTO> findTitelListAndCategoryIndex,Map<String, Integer> results, String payingStatus) throws MessagingException{
		
		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();
		mailRecipientDTO.setSender(configProperty.getMailsender());
		mailRecipientDTO.setRecipient(user.getEmail());
		mailRecipientDTO.setSubject("Enrty Confirmation - "+configProperty.getSalonName());
		
		Set<String> categorys = results.keySet();
		String data="";
		
		for(String category : categorys) {					
			for(UserFileTitelListDTO s: findTitelListAndCategoryIndex) {
				if(category.equals(s.getCategory_index().substring(0, s.getCategory_index().length()-1))) {
					data = data+category+"      "+s.getTitel()+"\n"+" ";
				  }
				
			 }
			
		   }
		
				
		String body =" Dear "+user.getFirstName()+","
		              +"\n Thankyou for participating in "+configProperty.getSalonName()+". "
				      + "You have successfully submitted "+findTitelListAndCategoryIndex.size()+" image(s)." 
				      + "\n Your Entrant Number is: "+user.getUserId()
				      + "\n Your Registered Email is: "+user.getEmail()
				      + "\n SECTION      IMAGE TITLE"
				      + "\n "+data
				      +"\n\n\n\n"
				      +" For any queries visit https://www.microcircuit.asia"
		              +"\n\n Regards"
		              + "\n Bela Mukherjee"
		              +"\n\n\n\n"
		              +"N.B.:This is an automatically generated email. Please do not reply to this.";
		
		 System.out.println(body);
		mailRecipientDTO.setMessage(body);
		
		try {
			  commonUtil.doSendEmail(mailRecipientDTO, null);
			} catch (MailSendException | ConnectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         
		
	}
	
	
	
	
	public void processImage(List<List<com.photo.contest.model.File>> fileProcessDataList, List<String> catagoryNameList) throws IOException {
		
		int counter=0;
		 for(List<com.photo.contest.model.File> fileProcessData: fileProcessDataList) {
			  String path = configProperty.getBasePath()+"/"+catagoryNameList.get(counter);
			if(creatrDir(path)) {
		      for(com.photo.contest.model.File file: fileProcessData) {
			      savelFileFromBlobUtility.save(path+"/"+file.getFileId()+".jpg",file.getFile());
			      imageResizeUtility.imazeResize(path+"/"+file.getFileId()+".jpg",
			    		                         path+"/"+file.getFileId()+".jpg", 200);			      
		         }   
	          }else{System.out.println("dir not able to create");}
			counter++;
		   }
	     }
	
	public boolean creatrDir(String path) {
		
		if(fileCheckUtility.isExist(path))
			return true;
	    else 
			 return fileCheckUtility.createDir(path);		
	}
	
	
	public TreeSet<Integer> getSavedFileId(String path) {
		
		TreeSet<Integer> imageIdList = null;
		File[] filesArray = null;
		if(fileCheckUtility.isExist(path)) {
			filesArray = fileCheckUtility.getFileArrayOfaDirectory(path, ".jpg");
			//System.out.println("filesArray size="+filesArray.length);
		   }
		if(filesArray!= null && filesArray.length > 0) {
		   imageIdList = new TreeSet<Integer>();
		   for(File file : filesArray) {
			   if(file!=null && file.length()>0) {
			      String id =file.getName().substring(0,file.getName().indexOf("."));
			      if(id!=null && id.trim().length()>0) {
				                                         //System.out.println("id:"+id);
				                                         imageIdList.add(Integer.valueOf(id));
			                                            }
			                                      }                         
			                              }			
		   }		
		return imageIdList;		
	}
	
	public String judgeCreationStatus(List<Users> judgeList, List<Users> adminList, List<OrganizerClub> organizerClubList) {
		
	
		int minNumberJudgeForEachClub=	Integer.parseInt(configProperty.getMinnumberjudgeforeachclub());
		//int numberOfOrganizreClub=	Integer.parseInt(configProperty.getNumberoforganizreclub());
		String returnString="";
		if(organizerClubList != null && organizerClubList.size() >0) {
			
			if (judgeList.size() > 0 && judgeList!=null) {
								
				for(OrganizerClub organizerClub: organizerClubList) {
					 int count = commonUtil.getFrequencyinList(judgeList,organizerClub);
					if(count >= minNumberJudgeForEachClub){
					   
					  }
					else {
						   returnString=returnString+ "Need to Create "+(minNumberJudgeForEachClub-count)+" more judge for club : "+organizerClub.getOrganizerclubname().toUpperCase()+"\n";					       
					     }					
				   }
				
			   }
			else {
				  returnString= "Judges list is empty, kindly create judge for all the club" 
						         +"\nFollow the above instruction before try again";
				  if(adminList!= null && adminList.size() > 0) {
				     for(Users user: adminList) {
					     try {
							   sendJudgeRegistrationNotDone(user.getEmail());
						     } catch (MessagingException e) {
							    // TODO Auto-generated catch block
							    e.printStackTrace();
						      }
				         }
				     }
				  
			     }
			
		  }
		if(returnString.length()>0)
		   returnString =returnString+"\nFollow the above instruction before try again";	
		return returnString;
	}
	
	
	public String judgeRegistrationStatus(List<Users> judgeList, List<Users> adminList, List<OrganizerClub> organizerClubList) {
		String returnString="";
		if (judgeList.size() > 0 && judgeList!=null) {
			for(Users judge: judgeList) {
				if(judge.getJudgeRegistrationToken()!=null)
				   returnString	=returnString+ "Judge Nane: "+judge.getFirstName()+" "+judge.getLastName()+"\n"+
				                  "Email: "+judge.getEmail()+"\n"+
						          "Club Name: "+judge.getJudgeOrganizerClub().getOrganizerclubname()+"\n"+
						          "Registration Not Yeat Done \n\n";				                   
			   }
			
			
		   }
		else {
			  returnString ="Judges list is empty, kindly create judge for all the club";					       
		     }
		
		if(returnString.length()>0)
			returnString =returnString+"\nFollow the above instruction before try again";	
		return returnString;
		
	}
	
	public Map<Integer, List<String>> findCategoryForJudge(List<Users> judgeList){
		Map<Integer, List<String>> map = new HashMap<>();
		for(Users user: judgeList) {
			Set<Category> categorySet=user.getJudgeCategoryMapping();
			if(categorySet.size()>0) {
				List<String> l = new ArrayList<>();
			    for(Category category: categorySet) {
			    	l.add(category.getCategoryName());
			       }
			    map.put(user.getUserId(), l);
			   }
			  
		   }
		//System.out.println(map);
		return map;
	}

}
