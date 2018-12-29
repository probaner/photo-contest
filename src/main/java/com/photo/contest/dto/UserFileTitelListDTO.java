package com.photo.contest.dto;

public class UserFileTitelListDTO {
	
	private String titel;
	private String  category_index;
	
	
	public UserFileTitelListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserFileTitelListDTO(String titel, String category_index) {
		super();
		this.titel = titel;
		this.category_index = category_index;
	}


	public String getTitel() {
		return titel;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}


	public String getCategory_index() {
		return category_index;
	}


	public void setCategory_index(String category_index) {
		this.category_index = category_index;
	}


	@Override
	public String toString() {
		return "UserFileTitelListDTO [titel=" + titel + ", category_index=" + category_index + "]";
	}

	
	

	

}
