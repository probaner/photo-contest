package com.photo.contest.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class DisplayFileDTO {

	private Integer fileId;
	private String titel;
	private String catagoryName;
	private String positionName;
	private String time;
	private String encodedString;

	public DisplayFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisplayFileDTO(Integer fileId, String titel, String catagoryName, String positionName, String time,
			String encodedString) {
		super();
		this.fileId = fileId;
		this.titel = titel;
		this.catagoryName = catagoryName;
		this.positionName = positionName;
		this.time = time;
		this.encodedString = encodedString;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getEncodedString() {
		return encodedString;
	}

	public void setEncodedString(String encodedString) {
		this.encodedString = encodedString;
	}

}
