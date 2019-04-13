package com.photo.contest.dto;

public class BulkMailDTO {
	
	String mailerType;
	String mailSubject;
	String mailerList;
	String mailBody;
	
	public BulkMailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BulkMailDTO(String mailerType, String mailSubject, String mailerList, String mailBody) {
		super();
		this.mailerType = mailerType;
		this.mailSubject = mailSubject;
		this.mailerList = mailerList;
		this.mailBody = mailBody;
	}

	public String getMailerType() {
		return mailerType;
	}

	public void setMailerType(String mailerType) {
		this.mailerType = mailerType;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailerList() {
		return mailerList;
	}

	public void setMailerList(String mailerList) {
		this.mailerList = mailerList;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	@Override
	public String toString() {
		return "BulkMailDTO [mailerType=" + mailerType + ", mailSubject=" + mailSubject + ", mailerList=" + mailerList
				+ ", mailBody=" + mailBody + "]";
	}
	
	
	
	

}
