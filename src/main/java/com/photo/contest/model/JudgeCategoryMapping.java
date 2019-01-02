package com.photo.contest.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="judge_category_mapping")
public class JudgeCategoryMapping implements java.io.Serializable{
	
/*	private int judgeCategoryMappingID;
	private Judge judge ;
	private Category category;
	
	
	public JudgeCategoryMapping() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JudgeCategoryMapping(int judgeCategoryMappingID, Judge judge, Category category) {
		super();
		this.judgeCategoryMappingID = judgeCategoryMappingID;
		this.judge = judge;
		this.category = category;
	}

	@Id 
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="judge_section_mapping_id", unique=true, nullable=false)
	public int getJudgeCategoryMappingID() {
		return judgeCategoryMappingID;
	}


	public void setJudgeCategoryMappingID(int judgeCategoryMappingID) {
		this.judgeCategoryMappingID = judgeCategoryMappingID;
	}

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="judge_id", nullable=false)
	public Judge getJudge() {
		return judge;
	}


	public void setJudge(Judge judge) {
		this.judge = judge;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}*/
	
	
	

}
