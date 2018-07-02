package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photo.contest.utility.SelectData;

@Controller
public class CountryController {
		
	@Autowired
	SelectData selectData;
	
	@RequestMapping(value = "/admin/json/getcountrylist")
	public @ResponseBody Map<String,String> getCountryResourcesJson() throws IOException {
		
		Map<String,String> countryList = selectData.countryData();		
		return countryList;
		
	}
	

}
