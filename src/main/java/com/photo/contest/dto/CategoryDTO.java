package com.photo.contest.dto;

public class CategoryDTO {
	
	private String categoryName;
	
	

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CategoryDTO(String categoryName) {
		super();
		this.categoryName = categoryName;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	@Override
	public String toString() {
		return "CategoryDTO [categoryName=" + categoryName + "]";
	}
	
	
	
	

}
