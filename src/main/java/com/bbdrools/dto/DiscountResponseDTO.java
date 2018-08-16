package com.bbdrools.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bbdrools.model.Discount;

public class DiscountResponseDTO {

	private String status;
	private List<Discount> validDiscounts;
	private Discount highestDiscount;
	
	public DiscountResponseDTO() { 
		this.status = "FAIL";
		this.validDiscounts = new ArrayList<Discount>();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Discount> getValidDiscounts() {
		return validDiscounts;
	}
	public void setValidDiscounts(List<Discount> discounts) {
		this.validDiscounts = discounts;
	}
	public Discount getHighestDiscount() {
		return highestDiscount;
	}
	public void setHighestDiscount(Discount discount) {
		this.highestDiscount = discount;
	}
	
	public void addDiscount(Discount discount) {
		this.validDiscounts.add(discount);
	}
	
	public void sortAndGetBestDiscount() {
		Collections.sort(this.validDiscounts);
		if(this.validDiscounts.size() > 0) { 
			setHighestDiscount(this.validDiscounts.get(0)); 
		}
	}
}
