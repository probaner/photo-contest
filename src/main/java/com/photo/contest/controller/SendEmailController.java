package com.photo.contest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.MailRecipientDTO;
import com.photo.contest.service.CommonServices;

@Controller
@EnableWebMvc
public class SendEmailController {
	
	@Autowired
	private CommonServices commonServices;
	@Autowired
	private ConfigProperty configProperty;
	
	
	public void setCommonServices(CommonServices commonServices) {
		this.commonServices = commonServices;
	}

	@RequestMapping("/getContuctUs" )
    public String fetchEmailForm(Map<String, Object> model) {
		
		
		 //System.out.println("I am calling conroler");
		
		  model.put("titel",configProperty.getIndexName());
		  model.put("titelImage",configProperty.getIndexImage());
		  model.put("headerLeft",configProperty.getHeaderLeft());
		  model.put("headerMiddle",configProperty.getHeaderMiddle());
		  model.put("headerRight",configProperty.getHeaderRight());
		
		MailRecipientDTO mailRecipientform = new MailRecipientDTO();
		model.put("mailRecipientform", mailRecipientform);
	   return "emailForm";		
	}
	
	
	@RequestMapping(value="/processmail", method = RequestMethod.POST)
    public String doSendEmail(@ModelAttribute("mailRecipientform") MailRecipientDTO mailRecipientDTO, Map<String, Object> model) {	
		//if(action.equals("processmail")){
		 //System.out.println("In controler");
		
		    model.put("titel",configProperty.getIndexName());
			model.put("titelImage",configProperty.getIndexImage());
			model.put("headerLeft",configProperty.getHeaderLeft());
			model.put("headerMiddle",configProperty.getHeaderMiddle());
			model.put("headerRight",configProperty.getHeaderRight());
		
		   //System.out.println(mailRecipientDTO.toString());
		   commonServices.sendQueryEmail(mailRecipientDTO);
		   model.put("massage","mail send succesful");
		//}
	       return "emailForm";
	    }		
}
