package com.bbdrools.model;

public class ValidDiscount {
	
	private Discount discount;
	
	public ValidDiscount(Discount discount) {
		setDiscount(discount);
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
}
