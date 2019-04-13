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
import com.photo.contest.dto.ResponseDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.service.CommonServices;
import com.photo.contest.service.DbServices;

@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList","processDataType","mailerType"})
@EnableWebMvc
public class AcceptenceDataController {

	@Autowired
	private DbServices dbServices;
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	CommonServices commonServices;
	
	@RequestMapping("/getAcceptDataListofaClub")
	public String getAcceptData(@RequestParam String action, 
			Model model, 					
			@ModelAttribute("couponCode") CouponCode couponCodeBean,			
			@ModelAttribute("userForm") UserDTO userDTO,
			@ModelAttribute("clubDataList") List<String> clubDataList,
			@ModelAttribute("acceptenceClubDTO") AcceptenceClubDTO acceptenceClubDTO,
			@ModelAttribute("bulkMailDTO") BulkMailDTO bulkMailDTO,
			@ModelAttribute("processDataType") Map<String, String> processDataType,		
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
	if (action.equals("getAceptData") && acceptenceClubDTO.getData()==null) {
		if(acceptenceClubDTO.getClubName().length()>0) {//when club name selected
		   //System.out.println("CLUB Name: "+acceptenceClubDTO.getClubName());
			ResponseDTO responseDTO =responseDTO = commonServices.populateAcceptedDataTable(acceptenceClubDTO.getClubName().trim());//retrive data for the club
		   if(responseDTO.getMessage()!=null && !responseDTO.getMessage().startsWith("!")) {			   
			   model.addAttribute("acceptedDataError", responseDTO.getMessage());
			   model.addAttribute("acceptenceClubDTO",new AcceptenceClubDTO());
		     }else {
		    	      model.addAttribute("acceptenceClubDTO",acceptenceClubDTO);   
		    	      model.addAttribute("acceptedDataList", responseDTO.getData());
		    	      model.addAttribute("organizerClubName", acceptenceClubDTO.getClubName().trim());
		    	      model.addAttribute("acceptedDataError", responseDTO.getMessage());
		           }
		   
		  }
		 else {// when club not selected
		    	model.addAttribute("acceptedDataError", "Select Club Name"); 
		    	model.addAttribute("acceptenceClubDTO",new AcceptenceClubDTO());
		     }
	  }else if(action.equals("getAceptData") && acceptenceClubDTO.getData()!=null){// when acceptence data is available	
		       if(acceptenceClubDTO.getAwardList()!=null && acceptenceClubDTO.getData()!=null){
		          //System.out.println("acceptenceClubDTO="+acceptenceClubDTO.toString());
		          //System.out.println(acceptenceClubDTO.getAwardList());
		          String response1=dbServices.saveAcceptedData(acceptenceClubDTO);
		          model.addAttribute("acceptedDataError", response1);		       		         
		         }else if(acceptenceClubDTO.getAwardList()==null || acceptenceClubDTO.getData() ==null){
		        	      model.addAttribute("acceptedDataError","select accepted data list and award list for "+acceptenceClubDTO.getClubName());
		        	      //model.addAttribute("acceptedDataList", responseDTO.getData());
		                 }
		         
		       model.addAttribute("acceptenceClubDTO",new AcceptenceClubDTO());
	          }
	
		
	model.addAttribute("couponCode", new CouponCode());
	model.addAttribute("processFileDTO", new ProcessFileDTO());
	model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
	model.addAttribute("bulkMailDTO",new BulkMailDTO());
	model.addAttribute("processFileDTO", new ProcessFileDTO());
		
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

