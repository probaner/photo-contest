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

import com.photo.contest.dto.FileDTO;
import com.photo.contest.dto.PaymentDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.dto.UserStatusDisplayDTO;
import com.photo.contest.model.Users;
import com.photo.contest.service.CommonServices;
import com.photo.contest.service.DbServices;
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
	
	
	
	@GetMapping("/")
	 public ModelAndView getWelcomePage() throws IOException {	    		    		        	    	
	        return new ModelAndView("home"); 
	    }  
			
	@GetMapping("/home")  
	    public ModelAndView helloWorld() throws IOException {	    		    		        	    	
	        return new ModelAndView("home"); 
	    } 
	
	@GetMapping("/getrulesandregulations")  
    public ModelAndView getrules() throws IOException {	    		    		        	    	
        return new ModelAndView("rules"); 
    } 
	    
	@GetMapping("/getfipdefination")  
    public ModelAndView getfipdefination() throws IOException {	    		    		        	    	
        return new ModelAndView("fipdefination");
    } 
	
	@GetMapping("/getUserTable")
		public String viewLogin(Map<String, Object> model) throws IOException {
	    	List<UserStatusDisplayDTO> userStatusDisplayDTOList = dbServices.getUserDateForStatusTable();
	    	System.out.println("userStatusDisplayDTOList="+userStatusDisplayDTOList);
			model.put("tableData", userStatusDisplayDTOList);	
			return "table";		
		  }
	 
	@GetMapping("/getRegistrationForm") 
	 public String viewRegistration(Map<String, Object> model) throws IOException {
		    UserDTO userForm = new UserDTO(); 
		    model.put("userForm", userForm);	 		    
		    List<String> genderList = selectData.genderData();
		    List<String> countryList = selectData.countryData();
	        model.put("genderList", genderList);
	        model.put("countryList", countryList);	        
	        return "UserRegistration";
	    }

	 @PostMapping(value="/processRegistration")
	 public String processRegistration(@ModelAttribute("userForm") UserDTO userDTO,  Model model) throws IOException{
		  List<String> usersEmailList=dbServices.getListOfAColumn("email");
		  if(!usersEmailList.contains(userDTO.getEmail())){
			  
		   if(commonServices.getExpairStatus())	{  
			   Users users =dbServices.saveUserData(userDTO);
	  
			   UserDTO userDTOn = commonServices.createCurrentUserDTO( users , new UserDTO());
			   model.addAttribute("userForm", userDTOn);	
			   model.addAttribute("sucessMagssage", "welcome "+userDTO.getLastname()+" " + userDTO.getFirstname());
			   model.addAttribute("product", new FileDTO());
			   model.addAttribute("paymentDetail", new PaymentDTO());
               return "registrationsuccess";
		   }else {
			       model.addAttribute("userForm", userDTO);
			       model.addAttribute("error", "Last Login Date is Over !   ");
			       List<String> genderList = selectData.genderData();
			       List<String> countryList = selectData.countryData();
		           model.addAttribute("genderList", genderList);
		           model.addAttribute("countryList", countryList);   
			       return "UserRegistration";
		         }
	      
		  }
		  else{
			    model.addAttribute("userForm", userDTO);
			    model.addAttribute("error", "Email Already Exist !   ");
			    List<String> genderList = selectData.genderData();
			    List<String> countryList = selectData.countryData();
		        model.addAttribute("genderList", genderList);
		        model.addAttribute("countryList", countryList);
			    return "UserRegistration";
		      }
	   }
	 
	 
	
	 
	}
