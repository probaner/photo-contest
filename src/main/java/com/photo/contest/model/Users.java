package com.photo.contest.model;

// default package
// Generated May 11, 2018 12:05:26 PM by Hibernate Tools 3.2.2.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users")
public class Users  implements java.io.Serializable {


     private int userId;
     private String address;
     private String city;
     private String club;
     private String country;
     private Date createdOn;
     private String email;
     private String firstName;
     private String gender;
     private String honer;
     private Date lastLoggin;
     private String lastName;
     private String password;
     private String role;
     private String state;
     private String forgetPasswAuthToken;
     private OrganizerClub judgeOrganizerClub;
     private String createdBy;
     private String judgeRegistrationToken;
     private PayStatus payStatus;
     private Set<File> files = new HashSet<File>(0);
     private DiscountData discountData;
     private Set<Category> judgeCategoryMapping;

    public Users() {
    }

	
    
  
   
    public Users(int userId, String address, String city, String club, String country, Date createdOn, String email,
			String firstName, String gender, String honer, Date lastLoggin, String lastName, String password,
			String role, String state, String forgetPasswAuthToken, OrganizerClub judgeOrganizerClub, String createdBy,
			String judgeRegistrationToken) {
		super();
		this.userId = userId;
		this.address = address;
		this.city = city;
		this.club = club;
		this.country = country;
		this.createdOn = createdOn;
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.honer = honer;
		this.lastLoggin = lastLoggin;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.state = state;
		this.forgetPasswAuthToken = forgetPasswAuthToken;
		this.judgeOrganizerClub = judgeOrganizerClub;
		this.createdBy = createdBy;
		this.judgeRegistrationToken = judgeRegistrationToken;
	}





	@Id   
    @Column(name="user_id", unique=true, nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Column(name="address", nullable=true, length=500)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="city", nullable=true, length=200)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="club" , nullable=true, length=200)
    public String getClub() {
        return this.club;
    }
    
    public void setClub(String club) {
        this.club = club;
    }
    
    @Column(name="country", nullable=true, length=200)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", nullable=false, length=19)
    public Date getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    @Column(name="email", nullable=false, length=200, unique=true)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="first_name", nullable=false, length=200)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="gender", nullable=true, length=200)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Column(name="honer", nullable=true, length=200)
    public String getHoner() {
        return this.honer;
    }
    
    public void setHoner(String honer) {
        this.honer = honer;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_loggin", nullable=false, length=19)
    public Date getLastLoggin() {
        return this.lastLoggin;
    }
    
    public void setLastLoggin(Date lastLoggin) {
        this.lastLoggin = lastLoggin;
    }
    
    @Column(name="last_name", nullable=false, length=200)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="password", nullable=true, length=200)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="role", nullable=false, length=45)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    @Column(name="state", nullable=true, length=200)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
    public Set<File> getFiles() {
        return this.files;
    }
    
    public void setFiles(Set<File> files) {
        this.files = files;
    }


    @OneToOne(mappedBy="users",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
	public PayStatus getPayStatus() {
		return payStatus;
	}


	public void setPayStatus(PayStatus payStatus) {
		this.payStatus = payStatus;
	}

	@OneToOne(mappedBy="users",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
	public DiscountData getDiscountData() {
		return discountData;
	}


	public void setDiscountData(DiscountData discountData) {
		this.discountData = discountData;
	}

	@Column(name="forget_passw_auth_token", nullable=true, length=200)
	public String getForgetPasswAuthToken() {
		return forgetPasswAuthToken;
	}

	public void setForgetPasswAuthToken(String forgetPasswAuthToken) {
		this.forgetPasswAuthToken = forgetPasswAuthToken;
	}
	
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="judge_organize_club_id", nullable=true)
	public OrganizerClub getJudgeOrganizerClub() {
		return judgeOrganizerClub;
	}


	public void setJudgeOrganizerClub(OrganizerClub judgeOrganizerClub) {
		this.judgeOrganizerClub = judgeOrganizerClub;
	}
	
	@Column(name="judge_registration_token", nullable=true, length=200)
	public String getJudgeRegistrationToken() {
		return judgeRegistrationToken;
	   }


	public void setJudgeRegistrationToken(String judgeRegistrationToken) {
		this.judgeRegistrationToken = judgeRegistrationToken;
	}
	
	
	@Column(name="created_by", nullable=true, length=45)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "judge_category_mapping",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "category_id"))
	public Set<Category> getJudgeCategoryMapping() {
		return judgeCategoryMapping;
	}

	
	public void setJudgeCategoryMapping(Set<Category> judgeCategoryMapping) {
		this.judgeCategoryMapping = judgeCategoryMapping;
	}





	@Override
	public String toString() {
		return "Users [userId=" + userId + ", address=" + address + ", city=" + city + ", club=" + club + ", country="
				+ country + ", createdOn=" + createdOn + ", email=" + email + ", firstName=" + firstName + ", gender="
				+ gender + ", honer=" + honer + ", lastLoggin=" + lastLoggin + ", lastName=" + lastName + ", password="
				+ password + ", role=" + role + ", state=" + state + ", forgetPasswAuthToken=" + forgetPasswAuthToken
				+ ", judgeOrganizerClub=" + judgeOrganizerClub + ", createdBy=" + createdBy
				+ ", judgeRegistrationToken=" + judgeRegistrationToken + "]";
	}
	
	
	


}


