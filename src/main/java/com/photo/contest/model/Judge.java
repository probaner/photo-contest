package com.photo.contest.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="judge"
    ,catalog="vibgyorci_salon")
public class Judge implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int judgeId;
	private String judgeName;
	private String judgeAddress;
	private String judgeCity;
	private String judgePin;
	private String judgeCountry;
	private String judgeEmail;
	private String judgeSex;
	private String judgePassword;
	private OrganizerClub judgeOrganizerClub;
	private Users judgeCreatedBy;
	private Date judgeCreatedTime;
	private Date judgeRegistrationTime;
	private String judgeRegistrationToken;
	private String judgePasswordChangeToken;
	private Date judgeLastUpdateTime;
	private Set<Category> judgeCategoryMapping;
	
	
	public Judge() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Judge(int judgeId, String judgeName, String judgeAddress, String judgeCity, String judgePin,
			String judgeCountry, String judgeEmail, String judgeSex, String judgePassword,
			OrganizerClub judgeOrganizerClub, Users judgeCreatedBy, Date judgeCreatedTime, Date judgeRegistrationTime,
			String judgeRegistrationToken, String judgePasswordChangeToken, Date judgeLastUpdateTime,
			Set<Category> judgeCategoryMapping) {
		super();
		this.judgeId = judgeId;
		this.judgeName = judgeName;
		this.judgeAddress = judgeAddress;
		this.judgeCity = judgeCity;
		this.judgePin = judgePin;
		this.judgeCountry = judgeCountry;
		this.judgeEmail = judgeEmail;
		this.judgeSex = judgeSex;
		this.judgePassword = judgePassword;
		this.judgeOrganizerClub = judgeOrganizerClub;
		this.judgeCreatedBy = judgeCreatedBy;
		this.judgeCreatedTime = judgeCreatedTime;
		this.judgeRegistrationTime = judgeRegistrationTime;
		this.judgeRegistrationToken = judgeRegistrationToken;
		this.judgePasswordChangeToken = judgePasswordChangeToken;
		this.judgeLastUpdateTime = judgeLastUpdateTime;
		this.judgeCategoryMapping = judgeCategoryMapping;
	}




	@Id 
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="judge_id", unique=true, nullable=false)
	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}


	@Column(name="judge_name", nullable=false, length=100)
	public String getJudgeName() {
		return judgeName;
	}


	public void setJudgeName(String judgeName) {
		this.judgeName = judgeName;
	}

	@Column(name="judge_address", nullable=true, length=150)
	public String getJudgeAddress() {
		return judgeAddress;
	}


	public void setJudgeAddress(String judgeAddress) {
		this.judgeAddress = judgeAddress;
	}

	@Column(name="judge_city", nullable=true, length=45)
	public String getJudgeCity() {
		return judgeCity;
	}


	public void setJudgeCity(String judgeCity) {
		this.judgeCity = judgeCity;
	}

	@Column(name="judge_pin", nullable=true, length=12)
	public String getJudgePin() {
		return judgePin;
	}


	public void setJudgePin(String judgePin) {
		this.judgePin = judgePin;
	}

	@Column(name="judge_country", nullable=true, length=50)
	public String getJudgeCountry() {
		return judgeCountry;
	}


	public void setJudgeCountry(String judgeCountry) {
		this.judgeCountry = judgeCountry;
	}

	@Column(name="judge_email", nullable=false, length=100,unique=true)
	public String getJudgeEmail() {
		return judgeEmail;
	}


	public void setJudgeEmail(String judgeEmail) {
		this.judgeEmail = judgeEmail;
	}

	@Column(name="judge_sex", nullable=true, length=45)
	public String getJudgeSex() {
		return judgeSex;
	}


	public void setJudgeSex(String judgeSex) {
		this.judgeSex = judgeSex;
	}

	@Column(name="judge_password", nullable=true, length=200)
	public String getJudgePassword() {
		return judgePassword;
	}


	public void setJudgePassword(String judgePassword) {
		this.judgePassword = judgePassword;
	}

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="judge_organize_club_id", nullable=false)
	public OrganizerClub getJudgeOrganizerClub() {
		return judgeOrganizerClub;
	}


	public void setJudgeOrganizerClub(OrganizerClub judgeOrganizerClub) {
		this.judgeOrganizerClub = judgeOrganizerClub;
	}

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="judge_created_by", nullable=false)
	public Users getJudgeCreatedBy() {
		return judgeCreatedBy;
	}


	public void setJudgeCreatedBy(Users judgeCreatedBy) {
		this.judgeCreatedBy = judgeCreatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="judge_created_time", nullable=false, length=19)
	public Date getJudgeCreatedTime() {
		return judgeCreatedTime;
	}


	public void setJudgeCreatedTime(Date judgeCreatedTime) {
		this.judgeCreatedTime = judgeCreatedTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="judge_registration_time", nullable=true, length=19)
	public Date getJudgeRegistrationTime() {
		return judgeRegistrationTime;
	}

	
	public void setJudgeRegistrationTime(Date judgeRegistrationTime) {
		this.judgeRegistrationTime = judgeRegistrationTime;
	}

	@Column(name="judge_registration_token", nullable=false, length=200)
	public String getJudgeRegistrationToken() {
		return judgeRegistrationToken;
	}


	public void setJudgeRegistrationToken(String judgeRegistrationToken) {
		this.judgeRegistrationToken = judgeRegistrationToken;
	}

	@Column(name="judge_password_change_token", nullable=true, length=200)
	public String getJudgePasswordChangeToken() {
		return judgePasswordChangeToken;
	}


	public void setJudgePasswordChangeToken(String judgePasswordChangeToken) {
		this.judgePasswordChangeToken = judgePasswordChangeToken;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="judge_last_update_time", nullable=false, length=19)
	public Date getJudgeLastUpdateTime() {
		return judgeLastUpdateTime;
	}


	public void setJudgeLastUpdateTime(Date judgeLastUpdateTime) {
		this.judgeLastUpdateTime = judgeLastUpdateTime;
	}



	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "judge_category_mapping",
	            joinColumns = @JoinColumn(name = "judge_id"),
	            inverseJoinColumns = @JoinColumn(name = "category_id"))
	public Set<Category> getJudgeCategoryMapping() {
		return judgeCategoryMapping;
	}

	public void setJudgeCategoryMapping(Set<Category> judgeCategoryMapping) {
		this.judgeCategoryMapping = judgeCategoryMapping;
	}

	
	
	
	
	
	

}
