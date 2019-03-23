package com.photo.contest.controller;

import java.util.List;

import com.photo.contest.dto.DisplayReatingImageAwardDTO;

public class ImageAwardContainerDTO {
	
	private List<DisplayReatingImageAwardDTO> imageList;

	public ImageAwardContainerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ImageAwardContainerDTO(List<DisplayReatingImageAwardDTO> imageList) {
		super();
		this.imageList = imageList;
	}



	public List<DisplayReatingImageAwardDTO> getImageList() {
		return imageList;
	}

	public void setImageList(List<DisplayReatingImageAwardDTO> imageList) {
		this.imageList = imageList;
	}
	
	

}
