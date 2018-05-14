package com.photo.contest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:lastid.properties")
public class LastIdProperty {
	@Value("${db.lastId}")
	private String lastId;	
	
	public LastIdProperty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LastIdProperty(String lastId) {
		super();
		this.lastId = lastId;
	}
	
	public String getLastId() {
		return lastId;
	}

	public void setLastId(String lastId) {
		this.lastId = lastId;
	}

}
