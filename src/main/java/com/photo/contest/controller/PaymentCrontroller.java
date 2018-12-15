package com.photo.contest.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.photo.contest.dto.UserDTO;
import com.photo.contest.model.Users;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.CommonUtil;

@Controller
@SessionAttributes({"userForm"})
@EnableWebMvc
public class PaymentCrontroller {
	
	@Autowired
	private DbServices dbServices;
	@Autowired
	CommonUtil commonUtil;
	@RequestMapping(value = "/json/getpaystatu")  
    public @ResponseBody boolean getrules(ModelMap model) throws IOException {
		
		 boolean responce;
		 UserDTO userDTO = (UserDTO) model.get("userForm");	 
		 Users user = dbServices.getUser(userDTO.getEmail());
		 System.out.println("COUNT="+user.getPayStatus().getAttemptSection());
		 if (user.getPayStatus().getPayingStatus().toUpperCase().equals("PAID"))		 
			 responce = false;
		 else if(user.getPayStatus().getAttemptSection()==0) 
			 responce = false;			
		 else
			 responce = true;
		 
		 return responce;
		 
       } 
	
	@GetMapping("/getpay")  
    public ModelAndView getpay(ModelMap model) throws IOException {
		
		 UserDTO userDTO = (UserDTO) model.get("userForm");
		 Users user = dbServices.getUser(userDTO.getEmail());
		
		   
		String paymentData = null;
		
		model.addAttribute("uid", "USER ID: "+user.getUserId());
		model.addAttribute("uname", "USER NAME: "+user.getFirstName()+" "+user.getLastName());
		model.addAttribute("acscc", "ATTEMPT SECTION: "+user.getPayStatus().getAttemptSection());
		
	
		//System.out.println("coupone code= "+user.getDiscountData().getCouponCode().length());
		
		                if(user.getDiscountData() != null) {
		                	
		                	Double value =commonUtil.getDiscountValue(user.getPayStatus().getTotalAmount(), user.getDiscountData().getDiscountPersent());
		                	model.addAttribute("actualamount","\nACTUAL AMOUNT: "+user.getPayStatus().getTotalAmount()+" "+user.getPayStatus().getCourencyType());
		                	model.addAttribute("dcc","DISCOUNT COPON CODE: "+user.getDiscountData().getCouponCode());
		                	model.addAttribute("dp","\nDISCOUNT PERCENT: "+user.getDiscountData().getDiscountPersent());
		                    model.addAttribute("payableamount","PAYABLE AMOUNT: "+value+" "+user.getPayStatus().getCourencyType());
		                	model.addAttribute("amount", user.getPayStatus().getTotalAmount());
		                	model.addAttribute("courency", user.getPayStatus().getCourencyType());
		                  }
		                else {
		                	   model.addAttribute("payableamount", "\nPAYABLE AMOUNT: "+user.getPayStatus().getTotalAmount()+" "+user.getPayStatus().getCourencyType());
		                     }
		                
		     //System.out.println("paymentData="+paymentData);           
		     model.addAttribute("paymentData",paymentData);
        return new ModelAndView("payment"); 
    } 
	
	
	
	
}
