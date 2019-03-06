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
import com.photo.contest.service.CommonServices;
import com.photo.contest.utility.SelectData;


@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList","processDataType"})
@EnableWebMvc
public class ProcessJudgingFileController {
	
	@Autowired
	ConfigProperty configProperty;
	@Autowired
	private CommonServices commonServices;
	@Autowired
	private SelectData selectData;
	
	
	@RequestMapping("/processfileforjudging")
	public String fileProcesser(@RequestParam String action, 
			Model model, 
			@ModelAttribute("couponCode") CouponCode couponCodeBean,			
			@ModelAttribute("userForm") UserDTO userDTO,
			@ModelAttribute("clubDataList") List<String> clubDataList,
			@ModelAttribute("processDataType") Map<String, String> processDataType,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		if (action.equals("processJudgingFile")) {
		    if(commonServices.judgingFileProcessDateStatus()){
			
		      }
		    else{
		    	  model.addAttribute("processDataError", "Data Processing Date: "+configProperty.getJudgingFileprocessdate());
		        }
		   }
		
		model.addAttribute("couponCode", new CouponCode());
		model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
		model.addAttribute("processDataType", processDataType);
		model.addAttribute("processFileDTO", new ProcessFileDTO());
		model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
				+ userDTO.getFirstname().toUpperCase());
		
		
		  model.addAttribute("titel",configProperty.getIndexName());
  		  model.addAttribute("titelImage",configProperty.getIndexImage());
  		  model.addAttribute("headerLeft",configProperty.getHeaderLeft());
		  model.addAttribute("headerMiddle",configProperty.getHeaderMiddle());
		  model.addAttribute("headerRight",configProperty.getHeaderRight());
	 
		
		  return "admin";
		
	}
	

}
