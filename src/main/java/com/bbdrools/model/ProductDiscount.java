/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
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

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getSp() {
		return sp;
	}

	public void setSp(double sp) {
		this.sp = sp;
	}
	
	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public String getDiscountCategory() {
		return discountCategory;
	}

	public void setDiscountCategory(String discountCategory) {
		this.discountCategory = discountCategory;
	}

	public double getVendorBreakup() {
		return vendorBreakup;
	}

	public void setVendorBreakup(double vendorBreakup) {
		this.vendorBreakup = vendorBreakup;
	}

	public double getCategoryBreakup() {
		return categoryBreakup;
	}

	public void setCategoryBreakup(double categoryBreakup) {
		this.categoryBreakup = categoryBreakup;
	}

	public double getMarketingBreakup() {
		return marketingBreakup;
	}

	public void setMarketingBreakup(double marketingBreakup) {
		this.marketingBreakup = marketingBreakup;
	}

	public long getRedemptionCampaignLimit() {
		return redemptionCampaignLimit;
	}

	public void setRedemptionCampaignLimit(long redemptionCampaignLimit) {
		this.redemptionCampaignLimit = redemptionCampaignLimit;
	}

	public long getRedemptionMemberLimit() {
		return redemptionMemberLimit;
	}

	public void setRedemptionMemberLimit(long redemptionMemberLimit) {
		this.redemptionMemberLimit = redemptionMemberLimit;
	}

	public long getRedemptionOrderLimit() {
		return redemptionOrderLimit;
	}

	public void setRedemptionOrderLimit(long redemptionOrderLimit) {
		this.redemptionOrderLimit = redemptionOrderLimit;
	}

	public double getMinimumThresholdPrice() {
		return minimumThresholdPrice;
	}

	public void setMinimumThresholdPrice(double minimumThresholdPrice) {
		this.minimumThresholdPrice = minimumThresholdPrice;
	}
	
	public double getThresholdMargin() {
		return thresholdMargin;
	}

	public void setThresholdMargin(double thresholdMargin) {
		this.thresholdMargin = thresholdMargin;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}

	@Override
	public String toString() {
	    StringBuffer buff = new StringBuffer();
	    buff.append("-----ProductDiscount-----)\n");
	    buff.append("MRP=" + getMrp() + "\n");
	    buff.append("SP=" + getSp() + "\n");
	    buff.append("DiscountPrice=" + getDiscountPrice() + "\n");
	    buff.append("DiscountType=" + getDiscountType() + "\n");
	    buff.append("DiscountValue=" + getDiscountValue() + "\n");
	    buff.append("DiscountCategory=" + getDiscountCategory() + "\n");
	    buff.append("VendorBreakup=" + getVendorBreakup() + "\n");
	    buff.append("MarketingBreakup=" + getMarketingBreakup() + "\n");
	    buff.append("CategoryBreakup=" + getCategoryBreakup() + "\n");
	    buff.append("RedemptionOrderLimit=" + getRedemptionOrderLimit() + "\n");
	    buff.append("RedemptionMemberLimit=" + getRedemptionMemberLimit() + "\n");
	    buff.append("RedemptionCampaignLimit=" + getRedemptionCampaignLimit() + "\n");
	    buff.append("MinimumThresholdPrice=" + getMinimumThresholdPrice() + "\n");
	    buff.append("ThresholdMargin=" + getThresholdMargin() + "\n");
	    buff.append("-----ProductDiscount end-)");
	    return buff.toString();
	}

}
