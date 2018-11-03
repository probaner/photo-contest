package com.photo.contest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.utility.SelectData;

public class ProcessJudgingFileController {
	
	
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private SelectData selectData;
	
	
	@RequestMapping("/processfileforjudging")
	public String fileProcesser(Model model){
		
		
		
		return null;
		
	}
	

}
