package com.bbdrools.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BestDiscount {
	
	private double discountPrice;
	private List<Long> campaigns = new ArrayList<Long>(); 
	
	@Override
	public String toString() {
	
		return "{\"discount_price\": \""+getDiscountPrice()+"\","
				+ "\"campaigns\": \""+getCampaigns()+"\""
				+ "}";
	}

}
