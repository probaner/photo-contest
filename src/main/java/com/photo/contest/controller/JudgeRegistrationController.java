package com.photo.contest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.AcceptenceClubDTO;
import com.photo.contest.dto.JudgeRegisterDTO;
import com.photo.contest.model.Users;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.SelectData;

@Controller
@EnableWebMvc
public class JudgeRegistrationController {
	
	
	@Autowired
	DbServices dbServices;
	
	
	 @Autowired
	 private ConfigProperty configProperty;
	 @Autowired
	 private SelectData selectData;
	
	@RequestMapping(value="/getregisterjudge")
	 public String displayJudgeRegistrationPage(Map<String, Object> model, @RequestParam("token") String token) {
		
		model.put("titel",configProperty.getIndexName());
		model.put("titelImage",configProperty.getIndexImage());
		model.put("headerLeft",configProperty.getHeaderLeft());
		model.put("headerMiddle",configProperty.getHeaderMiddle());
		model.put("headerRight",configProperty.getHeaderRight());
		
		
		Users judge = dbServices.getJudgeforRegister(token);
		
		if(judge != null) {
		
		   JudgeRegisterDTO judgeRegisterDTO = new JudgeRegisterDTO();
		   judgeRegisterDTO.setJudgeId(judge.getUserId());
		   judgeRegisterDTO.setJudgeEmail(judge.getEmail());
		   judgeRegisterDTO.setJudgeName(judge.getFirstName()+" "+judge.getLastName());
		   model.put("token", token);
           model.put("success", true);
           Map<String,String> countryList = selectData.countryData();
           model.put("countryList", countryList);	
           model.put("judgeRegisterDTO", judgeRegisterDTO);
		   
		   return "judgeregistration";
		}else {
			    model.put("errormessage"," Oops!  This is an invalid judge register link.");
		        return "accessDenied";
		       }			
	}
	
	@RequestMapping(value="/registerjudge", method = RequestMethod.POST) 
	public String registerJudge(Map<String, Object> model,
			@ModelAttribute("judgeRegisterDTO") JudgeRegisterDTO judgeRegisterDTO) {
		
		
		model.put("titel",configProperty.getIndexName());
		model.put("titelImage",configProperty.getIndexImage());
		model.put("headerLeft",configProperty.getHeaderLeft());
		model.put("headerMiddle",configProperty.getHeaderMiddle());
		model.put("headerRight",configProperty.getHeaderRight());
				
		Users judge = dbServices.getJudgeforRegister(judgeRegisterDTO.getJudgeToken());
		if (judge!=null) {	
			               //judge.setPassword(bCryptPasswordEncoder.encode(judgeRegisterDTO.getJudgePassword()));
			               dbServices.registerJudge(judge, judgeRegisterDTO);			               
		                   return "registrationconfirm";
		                 }
		else {
			   model.put("massage", "Oops!  This is an invalid LINK.Conact with Salon Organizer");
			   return "accessDenied";
		     }
		
	}
	

}
