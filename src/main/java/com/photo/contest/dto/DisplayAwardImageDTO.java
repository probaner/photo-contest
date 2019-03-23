package com.photo.contest.dto;

public class DisplayAwardImageDTO {
	
	private int imageId;
	private String image;
	private String comment;
		
	public DisplayAwardImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisplayAwardImageDTO(int imageId, String image, String comment) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.comment = comment;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "DisplayReatingImageAwardDTO [imageId=" + imageId + ", image=" + image + ", comment=" + comment + "]";
	}	

}
