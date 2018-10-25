/**
 * 
 */
package com.bbdrools.model;

import lombok.Data;

/**
 * @author ayazpasha
 *
 */
@Data
public class ProductDiscount {
	
	private double mrp;
	private double sp;
	private double discountPrice;
	private String discountType;
	private double discountValue;
	private String discountCategory;
	private double vendorBreakup;
	private double categoryBreakup;
	private double marketingBreakup;
	private long redemptionCampaignLimit;
	private long redemptionMemberLimit;
	private long redemptionOrderLimit;
	private double minimumThresholdPrice;
	private double thresholdMargin;
	private boolean valid;
	private String validationMessage;
	
	public ProductDiscount() {
		setValidationMessage("");
	}

	@Override
	public String toString() {
		
		return "{\"mrp\": \""+getMrp()+"\","
				+ "\"sp\": \""+getSp()+"\","
				+ "\"discount_price\": \""+getDiscountPrice()+"\","
				+ "\"discount_type\": \""+getDiscountType()+"\","
				+ "\"discount_value\": \""+getDiscountValue()+"\","
				+ "\"discount_category\": \""+getDiscountCategory()+"\","
				+ "\"vendor_breakup\": \""+getVendorBreakup()+"\","
				+ "\"marketing_breakup\": \""+getMarketingBreakup()+"\","
				+ "\"category_breakup\": \""+getCategoryBreakup()+"\","
				+ "\"redemption_order_limit\": \""+getRedemptionOrderLimit()+"\","
				+ "\"redemption_member_limit\": \""+getRedemptionMemberLimit()+"\","
				+ "\"redemption_campaign_limit\": \""+getRedemptionCampaignLimit()+"\","
				+ "\"minimum_threshold_price\": \""+getMinimumThresholdPrice()+"\","
				+ "\"threshold_margin\": \""+getThresholdMargin()+"\","
				+ "\"valid\": \""+isValid()+"\","
				+ "\"validation_message\": \""+getValidationMessage()+"\""
				+ "}";
		
	}

}
