package com.photo.contest.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.photo.contest.dto.UserDTO;
import com.photo.contest.service.DbServices;

@Controller
@SessionAttributes({"userForm"})
public class UserResultController {
	
	@Autowired
	DbServices dbServices;
	
	@RequestMapping(value = "json/downloadresult")    
    public @ResponseBody boolean getrules(ModelMap model) throws IOException {	
		
		 UserDTO userDTO = (UserDTO) model.get("userForm");
		
		 return dbServices.getResultURLActiveStatus(userDTO);		 
       } 
	
	@RequestMapping(value ="/downloadresult" , method = RequestMethod.GET)  
    public void getResult(HttpServletResponse response, ModelMap model) throws IOException {
		
		 UserDTO userDTO = (UserDTO) model.get("userForm");
		 //System.out.println(userDTO.getUserid());
		 
		 java.io.File file = dbServices.getResult(userDTO);
		 
		 //System.out.println(file.getName());
		 response.setContentType("application/pdf");
		 response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));		 
		 response.setContentLength((int)file.length());	 
	     InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	     //FileCopyUtils.copy(inputStream, response.getOutputStream());
         response.getOutputStream().write(FileCopyUtils.copy(inputStream, response.getOutputStream()));
	     response.getOutputStream().flush();
		
		
	}
	

}
