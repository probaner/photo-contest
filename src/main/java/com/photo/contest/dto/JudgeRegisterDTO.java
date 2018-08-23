package com.photo.contest.dto;

public class JudgeRegisterDTO {
	
	private int judgeId;
	private String judgeName;
	private String judgeAddress;
	private String judgeCity;
	private String judgePin;
	private String judgeCountry;
	private String judgeEmail;
	private String judgeSex;
	private String judgePassword;
	private String judgeToken;
	
	
	public JudgeRegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public JudgeRegisterDTO(int judgeId, String judgeName, String judgeAddress, String judgeCity, String judgePin,
			String judgeCountry, String judgeEmail, String judgeSex, String judgePassword, String judgeToken) {
		super();
		this.judgeId = judgeId;
		this.judgeName = judgeName;
		this.judgeAddress = judgeAddress;
		this.judgeCity = judgeCity;
		this.judgePin = judgePin;
		this.judgeCountry = judgeCountry;
		this.judgeEmail = judgeEmail;
		this.judgeSex = judgeSex;
		this.judgePassword = judgePassword;
		this.judgeToken = judgeToken;
	}



	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}

	public String getJudgeName() {
		return judgeName;
	}

	public void setJudgeName(String judgeName) {
		this.judgeName = judgeName;
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

	public String getJudgeSex() {
		return judgeSex;
	}

	public void setJudgeSex(String judgeSex) {
		this.judgeSex = judgeSex;
	}

	public String getJudgePassword() {
		return judgePassword;
	}

	public void setJudgePassword(String judgePassword) {
		this.judgePassword = judgePassword;
	}
	
	
	public String getJudgeToken() {
		return judgeToken;
	}

	public void setJudgeToken(String judgeToken) {
		this.judgeToken = judgeToken;
	}



	@Override
	public String toString() {
		return "JudgeRegisterDTO [judgeId=" + judgeId + ", judgeName=" + judgeName + ", judgeAddress=" + judgeAddress
				+ ", judgeCity=" + judgeCity + ", judgePin=" + judgePin + ", judgeCountry=" + judgeCountry
				+ ", judgeEmail=" + judgeEmail + ", judgeSex=" + judgeSex + ", judgePassword=" + judgePassword
				+ ", judgeToken=" + judgeToken + "]";
	}

	
		

}
