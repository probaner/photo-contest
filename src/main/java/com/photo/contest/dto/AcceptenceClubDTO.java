package com.photo.contest.dto;

import java.util.List;

public class AcceptenceClubDTO {
	
	private String clubName;
	private List<String> data;
	private List<String> awardList;
	
	
	public AcceptenceClubDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AcceptenceClubDTO(String clubName, List<String> data, List<String> awardList) {
		super();
		this.clubName = clubName;
		this.data = data;
		this.awardList = awardList;
	}


	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
		
	public List<String> getAwardList() {
		return awardList;
	}


	public void setAwardList(List<String> awardList) {
		this.awardList = awardList;
	}


	@Override
	public String toString() {
		return "AcceptenceClubDTO [clubName=" + clubName + ", data=" + data + ", awardList=" + awardList + "]";
	}	
	
}
