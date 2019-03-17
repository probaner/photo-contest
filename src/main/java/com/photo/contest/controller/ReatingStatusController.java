package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photo.contest.dto.ReatingStatusTableDTO;
import com.photo.contest.dto.ResponseDTO;
import com.photo.contest.service.DbServices;

@Controller
public class ReatingStatusController {
	
	@Autowired
	DbServices dbServices;
	
	
	
	@RequestMapping(value = "/admin/json/getreatinggraphdata")
	public @ResponseBody ResponseDTO paystatusGraphJson() throws IOException {
		
	ResponseDTO responseDTO = new ResponseDTO();
	if(dbServices.getImageReatingStatus()) {
		
		responseDTO.setMessage("Data Not Available");
		return responseDTO;
		}
	else {
		   Optional<List<ReatingStatusTableDTO>> list = dbServices.getRoundOneJuddingStatus();	
		   responseDTO.setData(list.get());
		   return responseDTO;
				   
	     }
		
		
    }
}
