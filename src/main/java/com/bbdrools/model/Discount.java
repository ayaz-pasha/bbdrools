package com.bbdrools.model;

import lombok.Data;

@Data
public class Discount {
	
	private int id;
	private double discountPrice;
	private String category;
	private int discountPercent;
	private int campaignId;
	
	public Discount(int id, double discountPrice, String category, int discountPercent, int campaignId) {
		setId(id);
		setDiscountPrice(discountPrice);
		setCategory(category);
		setDiscountPercent(discountPercent);
		setCampaignId(campaignId);
	}

	@Override
	public String toString() {
		
		return "{\"campaign_id\": \""+getId()+"\","
				+ "\"mrp\": \""+getCategory()+"\","
				+ "\"sp\": \""+getDiscountPrice()+"\","
				+ "\"rsp\": \""+getCampaignId()+"\""
				+ "}";
	}

}
