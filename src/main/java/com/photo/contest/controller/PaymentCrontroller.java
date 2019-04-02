package com.photo.contest.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.PayPalPaymentResponseDTO;
import com.photo.contest.dto.ResponseDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.exception.BusinessException;
import com.photo.contest.model.Users;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.CommonUtil;

@Controller
@SessionAttributes({"userForm"})
public class PaymentCrontroller {
	
	@Autowired
	private DbServices dbServices;
	@Autowired
	CommonUtil commonUtil;
	@Autowired
	ConfigProperty configProperty;
	
	@RequestMapping(value = "/json/getpaystatu")  
    public @ResponseBody boolean getrules(ModelMap model) throws IOException {
		
		 boolean responce= dbServices.getPaymentURLResponce((UserDTO) model.get("userForm"));
		
		 return responce;
		 
       } 
	
	@GetMapping("/getpay")  
    public ModelAndView getpay(ModelMap model) throws IOException {
		
		 UserDTO userDTO = (UserDTO) model.get("userForm");
		 Users user = dbServices.getUser(userDTO.getEmail());
		
		   
		String paymentData = null;
		
		model.addAttribute("uid", "USER ID : "+user.getUserId());
		model.addAttribute("uname", "USER NAME : "+user.getFirstName()+" "+user.getLastName());
		model.addAttribute("acscc", "ATTEMPT SECTION : "+user.getPayStatus().getAttemptSection());
		
	
		//System.out.println("coupone code= "+user.getDiscountData().getCouponCode().length());
		
		                if(user.getDiscountData() != null) {
		                	
		                	Double value =commonUtil.getDiscountValue(user.getPayStatus().getTotalAmount(), user.getDiscountData().getDiscountPersent());
		                	model.addAttribute("actualamount","\nACTUAL AMOUNT : "+user.getPayStatus().getTotalAmount()+" "+user.getPayStatus().getCourencyType());
		                	model.addAttribute("dcc","DISCOUNT COPON CODE : "+user.getDiscountData().getCouponCode());
		                	model.addAttribute("dp","\nDISCOUNT PERCENT : "+user.getDiscountData().getDiscountPersent());
		                    model.addAttribute("payableamount","PAYABLE AMOUNT : "+value+" "+user.getPayStatus().getCourencyType());
		                	model.addAttribute("amount", user.getPayStatus().getTotalAmount());
		                	model.addAttribute("courency", user.getPayStatus().getCourencyType().toUpperCase());
		                  }
		                else {
		                	   model.addAttribute("payableamount", "\nPAYABLE AMOUNT: "+user.getPayStatus().getTotalAmount()+" "+user.getPayStatus().getCourencyType());
		                	   model.addAttribute("amount", user.getPayStatus().getTotalAmount());
			                   model.addAttribute("courency", user.getPayStatus().getCourencyType().toUpperCase());
		                     }
		                
		     //System.out.println("paymentData="+paymentData);           
		     model.addAttribute("paymentData",paymentData);
		     
		     model.addAttribute("titel",configProperty.getIndexName());
	  		 model.addAttribute("titelImage",configProperty.getIndexImage());
	  		 model.addAttribute("headerLeft",configProperty.getHeaderLeft());
			 model.addAttribute("headerMiddle",configProperty.getHeaderMiddle());
			 model.addAttribute("headerRight",configProperty.getHeaderRight());
		     
		     
        return new ModelAndView("payment"); 
    } 
	
	
	@RequestMapping(value = "/json/savepaymentdata")
	public @ResponseBody ResponseDTO getPaymentDetails(@RequestBody PayPalPaymentResponseDTO payPalPaymentResponseDTO,ModelMap model) 
			throws IOException, BusinessException, ParseException {
		ResponseDTO responseDTO = new ResponseDTO();
		
	  if(payPalPaymentResponseDTO!=null && payPalPaymentResponseDTO.getTransactionsRelatedresourcesSaleState().toUpperCase().equals("COMPLETED")) {
		 UserDTO userDTO = (UserDTO) model.get("userForm");
		 Users user = dbServices.getUser(userDTO.getEmail()); 
		 payPalPaymentResponseDTO.setUserid(user.getUserId());
		 System.out.println(payPalPaymentResponseDTO.toString());
		 String responce = dbServices.savePaymentResponse(payPalPaymentResponseDTO, user);		
		 responseDTO.setMessage(responce);
	    }else {
	           responseDTO.setMessage("PAYMENT PROCESS FAIL");
	           
	          }   
	  
	  return responseDTO;		
	}
	
}
