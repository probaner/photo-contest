package com.photo.contest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.photo.contest.service.DbServices;

@Component
public class SpringApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	DbServices dbServices;
	
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		dbServices.getCategoryMap();
      
    }

}
