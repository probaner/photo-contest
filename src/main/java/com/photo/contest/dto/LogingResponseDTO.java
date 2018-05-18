package com.photo.contest.dto;

import java.util.HashMap;
import java.util.LinkedList;

import com.photo.contest.model.Users;

public class LogingResponseDTO {
	
	private Users user;
	private HashMap<String, LinkedList<DisplayFileDTO>> hm;
	
	public LogingResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogingResponseDTO(Users user, HashMap<String, LinkedList<DisplayFileDTO>> hm) {
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

	public HashMap<String, LinkedList<DisplayFileDTO>> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, LinkedList<DisplayFileDTO>> hm) {
		this.hm = hm;
	}
	
	
	
	

}
