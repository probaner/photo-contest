package com.photo.contest.dto;

public class PaystatusGraphDTO {
	
	private String country;
	private Integer paid;
	private Integer unpaid;
	
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPaid() {
		return paid;
	}
	public void setPaid(Integer paid) {
		this.paid = paid;
	}
	public Integer getUnpaid() {
		return unpaid;
	}
	public void setUnpaid(Integer unpaid) {
		this.unpaid = unpaid;
	}
	@Override
	public String toString() {
		return "PaystatusGraphDTO [country=" + country + ", paid=" + paid + ", unpaid=" + unpaid + "]";
	}
	
		
}
