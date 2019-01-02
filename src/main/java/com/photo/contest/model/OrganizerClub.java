package com.photo.contest.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="organizer_club"
    , uniqueConstraints = @UniqueConstraint(columnNames="organizer_club_id")
)
public class OrganizerClub implements java.io.Serializable{
	
	private int organizerclubid;
	private String organizerclubname;
	
		
	public OrganizerClub() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrganizerClub(int organizerclubid, String organizerclubname) {
		super();
		this.organizerclubid = organizerclubid;
		this.organizerclubname = organizerclubname;
	}


	@Id 
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="organizer_club_id", unique=true, nullable=false)
	public int getOrganizerclubid() {
		return organizerclubid;
	}


	public void setOrganizerclubid(int organizerclubid) {
		this.organizerclubid = organizerclubid;
	}


	@Column(name="organizer_club_name", nullable=false, length=100)
	public String getOrganizerclubname() {
		return organizerclubname;
	}


	public void setOrganizerclubname(String organizerclubname) {
		this.organizerclubname = organizerclubname;
	}
	

}
