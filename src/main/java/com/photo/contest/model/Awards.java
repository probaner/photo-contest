package com.photo.contest.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="awards")
public class Awards implements java.io.Serializable{
	
	private int id ;
	private String awardName;
	private int awardCount ;
	
	
	
	public Awards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Awards(int id, String awardName, int awardCount) {
		super();
		this.id = id;
		this.awardName = awardName;
		this.awardCount = awardCount;
	}
	
	@Id 
	@GeneratedValue(strategy=IDENTITY)    
    @Column(name="id", unique=true, nullable=false)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


    @Column(name="award_name", nullable=false, unique=true,length=100)
    public String getAwardName() {
		return awardName;
	}


    public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

    @Column(name="award_count", nullable=false, unique=false)
    public int getAwardCount() {
	    return awardCount;
    }

    public void setAwardCount(int awardCount) {
	     this.awardCount = awardCount;
    }
	
	

}
