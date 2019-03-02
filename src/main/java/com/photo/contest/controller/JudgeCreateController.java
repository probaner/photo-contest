package com.photo.contest.controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.CouponCode;
import com.photo.contest.dto.JudgeCreationDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.model.Users;
import com.photo.contest.service.DbServices;

@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList"/*,"processDataType"*/})
@EnableWebMvc
public class JudgeCreateController {
	
	@Autowired
	private DbServices dbServices;
	@Autowired
	ConfigProperty configProperty;
	
	@RequestMapping("/createJudge")
	public String createJudge(@RequestParam String action, ModelMap model, 
			@ModelAttribute("judgeCreationDTO") JudgeCreationDTO judgeCreationDTO,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException, MessagingException {
		
		  UserDTO userDTO = (UserDTO) model.get("userForm");
		  
		 if (action.equals("registerJudge")) {
			 
		  if(judgeCreationDTO.getCategory()==null) {
			    model.addAttribute("judgeCreationError","Category for the Judge Should be Selected");
		       }
		 
		     else {
		    	    Users judge = dbServices.getJudge(judgeCreationDTO.getEmail());
		    	    if(judge == null) {// if judge not exist
		    	    	                String token = UUID.randomUUID().toString();
		    	    	                //String judgeRegisterUrl = request.getScheme() + "://" + request.getServerName() +":"+request.getServerPort() +"/photo-contest/getregisterjudge?token=" + token;
		    	    	                String judgeRegisterUrl = request.getScheme() + "://" + request.getServerName() +"/getregisterjudge?token=" + token;
		    	    	                //System.out.println("judgeRegisterUrl="+judgeRegisterUrl);
		                                String responce = dbServices.createJudge(judgeCreationDTO, userDTO, token,judgeRegisterUrl);
		                                if(responce.equals("ok"))
		                                    model.addAttribute("judgeCreationError","Successfully Judge Created");
		                                else
		                                	model.addAttribute("judgeCreationError","Judge Creation Fail, Contact System Administrator");
		                                
		    	                      } 
		    	    else {                  // if judge exist	
		    	    	
		    	    	     if(judge.getJudgeOrganizerClub()==null) {     // if judge already exist as a user or admin 
		    	    	    	model.addAttribute("judgeCreationError","Judge allready exist as a "+ judge.getRole()); 
		    	    	       }
		    	    	     else { 
		    	    	            if(!judge.getJudgeOrganizerClub().getOrganizerclubname().equals(judgeCreationDTO.getOrganizerclubName())) {
		    	    	    	       model.addAttribute("judgeCreationError","Judge allready created for club : "+judge.getJudgeOrganizerClub().getOrganizerclubname());
		    	    	              }
		    	    	            else {
		    	    	    	           model.addAttribute("judgeCreationError","Judge allready created for "+judge.getJudgeOrganizerClub().getOrganizerclubname()+" club, For Edit profile go to Judge Edit Table");
		    	    	                 }
		    	    	           }
		    	         }
		          }
		 
		 
		 
		 
		    //CouponCode couponCode = new CouponCode();
		
		
	}
			model.addAttribute("couponCode", new CouponCode());
			model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
			//model.addAttribute("processDataType", processDataType);
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
