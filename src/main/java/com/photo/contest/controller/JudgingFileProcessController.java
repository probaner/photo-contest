package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.CouponCode;
import com.photo.contest.dto.JudgeCreationDTO;
import com.photo.contest.dto.ProcessFileDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.utility.CommonUtil;


@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList","processDataType"})
@EnableWebMvc
public class JudgingFileProcessController {
	
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private CommonUtil commonUtil;
	
	
	@RequestMapping("/processFile")
	public String processFile(@RequestParam String action,
			                  @ModelAttribute("processFileDTO") ProcessFileDTO processFileDTO,
			                  @ModelAttribute("couponCode") CouponCode couponCodeBean, 
			                  @ModelAttribute("userForm") UserDTO userDTO,
			      			  @ModelAttribute("clubDataList") List<String> clubDataList,
			      			  @ModelAttribute("processDataType") Map<String, String> processDataType,
			                  HttpServletResponse response,
			                  HttpServletRequest request,
			                  Model model)throws IOException {
		
		if (action.equals("processJudgingFile")) {		
		     //System.out.println("ProcessFileDTO="+ processFileDTO.toString());
		     if(processFileDTO.getStatus().equals("0"))
		    	 model.addAttribute("processDataError", "Select Proper Option !"); 
		  else {
			     String judgingStartdate =configProperty.getJudgingStartdate(); 
			     String sysDate =commonUtil.getDateTime().substring(0,10).trim();
			     
			     System.out.println(judgingStartdate + "   " +sysDate);
			     long diff = commonUtil.findNumberofDaysBetweenTwoDate(judgingStartdate,sysDate);
			     
			     if(diff >0 && diff <=2) {
			    	           String dayMinusOne = commonUtil.getPreviouDayDate(judgingStartdate, 1);
			    	           String dayMinusTow = commonUtil.getPreviouDayDate(judgingStartdate, 2);
			    	           model.addAttribute("processDataError", "Process will run from: "+ dayMinusTow + " to "+ dayMinusOne);
			                 }
			     
			     else {
			    	 
			    	     // new to write logic for process file
			    	 
			          }
			     
			    
		    	     
		       }
		     
		   }
		
		model.addAttribute("couponCode", new CouponCode());
		model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
		model.addAttribute("processDataType", processDataType);
		model.addAttribute("processFileDTO", new ProcessFileDTO());
		model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
				+ userDTO.getFirstname().toUpperCase());
		
		return "admin";
		
	}
}
