package com.photo.contest.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileDTO {
	
	 private Integer fileId;
	 private String titel;
	 private String catagoryName;
	 private String positionName;
	 private CommonsMultipartFile images;
	public FileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public FileDTO(Integer fileId, String titel, String catagoryName, String positionName,
			CommonsMultipartFile images) {
		super();
		this.fileId = fileId;
		this.titel = titel;
		this.catagoryName = catagoryName;
		this.positionName = positionName;
		this.images = images;
	}

    


	public Integer getFileId() {
		return fileId;
	}




	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}




	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public CommonsMultipartFile getImages() {
		return images;
	}
	public void setImages(CommonsMultipartFile images) {
		this.images = images;
	}




	@Override
	public String toString() {
		return "FileDTO [fileId=" + fileId + ", titel=" + titel + ", catagoryName=" + catagoryName + ", positionName="
				+ positionName + ", images=" + images + "]";
	}
	
	
	 
	
}
