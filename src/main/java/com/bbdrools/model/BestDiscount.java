package com.bbdrools.model;

import java.util.ArrayList;
import java.util.List;

public class BestDiscount {
	
	private double discountPrice;
	private List<Long> campaigns = new ArrayList<Long>(); 

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public List<Long> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<Long> campaigns) {
		this.campaigns = campaigns;
	}
	
	@Override
	public String toString() {
	    StringBuffer buff = new StringBuffer();
	    buff.append("-----BestDiscount-----)\n");
	    buff.append("DiscountPrice=" + getDiscountPrice() + "\n");
	    buff.append("Campaigns=" + getCampaigns() + "\n");
	    buff.append("-----BestDiscount end-)");
	    return buff.toString();
	}

}
