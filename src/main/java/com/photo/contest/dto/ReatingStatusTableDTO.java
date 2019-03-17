package com.photo.contest.dto;

public class ReatingStatusTableDTO {
	
	
	private String clubName;
	private String judgeName;
	private String categoryName;
	private String totalImageCount;
	private String reatedImageCount;
	private String unreatedImageCount;
	
	
	
	public ReatingStatusTableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReatingStatusTableDTO(String clubName, String judgeName, String categoryName, String totalImageCount,
			String reatedImageCount, String unreatedImageCount) {
		super();
		this.clubName = clubName;
		this.judgeName = judgeName;
		this.categoryName = categoryName;
		this.totalImageCount = totalImageCount;
		this.reatedImageCount = reatedImageCount;
		this.unreatedImageCount = unreatedImageCount;
	}




	public String getClubName() {
		return clubName;
	}




	public void setClubName(String clubName) {
		this.clubName = clubName;
	}




	public String getJudgeName() {
		return judgeName;
	}




	public void setJudgeName(String judgeName) {
		this.judgeName = judgeName;
	}




	public String getCategoryName() {
		return categoryName;
	}




	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




	public String getTotalImageCount() {
		return totalImageCount;
	}




	public void setTotalImageCount(String totalImageCount) {
		this.totalImageCount = totalImageCount;
	}




	public String getReatedImageCount() {
		return reatedImageCount;
	}




	public void setReatedImageCount(String reatedImageCount) {
		this.reatedImageCount = reatedImageCount;
	}




	public String getUnreatedImageCount() {
		return unreatedImageCount;
	}




	public void setUnreatedImageCount(String unreatedImageCount) {
		this.unreatedImageCount = unreatedImageCount;
	}
	

}
