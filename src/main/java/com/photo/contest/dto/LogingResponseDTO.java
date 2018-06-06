package com.photo.contest.dto;

import java.util.HashMap;

import com.photo.contest.model.Users;

public class LogingResponseDTO {
	
	private Users user;
	private HashMap<String, FileDTO> hm;
	
	public LogingResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogingResponseDTO(Users user, HashMap<String, FileDTO> hm) {
		super();
		this.user = user;
		this.hm = hm;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public HashMap<String, FileDTO> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, FileDTO> hm) {
		this.hm = hm;
	}

	
		

}
