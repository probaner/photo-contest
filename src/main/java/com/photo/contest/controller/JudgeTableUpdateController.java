package com.photo.contest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.photo.contest.dto.JudgeTableDTO;
import com.photo.contest.dto.ResponseDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.exception.BusinessException;
import com.photo.contest.service.DbServices;




@Controller
@SessionAttributes({"userForm"})
public class JudgeTableUpdateController {
	
	@Autowired
	DbServices dbServices;
	
	
	@RequestMapping(value = "/admin/json/updatejudgetable")
	public @ResponseBody ResponseDTO updateedittableJson(@RequestBody JudgeTableDTO judgeTableDTO,ModelMap model) throws  BusinessException {
		
		System.out.println("judgeTableDTO="+judgeTableDTO.toString());
		ResponseDTO responseDTO = new ResponseDTO();
		UserDTO userDTO = (UserDTO) model.get("userForm");
		System.out.println("userDTO="+userDTO.toString());
		if(judgeTableDTO!=null) {
			
		   if(judgeTableDTO.getCategory().size() >0) {
			   List<Object> valueList = judgeTableDTO.getCategory().values().stream().collect(Collectors.toList());			   			   
			   if(valueList.contains("Y")) {				  
				  dbServices.updateJudgeTableData(judgeTableDTO, userDTO);
				  responseDTO.setMessage("Successfully Edited");
			     }
			   else
				   responseDTO.setMessage("Category for the Judge Should be Selected");			   
		     }				
		
        }else
	          responseDTO.setError(new Error("Found some Problems, Contact to Admin Team"));
	
	
	
		return responseDTO;	
	}	

}
