package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photo.contest.utility.SelectData;

@Controller
public class CountryController {
		
	@Autowired
	SelectData selectData;
	
	@RequestMapping(value = "/json/getcountrylist")
	public @ResponseBody List<String> getCountryResourcesJson() throws IOException {
		
		List<String> countryList = selectData.countryData();		
		return countryList;
		
	}
	

}
