package com.photo.contest.dto;

import java.io.File;

public class AwardedDataDTO {
	
	File file;
	boolean status;
	
	
	
	
	public AwardedDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public AwardedDataDTO(File file, boolean status) {
		super();
		this.file = file;
		this.status = status;
	}




	public File getFile() {
		return file;
	}




	public void setFile(File file) {
		this.file = file;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
