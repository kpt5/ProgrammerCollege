package com.internousdev.template.dto;

public class MyPageDTO {

	private String itemName;
	private String totalPrice;
	private String totalCount;
	private String payment;

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getItemName() {
		return this.itemName;
	}

	public String getTotalPrice() {
		return this.totalPrice;
	}

	public String getTotalCount() {
		return this.totalCount;
	}

	public String getPayment() {
		return this.payment;
	}
}
