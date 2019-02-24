package com.photo.contest.dto;

public class EditTableDataDTO {
	
	 private int userId;
     private String address;
     private String city;
     private String club;
     private String country;
     private String firstName;
     private String lastName;
     private String state;
     private String payingStatus;
     private String email;
     
     
	public EditTableDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EditTableDataDTO(int userId, String address, String city, String club, String country, String firstName,
			String lastName, String state, String payingStatus, String email) {
		super();
		this.userId = userId;
		this.address = address;
		this.city = city;
		this.club = club;
		this.country = country;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.payingStatus = payingStatus;
		this.email = email;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getClub() {
		return club;
	}


	public void setClub(String club) {
		this.club = club;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPayingStatus() {
		return payingStatus;
	}


	public void setPayingStatus(String payingStatus) {
		this.payingStatus = payingStatus;
	}

	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "EditTableDataDTO [userId=" + userId + ", address=" + address + ", city=" + city + ", club=" + club
				+ ", country=" + country + ", firstName=" + firstName + ", lastName=" + lastName + ", state=" + state
				+ ", payingStatus=" + payingStatus + "]";
	}
     
     	

}
