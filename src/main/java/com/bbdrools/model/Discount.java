package com.bbdrools.model;

public class Discount implements Comparable<Discount> {
	
	private int id;
	private double discountPrice;
	private String category;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getDiscountPrice() {
		return discountPrice;
	}
	
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int compareTo(Discount another) {
		if (this.getDiscountPrice() >= another.getDiscountPrice()) {
            return -1;
        } else {
            return 1;
        }
	}

}
