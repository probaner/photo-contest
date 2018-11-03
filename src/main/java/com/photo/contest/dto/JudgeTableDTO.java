package com.photo.contest.dto;

import java.util.Map;

public class JudgeTableDTO {
	
	private int judgeId;
	private String judgeFirstname;
	private String judgeLastname;
	private String judgeAddress;
	private String judgeCity;
	private String judgePin;
	private String judgeCountry;
	private String judgeEmail;
	private String organizerclubName;
	private Map<String, String> category;
		
	
	public JudgeTableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JudgeTableDTO(int judgeId, String judgeFirstname, String judgeLastname, String judgeAddress,
			String judgeCity, String judgePin, String judgeCountry, String judgeEmail, String organizerclubName,
			Map<String, String> category) {
		super();
		this.judgeId = judgeId;
		this.judgeFirstname = judgeFirstname;
		this.judgeLastname = judgeLastname;
		this.judgeAddress = judgeAddress;
		this.judgeCity = judgeCity;
		this.judgePin = judgePin;
		this.judgeCountry = judgeCountry;
		this.judgeEmail = judgeEmail;
		this.organizerclubName = organizerclubName;
		this.category = category;
	}



	public int getJudgeId() {
		return judgeId;
	}





	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}





	public String getJudgeFirstname() {
		return judgeFirstname;
	}


	public void setJudgeFirstname(String judgeFirstname) {
		this.judgeFirstname = judgeFirstname;
	}


	public String getJudgeLastname() {
		return judgeLastname;
	}


	public void setJudgeLastname(String judgeLastname) {
		this.judgeLastname = judgeLastname;
	}


	public String getJudgeAddress() {
		return judgeAddress;
	}


	public void setJudgeAddress(String judgeAddress) {
		this.judgeAddress = judgeAddress;
	}


	public String getJudgeCity() {
		return judgeCity;
	}


	public void setJudgeCity(String judgeCity) {
		this.judgeCity = judgeCity;
	}


	public String getJudgePin() {
		return judgePin;
	}


	public void setJudgePin(String judgePin) {
		this.judgePin = judgePin;
	}



	public String getJudgeCountry() {
		return judgeCountry;
	}



	public void setJudgeCountry(String judgeCountry) {
		this.judgeCountry = judgeCountry;
	}





	public String getJudgeEmail() {
		return judgeEmail;
	}





	public void setJudgeEmail(String judgeEmail) {
		this.judgeEmail = judgeEmail;
	}


	public String getOrganizerclubName() {
		return organizerclubName;
	}


	public void setOrganizerclubName(String organizerclubName) {
		this.organizerclubName = organizerclubName;
	}


	public Map<String, String> getCategory() {
		return category;
	}


	public void setCategory(Map<String, String> category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "JudgeTableDTO [judgeId=" + judgeId + ", judgeFirstname=" + judgeFirstname + ", judgeLastname="
				+ judgeLastname + ", judgeAddress=" + judgeAddress + ", judgeCity=" + judgeCity + ", judgePin="
				+ judgePin + ", judgeCountry=" + judgeCountry + ", judgeEmail=" + judgeEmail + ", organizerclubName="
				+ organizerclubName + ", category=" + category + "]";
	}

		
}
