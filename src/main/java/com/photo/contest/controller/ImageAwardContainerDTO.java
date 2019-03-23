package com.photo.contest.controller;

import java.util.List;

import com.photo.contest.dto.DisplayAwardImageDTO;

public class ImageAwardContainerDTO {
	
	private List<DisplayAwardImageDTO> imageList;

	public ImageAwardContainerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ImageAwardContainerDTO(List<DisplayAwardImageDTO> imageList) {
		super();
		this.imageList = imageList;
	}



	public List<DisplayAwardImageDTO> getImageList() {
		return imageList;
	}

	public void setImageList(List<DisplayAwardImageDTO> imageList) {
		this.imageList = imageList;
	}
	
	

}
