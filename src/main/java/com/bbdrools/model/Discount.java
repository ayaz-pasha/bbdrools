package com.bbdrools.model;

public class Discount {//implements Comparable<Discount> {
	
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

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	
	@Override
	public String toString() {
	    StringBuffer buff = new StringBuffer();
	    buff.append("-----Discount-----)\n");
	    buff.append("ID=" + getId() + "\n");
	    buff.append("Category=" + getCategory() + "\n");
	    buff.append("DiscountPrice=" + getDiscountPrice() + "\n");
	    buff.append("CampaignID=" + getCampaignId() + "\n");
	    buff.append("-----Discount end-)");
	    return buff.toString();
	}
	
	/*public int compareTo(Discount another) {
		if (this.getDiscountPrice() >= another.getDiscountPrice()) {
            return -1;
        } else {
            return 1;
        }
	}*/

}
