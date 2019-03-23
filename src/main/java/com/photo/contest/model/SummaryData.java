package com.photo.contest.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="summary_data" 
      ,uniqueConstraints = @UniqueConstraint(columnNames={"organizerclub_id", "category_id", "image_id"}))

public class SummaryData implements java.io.Serializable{
	
	private int id;
	private int orginizerClubId;
	private int categoryId;
	private int score;
	private String award;
	private int imageId;
	
	
	public SummaryData() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	





	public SummaryData(int id, int orginizerClubId, int categoryId, int score, String award, int imageId) {
		super();
		this.id = id;
		this.orginizerClubId = orginizerClubId;
		this.categoryId = categoryId;
		this.score = score;
		this.award = award;
		this.imageId = imageId;
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

	@Column(name="organizerclub_id", nullable=false, length=2)
	public int getOrginizerClubId() {
		return orginizerClubId;
	}


	public void setOrginizerClubId(int orginizerClubId) {
		this.orginizerClubId = orginizerClubId;
	}

	
	@Column(name="category_id", nullable=false, length=2)
	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	@Column(name="image_id", nullable=false, length=2)
	public int getImageId() {
		return imageId;
	}


	public void setImageId(int imageId) {
		this.imageId = imageId;
	}


	@Column(name="award", nullable=true, length=100)
	public String getAward() {
		return award;
	}


	
	public void setAward(String award) {
		this.award = award;
	}

	@Column(name="score", nullable=false, length=2)
	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}	
	
	
	

}
