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
import com.photo.contest.service.DbServices;

@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList","processDataType","mailerType"})
@EnableWebMvc
public class BulkMailController {
	
	@Autowired
	ConfigProperty configProperty;
	@Autowired
	DbServices dbServices;
	
	@RequestMapping("/sendBulkMail")
	public String sendBulkMail(@RequestParam String action, 
			Model model, 					
			@ModelAttribute("couponCode") CouponCode couponCodeBean,			
			@ModelAttribute("userForm") UserDTO userDTO,
			@ModelAttribute("clubDataList") List<String> clubDataList,
			@ModelAttribute("acceptenceClubDTO") AcceptenceClubDTO acceptenceClubDTO,
			@ModelAttribute("bulkMailDTO") BulkMailDTO bulkMailDTO,
			@ModelAttribute("processDataType") Map<String, String> processDataType,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		if (action.equals("getMailerData") && bulkMailDTO!=null) {
		     
				/*System.out.println(bulkMailDTO.getMailBody());
				System.out.println(bulkMailDTO.getMailerType());
				System.out.println(bulkMailDTO.getMailSubject());
				//System.out.println(bulkMailDTO.getMailBody());
*/				if(bulkMailDTO.getMailBody()!=null && bulkMailDTO.getMailerType()!="" && bulkMailDTO.getMailSubject()!=null){
				    dbServices.sendBulkMail(bulkMailDTO);
				    model.addAttribute("bulkMailError", "! mail send sucessfully !");
				    }
                else{
                    	model.addAttribute("bulkMailError", "! try again !");
                    }

		}
		
		model.addAttribute("couponCode", new CouponCode());
		model.addAttribute("processFileDTO", new ProcessFileDTO());
		model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
		model.addAttribute("acceptenceClubDTO",new AcceptenceClubDTO());
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
