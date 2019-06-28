package com.photo.contest.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.AcceptenceClubDTO;
import com.photo.contest.dto.AwardedDataDTO;
import com.photo.contest.dto.BulkMailDTO;
import com.photo.contest.dto.CouponCode;
import com.photo.contest.dto.JudgeCreationDTO;
import com.photo.contest.dto.OrganizerClubDTO;
import com.photo.contest.dto.ProcessFileDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.service.CommonServices;

@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList","processDataType","mailerType","organizerClubDTO"})
public class DownloadAwardedFileController {
	
	@Autowired
    CommonServices commonServices;
	@Autowired
	ConfigProperty configProperty;
	
	private boolean urlActiveStatus=false;
	private AwardedDataDTO awardedDataDTO = null;
	@RequestMapping("/downloadAwardedFile")
	public String sendBulkMail(@RequestParam String action, 
			Model model, 					
			@ModelAttribute("couponCode") CouponCode couponCodeBean,			
			@ModelAttribute("userForm") UserDTO userDTO,
			@ModelAttribute("clubDataList") List<String> clubDataList,
			@ModelAttribute("acceptenceClubDTO") AcceptenceClubDTO acceptenceClubDTO,
			@ModelAttribute("bulkMailDTO") BulkMailDTO bulkMailDTO,
			@ModelAttribute("processDataType") Map<String, String> processDataType,
			@ModelAttribute("organizerClubDTO") OrganizerClubDTO organizerClubDTO,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
				
		if (action.equals("getdownloadAwardedFile")) {
			//System.out.println("getOrganizerclubname="+organizerClubDTO.getOrganizerClubName());
			if(organizerClubDTO.getOrganizerClubName()!=null && organizerClubDTO.getOrganizerClubName().length()>0){ 
			   awardedDataDTO = commonServices.awardedData(organizerClubDTO.getOrganizerClubName()); 
			   if(awardedDataDTO.isStatus()){	
			      urlActiveStatus=true;
			      model.addAttribute("downloadStatus", "Active");
			     }
			   else{
				    urlActiveStatus=false;
				    model.addAttribute("downloadStatus", "Inactive");
				    model.addAttribute("downloadAwardedFileError", "Try after "+configProperty.getResultDate()); 
			       }
			  }
			else{
				  urlActiveStatus=false;
				  model.addAttribute("downloadStatus", "Inactive");
				  model.addAttribute("downloadAwardedFileError", "Select a club name");
			    }
		   }
		
		model.addAttribute("couponCode", new CouponCode());
		model.addAttribute("processFileDTO", new ProcessFileDTO());
		model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
		model.addAttribute("acceptenceClubDTO",new AcceptenceClubDTO());
		model.addAttribute("bulkMailDTO",new BulkMailDTO());
		model.addAttribute("processFileDTO", new ProcessFileDTO());
		model.addAttribute("organizerClubDTO", new OrganizerClubDTO());
		//model.addAttribute("downloadStatus", "Inactive");
		model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
				+ userDTO.getFirstname().toUpperCase());
		
		
		  model.addAttribute("titel",configProperty.getIndexName());
 		  model.addAttribute("titelImage",configProperty.getIndexImage());
 		  model.addAttribute("headerLeft",configProperty.getHeaderLeft());
		  model.addAttribute("headerMiddle",configProperty.getHeaderMiddle());
		  model.addAttribute("headerRight",configProperty.getHeaderRight());
		  
		  System.out.println(urlActiveStatus);
		
		return "admin";
		
	}
	
	@RequestMapping(value = "admin/json/downloadAwardedFile")  
    public @ResponseBody boolean geturlActiveStatus(ModelMap model) throws IOException {
			System.out.println("I am HEAR");	
		 return urlActiveStatus;
		 
       }
	
	@RequestMapping(value ="/downloadAwardedFile" , method = RequestMethod.GET)  
    public void getZip(HttpServletResponse response, ModelMap model) throws IOException {
		
		 
		 
		 java.io.File file = awardedDataDTO.getFile();
		 
		 //System.out.println(file.getName());
		 response.setContentType("application/zip");
		 response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));		 
		 response.setContentLength((int)file.length());	 
	     InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	     //FileCopyUtils.copy(inputStream, response.getOutputStream());
         response.getOutputStream().write(FileCopyUtils.copy(inputStream, response.getOutputStream()));
	     response.getOutputStream().flush();
	     urlActiveStatus=false;
		
	}
}
