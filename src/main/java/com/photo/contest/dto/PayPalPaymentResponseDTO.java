package com.photo.contest.dto;

//@JsonDeserialize(using = PayPalPaymentResponseDeserializer.class)
public class PayPalPaymentResponseDTO {
	
	
	private String parentPaymentId;
	private String paymentAmount;
	private String paymentCurrency;
	private String transactionsRelatedresourcesSaleState;
	private String transactionsRelatedresourcesSaleUpdatetime;
	private String transactionsRelatedresourcesSaleCreatetime;
	private Integer userid;
	private String payerPayerinfoEmail;
	private String payerPayerinfoName;
	private String transactionsResponse;
	
	
	public PayPalPaymentResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getParentPaymentId() {
		return parentPaymentId;
	}



	public void setParentPaymentId(String parentPaymentId) {
		this.parentPaymentId = parentPaymentId;
	}



	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getTransactionsRelatedresourcesSaleState() {
		return transactionsRelatedresourcesSaleState;
	}

	public void setTransactionsRelatedresourcesSaleState(String transactionsRelatedresourcesSaleState) {
		this.transactionsRelatedresourcesSaleState = transactionsRelatedresourcesSaleState;
	}

	public String getTransactionsRelatedresourcesSaleUpdatetime() {
		return transactionsRelatedresourcesSaleUpdatetime;
	}

	public void setTransactionsRelatedresourcesSaleUpdatetime(String transactionsRelatedresourcesSaleUpdatetime) {
		this.transactionsRelatedresourcesSaleUpdatetime = transactionsRelatedresourcesSaleUpdatetime;
	}

	public String getTransactionsRelatedresourcesSaleCreatetime() {
		return transactionsRelatedresourcesSaleCreatetime;
	}

	public void setTransactionsRelatedresourcesSaleCreatetime(String transactionsRelatedresourcesSaleCreatetime) {
		this.transactionsRelatedresourcesSaleCreatetime = transactionsRelatedresourcesSaleCreatetime;
	}

	
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPayerPayerinfoEmail() {
		return payerPayerinfoEmail;
	}

	public void setPayerPayerinfoEmail(String payerPayerinfoEmail) {
		this.payerPayerinfoEmail = payerPayerinfoEmail;
	}

	public String getPayerPayerinfoName() {
		return payerPayerinfoName;
	}

	public void setPayerPayerinfoName(String payerPayerinfoName) {
		this.payerPayerinfoName = payerPayerinfoName;
	}
	
	

	public String getTransactionsResponse() {
		return transactionsResponse;
	}



	public void setTransactionsResponse(String transactionsResponse) {
		this.transactionsResponse = transactionsResponse;
	}



	@Override
	public String toString() {
		return "PayPalPaymentResponseDTO [parentPaymentId=" + parentPaymentId + ", paymentAmount=" + paymentAmount
				+ ", paymentCurrency=" + paymentCurrency + ", transactionsRelatedresourcesSaleState="
				+ transactionsRelatedresourcesSaleState + ", transactionsRelatedresourcesSaleUpdatetime="
				+ transactionsRelatedresourcesSaleUpdatetime + ", transactionsRelatedresourcesSaleCreatetime="
				+ transactionsRelatedresourcesSaleCreatetime + ", userid=" + userid + ", payerPayerinfoEmail="
				+ payerPayerinfoEmail + ", payerPayerinfoName=" + payerPayerinfoName + ", transactionsResponse="
				+ transactionsResponse + "]";
	}




	

	
		
	
}
