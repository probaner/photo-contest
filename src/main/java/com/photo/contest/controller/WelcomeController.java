package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;
import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.dto.UserStatusDisplayDTO;
import com.photo.contest.model.Users;
import com.photo.contest.service.CommonServices;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.ResultPDFUtility;
import com.photo.contest.utility.SelectData;


@Controller 
@SessionAttributes("userForm")
public class WelcomeController {
	
	@Autowired
	private DbServices dbServices;
	@Autowired
	SelectData selectData;
	@Autowired
	CommonServices 	commonServices;
	@Autowired
	ResultPDFUtility resultPDFUtility;
	@Autowired
	ConfigProperty configProperty;
	
	
	
	@GetMapping("/")
	 public ModelAndView getWelcomePage(Map<String, Object> model) throws IOException {	
		model.put("titel",configProperty.getIndexName());
		model.put("titelImage",configProperty.getIndexImage());
		model.put("headerLeft",configProperty.getHeaderLeft());
		model.put("headerMiddle",configProperty.getHeaderMiddle());
		model.put("headerRight",configProperty.getHeaderRight());
		
	        return new ModelAndView("home"); 
	    }  
			
	@GetMapping("/home")  
	    public ModelAndView helloWorld(Map<String, Object> model) throws IOException {
		model.put("titel",configProperty.getIndexName());
		model.put("titelImage",configProperty.getIndexImage());
		model.put("headerLeft",configProperty.getHeaderLeft());
		model.put("headerMiddle",configProperty.getHeaderMiddle());
		model.put("headerRight",configProperty.getHeaderRight());
	        return new ModelAndView("home"); 
	    } 
	
	@GetMapping("/getrulesandregulations")  
    public ModelAndView getrules(Map<String, Object> model) throws IOException {	
		model.put("titel",configProperty.getIndexName());
		model.put("titelImage",configProperty.getIndexImage());
		model.put("headerLeft",configProperty.getHeaderLeft());
		model.put("headerMiddle",configProperty.getHeaderMiddle());
		model.put("headerRight",configProperty.getHeaderRight());
        return new ModelAndView("rules"); 
    } 
	    
	@GetMapping("/getfipdefination")  
    public ModelAndView getfipdefination(Map<String, Object> model) throws IOException {
		model.put("titel",configProperty.getIndexName());
		model.put("titelImage",configProperty.getIndexImage());
		model.put("headerLeft",configProperty.getHeaderLeft());
		model.put("headerMiddle",configProperty.getHeaderMiddle());
		model.put("headerRight",configProperty.getHeaderRight());
        return new ModelAndView("fipdefination");
    } 
	
	@GetMapping("/getUserTable")
		public String viewLogin(Map<String, Object> model) throws IOException {
	    	List<UserStatusDisplayDTO> userStatusDisplayDTOList = dbServices.getUserDateForStatusTable();
	    	//System.out.println("userStatusDisplayDTOList="+userStatusDisplayDTOList);
	    	model.put("titel",configProperty.getIndexName());
			model.put("titelImage",configProperty.getIndexImage());
			model.put("tableData", userStatusDisplayDTOList);	
			model.put("headerLeft",configProperty.getHeaderLeft());
			model.put("headerMiddle",configProperty.getHeaderMiddle());
			model.put("headerRight",configProperty.getHeaderRight());
			return "table";		
		  }
	 
	@GetMapping("/getRegistrationForm") 
	 public String viewRegistration(Map<String, Object> model) throws IOException {
		    UserDTO userForm = new UserDTO(); 
		    model.put("userForm", userForm);	 		    
		    List<String> genderList = selectData.genderData();
		    Map<String,String> countryList = selectData.countryData();
	        model.put("genderList", genderList);
	        model.put("countryList", countryList);	
	        model.put("titel",configProperty.getIndexName());
			model.put("titelImage",configProperty.getIndexImage());
			model.put("headerLeft",configProperty.getHeaderLeft());
			model.put("headerMiddle",configProperty.getHeaderMiddle());
			model.put("headerRight",configProperty.getHeaderRight());
	        return "UserRegistration";
	    }

	 @PostMapping(value="/processRegistration")
	 public String processRegistration(@ModelAttribute("userForm") UserDTO userDTO,  Model model) throws IOException{
		  List<String> usersEmailList=dbServices.getListOfAColumn("email");
		  model.addAttribute("titel",configProperty.getIndexName());
  		  model.addAttribute("titelImage",configProperty.getIndexImage());
  		  model.addAttribute("headerLeft",configProperty.getHeaderLeft());
		  model.addAttribute("headerMiddle",configProperty.getHeaderMiddle());
		  model.addAttribute("headerRight",configProperty.getHeaderRight());
		  
		  if(!usersEmailList.contains(userDTO.getEmail())){
			  
		   if(commonServices.getExpairStatus())	{  
			   Users users =dbServices.saveUserData(userDTO);
			   UserDTO userDTOn = commonServices.createCurrentUserDTO( users , new UserDTO());
			   model.addAttribute("sucess", "abcd");		  
			   return "registrationconfirm";
		   }else {
			       model.addAttribute("userForm", userDTO);
			       model.addAttribute("error", "Last Login Date is Over !");
			       List<String> genderList = selectData.genderData();
			       Map<String,String> countryList = selectData.countryData();
		           model.addAttribute("genderList", genderList);
		           model.addAttribute("countryList", countryList);
			       return "UserRegistration";
		         }
	      
		  }
		  else{
			    model.addAttribute("userForm", userDTO);
			    model.addAttribute("error", "Email Already Exist !   ");
			    List<String> genderList = selectData.genderData();
			    Map<String,String> countryList = selectData.countryData();
		        model.addAttribute("genderList", genderList);
		        model.addAttribute("countryList", countryList);
			    return "UserRegistration";
		      }
	   }
	 
	 
	
	 
	}
