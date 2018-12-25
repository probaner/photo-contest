package com.photo.contest.dto;

//@JsonDeserialize(using = PayPalPaymentResponseDeserializer.class)
public class PayPalPaymentResponseDTO {
	
	private String parentPayment;
	/*private String payer_info_payer_id;
	private String payer_info_email;
	private String payer_info_country_code;
	private String transactions_amount_total;
	private String transactions_amount_currency;
	private String transactions_related_resources_state;*/
	
	
	
	public PayPalPaymentResponseDTO() {
		super();
	}



	public PayPalPaymentResponseDTO(String parentPayment) {
		super();
		this.parentPayment = parentPayment;
		
	}



	public String getParentPayment() {
		return parentPayment;
	}



	public void setParentPayment(String parentPayment) {
		this.parentPayment = parentPayment;
	}



	@Override
	public String toString() {
		return "PayPalPaymentResponseDTO [parentPayment=" + parentPayment + "]";
	}


}
