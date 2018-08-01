package com.photo.contest.controller;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photo.contest.service.DbServices;

@Controller
public class PaystatusGraphController {
	
	@Autowired
	DbServices dbServices;
	
	@RequestMapping(value = "/admin/json/getpaystatusgraphdata")
	public @ResponseBody Map paystatusGraphJson() throws IOException {
		
			
		Map<String,List<?>> map = dbServices.getPaystatusCountryWise();
		
		System.out.println(map);
				
		return map;
		
	}

}
