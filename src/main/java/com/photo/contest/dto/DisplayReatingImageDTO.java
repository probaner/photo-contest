package com.photo.contest.dto;

public class DisplayReatingImageDTO {
	
	private int imageId;
	private String image;
	private int reating;
	
	public DisplayReatingImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisplayReatingImageDTO(int imageId, String image, int reating) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.reating = reating;
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

	public int getReating() {
		return reating;
	}

	public void setReating(int reating) {
		this.reating = reating;
	}

	@Override
	public String toString() {
		return "DisplayReatingImageDTO [imageId=" + imageId + ", image=" + image + ", reating=" + reating + "]";
	}
	
}
