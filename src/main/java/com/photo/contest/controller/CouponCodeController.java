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
import com.photo.contest.dto.AcceptenceClubDTO;
import com.photo.contest.dto.BulkMailDTO;
import com.photo.contest.dto.CouponCode;
import com.photo.contest.dto.JudgeCreationDTO;
import com.photo.contest.dto.ProcessFileDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.service.CommonServices;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.SelectData;



@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList","processDataType","mailerType"})
@EnableWebMvc
public class CouponCodeController {
	
	@Autowired
	private CommonServices 	commonServices;
	@Autowired
	private DbServices dbServices;
	@Autowired
	private ConfigProperty configProperty;
	
	@RequestMapping("/createCoupon")
	public String createCouponCode(@RequestParam String action, 
			Model model, 
			@ModelAttribute("couponCode") CouponCode couponCodeBean,			
			@ModelAttribute("userForm") UserDTO userDTO,
			@ModelAttribute("clubDataList") List<String> clubDataList,
			@ModelAttribute("acceptenceClubDTO") AcceptenceClubDTO acceptenceClubDTO,
			@ModelAttribute("bulkMailDTO") BulkMailDTO bulkMailDTO,
			@ModelAttribute("processDataType") Map<String, String> processDataType,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		 model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "+ userDTO.getFirstname().toUpperCase());
		 if (action.equals("createSigle")) {
		    if(couponCodeBean.getUserId()!=null && couponCodeBean.getPersent()!=null) {	
		    	if( commonServices.checkPersentInpout(couponCodeBean.getPersent().trim())) {
		    		
		    	    if(commonServices.checkNumberOnly(couponCodeBean.getUserId().trim())){
		    	    	//System.out.println("I am creating");
		    		    String outPut = dbServices.createSingleCouponeCode(couponCodeBean.getUserId().trim(),couponCodeBean.getPersent().trim(),userDTO.getUserid(),userDTO.getEmail());
		    		    model.addAttribute("couponCodeError",outPut);
		    		   
		    	      }else {
		    	    	      model.addAttribute("couponCodeError","Enter correct userId");
		    	            }
		    	   
		    	  }else {
		    		       
		    		       model.addAttribute("couponCodeError","Enter correct disocount persent");
		    	        }
			   
		      }
		else {
			   model.addAttribute("couponCodeError","Enter a valid data and submit again");
		     }
				
	  }else if (action.equals("createClubCoupon")) {
		        if(couponCodeBean.getClubData()!=null && couponCodeBean.getPersent()!=null) {	
		        	if( commonServices.checkPersentInpout(couponCodeBean.getPersent().trim())) {
		        		if(!couponCodeBean.getClubData().contains(">")) {
		        			model.addAttribute("clubcouponCodeError","Select a valid club name");
		        			model.addAttribute("clubDataList", clubDataList);
		        		  }
		        		else {
		        			  String clubName = couponCodeBean.getClubData().substring(0,couponCodeBean.getClubData().indexOf(" >")).trim();
			        		  //System.out.println("clubName="+clubName);
		        		      dbServices.createClubCouponeCode(clubName,couponCodeBean.getPersent().trim(),userDTO.getUserid(),userDTO.getEmail());
		        		      model.addAttribute("clubcouponCodeError","CouponCode Created");
		        		      model.addAttribute("clubDataList", clubDataList);
		        		     }
		        	  }else { 
		        		      model.addAttribute("clubDataList", clubDataList);
		        		      model.addAttribute("clubcouponCodeError","Enter correct disocount persent");
		        	        }
		        	//System.out.println("club="+couponCodeBean.getClubData()+"   "+couponCodeBean.getPersent());
		          }
		  
	           }
		 
		    model.addAttribute("acceptenceClubDTO",new AcceptenceClubDTO());
			model.addAttribute("couponCode", new CouponCode());
			model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
			model.addAttribute("processDataType", processDataType);
			model.addAttribute("processFileDTO", new ProcessFileDTO());
			model.addAttribute("bulkMailDTO",new BulkMailDTO());
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
