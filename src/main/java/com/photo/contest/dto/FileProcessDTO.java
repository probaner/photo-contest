package com.photo.contest.dto;

public class FileProcessDTO {
	
	private Integer file_id;
	private byte[] file;	
	
	private FileProcessDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	private FileProcessDTO(Integer file_id, byte[] file) {
		super();
		this.file_id = file_id;
		this.file = file;
	}


	public Integer getFile_id() {
		return file_id;
	}


	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}


	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	} 
	
	
	

}
