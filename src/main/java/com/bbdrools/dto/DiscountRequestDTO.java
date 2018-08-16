package com.bbdrools.dto;

import java.util.List;

import com.bbdrools.model.Discount;
import com.bbdrools.model.Product;

public class DiscountRequestDTO {
	
	private int id;
	private Product product;
	private List<Discount> discounts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}
	
}
