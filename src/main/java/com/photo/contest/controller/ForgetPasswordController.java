package com.photo.contest.controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.GetPassword;
import com.photo.contest.dto.ResetpasswordDTO;
import com.photo.contest.model.Users;
import com.photo.contest.service.DbServices;

@Controller
@EnableWebMvc
public class ForgetPasswordController {
	
	@Autowired
	DbServices dbServices;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 @Autowired
	 private ConfigProperty configProperty;
	
	@RequestMapping("/getForgetPasswordForm") 
	public String viewForgetPasswordForm(Map<String, Object> model) throws IOException {
		          GetPassword getPassword = new GetPassword();
		           model.put("getPassword", getPassword);
		           
		           model.put("titel",configProperty.getIndexName());
		   		   model.put("titelImage",configProperty.getIndexImage());
		   		   model.put("headerLeft",configProperty.getHeaderLeft());
		   	       model.put("headerMiddle",configProperty.getHeaderMiddle());
		   		   model.put("headerRight",configProperty.getHeaderRight());
		           
		           return "forgetpassword";
                 }
	
	
	 @RequestMapping(value="/processForgetPassword", method = RequestMethod.POST)
	 public String processForgetPassWord(@ModelAttribute("getPassword") GetPassword getPassword,  Model model,HttpServletRequest request) throws IOException{
		 
		 Users user = dbServices.getUser(getPassword.getEmail()); 
		 
		 if (user==null) {
			 model.addAttribute("getPassword", getPassword);
		     model.addAttribute("massage","We didn't find an account for that e-mail address: "+getPassword.getEmail());
		} else { 			     			   
			     user.setForgetPasswAuthToken(UUID.randomUUID().toString());
			     //String appUrl = request.getScheme() + "://" + request.getServerName() +":"+request.getServerPort() +"/photo-contest/getresetpassword?token=" + user.getForgetPasswAuthToken();
			     String appUrl = request.getScheme() + "://" + request.getServerName() +"/getresetpassword?token=" + user.getForgetPasswAuthToken();
			     System.out.println("appUrl="+appUrl);
			     dbServices.updateForgetPasswAuthToken(user,appUrl);
			     model.addAttribute("massage","A password reset link has been sent to: "+getPassword.getEmail());		     
			     
		       }	
		 
		 model.addAttribute("titel",configProperty.getIndexName());
 		  model.addAttribute("titelImage",configProperty.getIndexImage());
 		  model.addAttribute("headerLeft",configProperty.getHeaderLeft());
		  model.addAttribute("headerMiddle",configProperty.getHeaderMiddle());
		  model.addAttribute("headerRight",configProperty.getHeaderRight());
		 
		 return "forgetpassword";		 
	 }
	 
	 @RequestMapping(value="/getresetpassword")
	 public String displayResetPasswordPage(Map<String, Object> model, @RequestParam("token") String token) throws IOException {
		 
		  model.put("titel",configProperty.getIndexName());
 		  model.put("titelImage",configProperty.getIndexImage());
 		  model.put("headerLeft",configProperty.getHeaderLeft());
		  model.put("headerMiddle",configProperty.getHeaderMiddle());
		  model.put("headerRight",configProperty.getHeaderRight());
		
		Users user = dbServices.getUserDataByToken(token);
		if(user!=null) {
		                 ResetpasswordDTO resetpasswordDTO = new ResetpasswordDTO();
		                 model.put("token", token);
		                 model.put("success", true);
		                 model.put("resetpasswordDTO", resetpasswordDTO);
		                 return "resetpassword";	
		                }
		else {
			    model.put("errormessage"," Oops!  This is an invalid password reset link.");
			    return "accessDenied";
		     }
	 }
	 
	 
	 @RequestMapping(value="/resetpassword", method = RequestMethod.POST) 
	 public String resetPasswor(Map<String, Object> model, @RequestParam Map<String, String> requestParams) throws IOException {
            
		  model.put("titel",configProperty.getIndexName());
 		  model.put("titelImage",configProperty.getIndexImage());
 		  model.put("headerLeft",configProperty.getHeaderLeft());
		  model.put("headerMiddle",configProperty.getHeaderMiddle());
		  model.put("headerRight",configProperty.getHeaderRight());
		 
		 
		 System.out.println("Chandan="+requestParams.get("token")+"    "+requestParams.get("password")+"    "+requestParams.get("confirm_password"));
		 
		 Users user = dbServices.getUserDataByToken(requestParams.get("token"));
		 
		if(user!=null  ){
			             if(requestParams.get("password").equals(requestParams.get("confirm_password"))) {
			              user.setForgetPasswAuthToken(null);
			              user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
			              dbServices.updateForgetPasswAuthToken(user,requestParams.get("password"));
		                  model.put("massage", "You have successfully reset your password. Loggin detail send your email. You may now login with user name: " +user.getEmail());
		                  model.put("success", false);
		                  model.put("resetpasswordDTO", new ResetpasswordDTO());
		                  return "resetpassword";
			             }else {
			            	    ResetpasswordDTO resetpasswordDTO = new ResetpasswordDTO();
			                    model.put("token", requestParams.get("token"));
			                    model.put("massage", "Password and confirm password are not same.");
			                    model.put("success", true);
			                    model.put("resetpasswordDTO", resetpasswordDTO);
			                    return "resetpassword";
			                   }
		                }
		 else {
			    //ResetpasswordDTO resetpasswordDTO = new ResetpasswordDTO();
			    model.put("massage", "Oops!  This is an invalid password reset link.Try again to reset password");
			    //model.put("resetpasswordDTO", resetpasswordDTO);
			    return "accessDenied";
		      }
		 
	 }
	
}

//https://gist.github.com/codebyamir/f3b83d081d1bfe224fa433ab746dbf31