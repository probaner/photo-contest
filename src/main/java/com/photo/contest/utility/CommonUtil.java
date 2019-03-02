package com.photo.contest.utility;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.config.LastIdProperty;
import com.photo.contest.dto.MailRecipientDTO;
import com.photo.contest.exception.BusinessException;
import com.photo.contest.exception.ErrorCode;
import com.photo.contest.exception.ImageFormateException;
import com.photo.contest.exception.ImageSizeException;
import com.photo.contest.model.ImageRating;
import com.photo.contest.model.OrganizerClub;
import com.photo.contest.model.Users;



@Component
public class CommonUtil {
	
	 @Autowired
	 private MailSender mailSender;
	 
	 @Autowired
	 private LastIdProperty lastIdProperty;
	 
	 @Autowired
	 private ConfigProperty configProperty;
	 	 
	 private static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 
	 
	 public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	   }
	 public void setLastIdProperty(LastIdProperty lastIdProperty) {
			this.lastIdProperty = lastIdProperty;
		}
	
	
	
	 public static String getDateTime(){
		 Date date = new Date();
		 //System.out.println(sdf.format(date)); 
		 return  sdf.format(date);		
	 }
	 
	 public  Timestamp sqlDateTime(){
		 long time = System.currentTimeMillis();
		 return(new java.sql.Timestamp(time));	 
	 }
	
	 public  int getUserId() throws IOException{
		String temp = CommonUtil.getDateTime();
	    String temp_part1=(temp.substring(9,10)).replace("/", "");
		String temp_part2=(temp.substring(13,temp.length())).replace(":", "");
		
		int temp1 = Integer.parseInt(lastIdProperty.getLastId()) +1;
		
		lastIdProperty.setLastId(String.valueOf(temp1));
		if(temp1<10) {	
			          if (temp_part1.equals("0")) 			        	 
			        	  return Integer.parseInt("4"+"000"+temp1+ temp_part2);			        	
			          else		        	     
		                   return Integer.parseInt(temp_part1+"000"+temp1+ temp_part2);
			               
		             }
		else if(temp1<100 && temp1>=10) {
			                             if (temp_part1.equals("0")) 
			                            	 return Integer.parseInt("4"+"00"+temp1+ temp_part2);
			                             else
			                                  return Integer.parseInt(temp_part1+"00"+temp1+ temp_part2);
		                                }
		else if(temp1<1000 && temp1>=100) {
			                               if (temp_part1.equals("0"))
			                                    return Integer.parseInt("4"+"0"+temp1+ temp_part2);
			                               else 
			                                    return Integer.parseInt(temp_part1+"0"+temp1+ temp_part2);  
		                                  }
		return 0;		
	 }
	
	 
	 
	 
	
	//http://www.codejava.net/frameworks/spring/sending-e-mail-with-spring-mvc
	 public String doSendEmail(MailRecipientDTO mailRecipientDTO,String bcc) throws java.net.ConnectException, org.springframework.mail.MailSendException,javax.mail.MessagingException{		 
		 SimpleMailMessage email = new SimpleMailMessage();
		 email.setFrom(mailRecipientDTO.getSender());
		 email.setTo(mailRecipientDTO.getRecipient());
		 email.setBcc(configProperty.getMailsender());
		 email.setSubject(mailRecipientDTO.getSubject());
		 email.setText(mailRecipientDTO.getMessage());
		 //if(bcc!=null)
		   // email.setBcc(bcc);
		 mailSender.send(email);
		 return "success";
		 		 
	 }


	 
	 public String directoryCheck(String directoryName){		 
		 String dir=configProperty.getBasePath()+File.separator+directoryName;
		 File file = new File(dir);		  
		 if(!file.exists()){
			 file.mkdirs();
			 return dir; 
		   }
		 else
		     return dir;		 
	 }
	 
	 
	 public boolean checkFileSize(File file){
		 
		 Double size = (double) (file.length()/1024);
		 System.out.println("size="+size);
		 if(size> configProperty.getFileMaxSize())
		    return false;
		 else   		
		      return true;		 
	 }
	 
	 
	 public long findNumberofDaysBetweenTwoDate(String inputString1, String inputString2 ){
		 
		 inputString2 = inputString2.replace("/", "-");
		     System.out.println(inputString1 +"        "+inputString2 );
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");	
			try {
			    Date date1 = simpleDateFormat.parse(inputString1);
			    Date date2 = simpleDateFormat.parse(inputString2);
			    long diff = date1.getTime() - date2.getTime();
			    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			return 0;
		}
	 
	/*public static void main(String args[]){
		calculatePersentValue(20,20);
	}*/
	  
	 
	 public int calculatePersentValue(int amount, int persent){
		 
		 float finalv = amount - (amount*persent)/100;
		  return (Math.round(finalv));		 
	 }
	 
public String getMethodOutPut(String methodName) {
	
	 String str1 =null;
	 Class tClass = configProperty.getClass();
	 try {
		   Method gs1Method = tClass.getMethod(methodName, new Class[] {});
		   try {
			     str1 = (String) gs1Method.invoke(configProperty, new Object[] {});
			     System.out.println("Refelection data="+str1);
			     return str1;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     } catch (NoSuchMethodException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return str1;	
}


public int getNumbrtofSection(int number) {
	
	int section = 0;
	
	 if(number<=4)
 	    section =1;
	 else if(number >=5 && number<=8)
 	    section =2;
	 else if(number >=9 && number<=12)
	 	    section =3;
	 else if(number >=13 && number<=16)
	 	    section =4;
	 else if(number >=17 && number<=20)
	 	    section =5;
	 else if(number >=21 && number<=24)
	 	    section =6;
	 else if(number >=25 && number<=28)
	 	    section =7;
	 else if(number >=29 && number<=32)
	 	    section =8;
	 else if(number >=33 && number<=36)
	 	    section =9;
	 else if(number >=37 && number<=40)
	 	    section =10;
    
    return section;
	
}



public boolean  imageSizeValidation(byte fileContent[]) throws BusinessException, IOException{
	InputStream inputstream = new ByteArrayInputStream(fileContent);
	int sizekb = inputstream.available()/1024;	
	if(sizekb <= configProperty.getFileMaxSize()) {
		 return true;
	  }
	else {
		   ErrorCode errorCode = new ErrorCode("Image size not more "+configProperty.getFileMaxSize(),"Image size problem.",500);
		   throw new ImageSizeException(errorCode);  
	     }		
}

public boolean  imageDimentionValidation(byte fileContent[]) throws BusinessException, IOException{
	
	BufferedImage img = null;
	InputStream inputstream = new ByteArrayInputStream(fileContent);
	img = ImageIO.read(inputstream);
	//System.out.println("Image Height : " + img.getHeight());
	// Image Height
	//System.out.println("Image Width : " + img.getWidth());
	// Image Width
	
	if(img.getWidth() ==img.getHeight()) {
		
		if(img.getWidth()>=Integer.parseInt(configProperty.getFileMinlongestSideResolution()) && img.getWidth() <= Integer.parseInt(configProperty.getFileMaxlongestSideResolution())) 
			return true;
		else {
			   ErrorCode errorCode = new ErrorCode("Image width should be between " +configProperty.getFileMinlongestSideResolution() +" and " +configProperty.getFileMaxlongestSideResolution() + ". ","Image dimension problem.",500);
			   throw new ImageFormateException(errorCode);
		     }
		
	}else if(img.getWidth() > img.getHeight()) {
		if(img.getWidth()>=Integer.parseInt(configProperty.getFileMinlongestSideResolution()) && img.getWidth() <= Integer.parseInt(configProperty.getFileMaxlongestSideResolution())) 
			return true;
		else {
			
			   ErrorCode errorCode = new ErrorCode("Image width should be between " +configProperty.getFileMinlongestSideResolution() +" and " +configProperty.getFileMaxlongestSideResolution() + ". ","Image dimension problem.",500);
			   throw new ImageFormateException(errorCode);
		     }
		
	}else if(img.getWidth() < img.getHeight()) {
		if(img.getHeight()>=Integer.parseInt(configProperty.getFileMinlongestSideResolution()) && img.getHeight() <= Integer.parseInt(configProperty.getFileMaxlongestSideResolution())) 
			return true;
		else {
			   
			   ErrorCode errorCode = new ErrorCode("Image width should be between " +configProperty.getFileMinlongestSideResolution() +" and " +configProperty.getFileMaxlongestSideResolution() + ". ","Image dimension problem.",500);
			   throw new ImageFormateException(errorCode);
		     }
		
	}
	
	
	return false;	
	
}


public double getDiscountValue(int amount, int precent){
	
	//float value = amount - amount*precent/100;
	
	return java.lang.Math.ceil(amount - amount*precent/100);
	
}

public String getPreviouDayDate(String date,int  diff)  {
	
	DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");	
	Calendar cal = null;
	Date dayminusone = null;
	try {
	      Date parseDate = simpleDateFormat.parse(date);
	      cal = Calendar.getInstance();
	      cal.setTime(parseDate);
	      cal.add(Calendar.DATE, -diff);
	      dayminusone = cal.getTime();
	      return simpleDateFormat.format(dayminusone);
        } catch (ParseException e) {
                                     e.printStackTrace();
                                   }
	return null;	
}

public int getFrequencyinList(List<Users> judgeList, OrganizerClub organizerClub) {
	int counter=0;
	if(judgeList.size() >0 && judgeList!=null) {
		for(Users u : judgeList) {
			if(u.getJudgeOrganizerClub().equals(organizerClub)) {
				counter++;				
			  }
		}
		return counter;
	}
	return 0;
	
}

public Map<Integer, Integer> createImageReatingMap(Optional<List<ImageRating>> imageRatingList){
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	if(imageRatingList.isPresent()){
		   for(ImageRating imageRating: imageRatingList.get()) {
			   map.put(imageRating.getFile().getFileId(), imageRating.getRating());
		      }
	}
	
	//System.out.println(map);
	return map;
	
}


/*public ReatingStatusTreeDTO createGruphData(List<String> list){
	
	//List<JudgingStatusGraphDTO> judgingStatusGraphDTOList = new ArrayList<>();
	JudgingStatusGraphDTO judgingStatusGraphDTO = null;
	ReatingStatusTreeDTO reatingStatusTreeDTO = new ReatingStatusTreeDTO();
	for(String data : list) {
		judgingStatusGraphDTO = new JudgingStatusGraphDTO();
		judgingStatusGraphDTO.setId(list.indexOf(data)+1);
		judgingStatusGraphDTO.setText_2("");
		judgingStatusGraphDTO.setColor("#2196F3");
		if(!data.contains("|")) {
		   judgingStatusGraphDTO.setFather("");
		   judgingStatusGraphDTO.setText_1(data);
		}
		else {
			  String parentdata = data.substring(0, data.lastIndexOf("|"));
			  if(list.contains(parentdata)) {
				  int i = list.indexOf(parentdata)+1;
				  judgingStatusGraphDTO.setFather(String.valueOf(i));
			    }
			  judgingStatusGraphDTO.setText_1(data.substring(data.lastIndexOf("|")+1, data.length()));
		     }
		judgingStatusGraphDTOList.add(judgingStatusGraphDTO);
	   }
	
	for(String data : list) {
		
		if(!data.contains("|")) {
			System.out.println("dataZero"+data);
			
			reatingStatusTreeDTO.setName(data);
			reatingStatusTreeDTO.setParent(null);
			
		  }
		else if(StringUtils.countOccurrencesOf(data, "|")==1) {
			      System.out.println("dataONE"+data);
			     if( reatingStatusTreeDTO.getChildren()!=null) {
			    	 
			    	 List<ReatingStatusTreeDTO> l = reatingStatusTreeDTO.getChildren();
			    	 ReatingStatusTreeDTO reatingStatusTreeDTOChild =  new ReatingStatusTreeDTO();
			    	 reatingStatusTreeDTOChild.setName(data.substring(data.lastIndexOf("|")+1, data.length()));
			    	 reatingStatusTreeDTOChild.setParent(data.substring(0, data.lastIndexOf("|")));	
			    	 l.add(reatingStatusTreeDTOChild);
			    	 reatingStatusTreeDTO.setChildren(l);
			       }
			     else {
			    	     List<ReatingStatusTreeDTO> l =  new ArrayList<>();
			    	     ReatingStatusTreeDTO reatingStatusTreeDTOChild =  new ReatingStatusTreeDTO();			    	  
				    	 reatingStatusTreeDTOChild.setName(data.substring(data.lastIndexOf("|")+1, data.length()));
				    	 reatingStatusTreeDTOChild.setParent(data.substring(0, data.lastIndexOf("|")));	
				    	 l.add(reatingStatusTreeDTOChild);
				    	 reatingStatusTreeDTO.setChildren(l);
		              }
	           }
		
	}//end of for
	
	System.out.print(reatingStatusTreeDTO);
	
	return reatingStatusTreeDTO;
}*/



  }
