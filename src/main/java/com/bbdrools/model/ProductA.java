package com.bbdrools.model;

import java.util.List;

public class ProductA {
	
	private double mrp;
	private List<DiscountA> discounts;
	
	public double getMrp() {
		return mrp;
	}
	
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	
	public List<DiscountA> getDiscounts() {
		return discounts;
	}
	
	public void setDiscounts(List<DiscountA> discounts) {
		this.discounts = discounts;
	}
	
}
