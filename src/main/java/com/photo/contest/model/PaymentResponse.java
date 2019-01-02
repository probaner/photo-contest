package com.photo.contest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="payment_response")
public class PaymentResponse implements java.io.Serializable{
	
	private String id;
	private String createdTime;
	private String updateTime;
	private String state;
	private String payerEmail;
	private String payerName;
	private String transsectionAmount;
	private String transsectionCourency;
	private String paymentResponse;
	private int userId;
	
	
	public PaymentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	@Id 
    @Column(name="id", unique=true, nullable=false, length=100)
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

 
	
  //@Temporal(TemporalType.TIMESTAMP)
   @Column(name="created_time", nullable=false, length=45)
	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time", nullable=false, length=45)
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	

	@Column(name="state", nullable=false, length=45)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="payer_email", nullable=false, length=100)
	public String getPayerEmail() {
		return payerEmail;
	}


	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}

	@Column(name="payer_name", nullable=false, length=100)
	public String getPayerName() {
		return payerName;
	}


	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

    @Column(name="transsection_amount", unique=false, nullable=false,length=45 )	
    public String getTranssectionAmount() {
		return transsectionAmount;
	}

	public void setTranssectionAmount(String transsectionAmount) {
		this.transsectionAmount = transsectionAmount;
	}    

    @Column(name="transsection_courency", nullable=false, length=45)
	public String getTranssectionCourency() {
		return transsectionCourency;
	}

	public void setTranssectionCourency(String transsectionCourency) {
		this.transsectionCourency = transsectionCourency;
	}

	
	@Column(name="payment_response_data",length = 100000, columnDefinition = "text", nullable=false)
	public String getPaymentResponse() {
		return paymentResponse;
	}


	public void setPaymentResponse(String paymentResponse) {
		this.paymentResponse = paymentResponse;
	}

    @Column(name="user_id", unique=false, nullable=false)
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	

}
