package com.photo.contest.dto;

public class ResetpasswordDTO {
	
	private String password;
	private String confirm_password;
	private String token;
	
	public ResetpasswordDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ResetpasswordDTO(String password, String confirm_password, String token) {
		super();
		this.password = password;
		this.confirm_password = confirm_password;
		this.token = token;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirm_password() {
		return confirm_password;
	}



	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}

}
