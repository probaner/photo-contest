package com.photo.contest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonDeserialize(using = PayPalPaymentResponseDeserializer.class)
public class PayPalPaymentResponseDTO {
	
	@JsonProperty("parent_payment")
	private String parent_payment;
	/*private String payer_info_payer_id;
	private String payer_info_email;
	private String payer_info_country_code;
	private String transactions_amount_total;
	private String transactions_amount_currency;
	private String transactions_related_resources_state;*/
	
	
	
	public PayPalPaymentResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PayPalPaymentResponseDTO(String parent_payment) {
		super();
		this.parent_payment = parent_payment;
		
	}



	public String getParent_payment() {
		return parent_payment;
	}



	public void setParent_payment(String parent_payment) {
		this.parent_payment = parent_payment;
	}



	@Override
	public String toString() {
		return "PayPalPaymentResponseDTO [parent_payment=" + parent_payment + "]";
	}



	

}
