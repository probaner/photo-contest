package com.photo.contest.dto;

public class OrganizerClubDTO {
	
	private String organizerClubName;
	private int organizerClubId;
		
	public OrganizerClubDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private OrganizerClubDTO(String organizerClubName, int organizerClubId) {
		super();
		this.organizerClubName = organizerClubName;
		this.organizerClubId = organizerClubId;
	}
	public String getOrganizerClubName() {
		return organizerClubName;
	}
	public void setOrganizerClubName(String organizerClubName) {
		this.organizerClubName = organizerClubName;
	}
	
	public int getOrganizerClubId() {
		return organizerClubId;
	}
	public void setOrganizerClubId(int organizerClubId) {
		this.organizerClubId = organizerClubId;
	}
	@Override
	public String toString() {
		return "OrganizerClubDTO [organizerClubName=" + organizerClubName + ", organizerClubId=" + organizerClubId
				+ "]";
	}
	
	
	

}
