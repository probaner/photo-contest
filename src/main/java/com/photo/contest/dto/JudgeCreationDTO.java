package com.photo.contest.dto;

import java.util.List;

public class JudgeCreationDTO {
	
	private String firstname;
	private String lastname;
	private String email;
	private String organizerclubName;
	private List<String> category;
	
	public JudgeCreationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JudgeCreationDTO(String firstname, String lastname, String email, String organizerclubName,
			List<String> category) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.organizerclubName = organizerclubName;
		this.category = category;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganizerclubName() {
		return organizerclubName;
	}

	public void setOrganizerclubName(String organizerclubName) {
		this.organizerclubName = organizerclubName;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "JudgeCreationDTO [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", organizerclubName=" + organizerclubName + ", category=" + category + "]";
	}
	
	
}
