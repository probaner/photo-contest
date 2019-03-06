package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.CategoryDTO;
import com.photo.contest.dto.ClubDTO;
import com.photo.contest.dto.CouponCode;
import com.photo.contest.dto.JudgeCreationDTO;
import com.photo.contest.dto.Login;
import com.photo.contest.dto.LogingResponseDTO;
import com.photo.contest.dto.PaymentDTO;
import com.photo.contest.dto.ProcessFileDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.model.OrganizerClub;
import com.photo.contest.model.Users;
import com.photo.contest.service.CommonServices;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.SelectData;



@Controller 
@SessionAttributes({"userForm","displayFileDTOMap","clubDataList","organizerclubList","categoryList","processDataType"})
public class UserLoginController {
	
	@Autowired
    CommonServices 	commonServices;
	@Autowired
	private DbServices dbServices;
	@Autowired
	SelectData selectData;
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	@Autowired
	private ConfigProperty configProperty;
	
	 @GetMapping("/getloginFormAfterRegister")
		public String viewLoginAfterRegister(Map<String, Object> model) throws IOException {
			Login loginForm = new Login();
			model.put("loginForm", loginForm);
			
			model.put("titel",configProperty.getIndexName());
			model.put("titelImage",configProperty.getIndexImage());
			model.put("headerLeft",configProperty.getHeaderLeft());
			model.put("headerMiddle",configProperty.getHeaderMiddle());
			model.put("headerRight",configProperty.getHeaderRight());
			
			return "login";		
		  }
	 
	 
	
	@GetMapping("/getloginForm")
		public String viewLogin(Map<String, Object> model) throws IOException {
			Login loginForm = new Login();
			model.put("loginForm", loginForm);	
			
			model.put("titel",configProperty.getIndexName());
			model.put("titelImage",configProperty.getIndexImage());
			model.put("headerLeft",configProperty.getHeaderLeft());
			model.put("headerMiddle",configProperty.getHeaderMiddle());
			model.put("headerRight",configProperty.getHeaderRight());
			
			return "login";		
		  }
	
	/**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String loginPage(Model model) throws IOException{
    	
    	
    	  model.addAttribute("titel",configProperty.getIndexName());
 		  model.addAttribute("titelImage",configProperty.getIndexImage());
 		  model.addAttribute("headerLeft",configProperty.getHeaderLeft());
		  model.addAttribute("headerMiddle",configProperty.getHeaderMiddle());
		  model.addAttribute("headerRight",configProperty.getHeaderRight());
    	    	    	
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
		} else {

			String email = getCurrentUser();
			if (email != null) {
				LogingResponseDTO logingResponseDTO = dbServices.getUserData(email);
				
				Users user = logingResponseDTO.getUser();
				if (user != null) {

					UserDTO userDTO = commonServices.createCurrentUserDTO(user, new UserDTO());
					model.addAttribute("userForm", userDTO);
				    if (userDTO.getRole().equals("participate") /*&& commonServices.getExpairStatus()*/) {   
						model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
								+ userDTO.getFirstname().toUpperCase());
						

						model.addAttribute("paymentDetail", new PaymentDTO());
						model.addAttribute("displayFileDTOMap", logingResponseDTO.getHm());						
						return "registrationsuccess";
					} 
					else if (userDTO.getRole().equals("admin")) {
						
						model.addAttribute("couponCode", new CouponCode());
						model.addAttribute("processFileDTO", new ProcessFileDTO());
						model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
						model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
								+ userDTO.getFirstname().toUpperCase());
						List<ClubDTO> clubDTOData = dbServices.getClubData();
						List<String> clubDataList = selectData.clubData(clubDTOData);
						
						List<OrganizerClub> organizerClubDTOList = dbServices.getOrganizerClubList();
						Map<String,String> organizerclubList = selectData.organizerClubList(organizerClubDTOList);
						
						Map<String, Integer> categoryMap = dbServices.results;
						List<String> categoryList = selectData.getCategoryList(categoryMap);
						
						model.addAttribute("clubDataList", clubDataList);
						model.addAttribute("organizerclubList", organizerclubList);
						model.addAttribute("categoryList", categoryList);
						model.addAttribute("categoryList", categoryList);
						model.addAttribute("processDataType", selectData.judgeFileProcessType());
						
						return "admin";

					} else if (userDTO.getRole().equals("judge")){
						       
						      if(commonServices.getJudgeOpeningDate()) {
						    	  
						    	   List<String>  judgeCategory = dbServices.getCategoryListofaJudge(userDTO.getUserid()); 
						    	   java.util.Collections.sort(judgeCategory); 
						    	  
						    	   model.addAttribute("categoryList",judgeCategory);
						    	   model.addAttribute("categoryDTO", new CategoryDTO());
						    	   model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
											+ userDTO.getFirstname().toUpperCase());
						    	   
						    	   return "judge";
						        }
						         else {
						        	        model.addAttribute("judgePageError", "This Page is available from "+configProperty.getJudgingStartdate()+ " to "+configProperty.getJudgingEnddate() + " only."  );
						        	        return "judgeerrorpage";
						               }
						      
					          }

				} else {
					     model.addAttribute("error", "Invalid Details");
				       }

			} else {
				     model.addAttribute("error", "Please enter Details");
			       }

			return "login";
		}
        }
	
	 /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    
    private String getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
	
}
		

