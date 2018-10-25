/**
 * 
 */
package com.bbdrools.model;

import com.bbdrools.factory.FactoryProducer;
import com.bbdrools.factory.JAbstractFactory;
import com.bbdrools.service.IBreakupCompute;
import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.util.JavelinConstants;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author ayazpasha
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignDiscount {
	
	private long campaignId;
	private double mrp;
	private double sp;
	private double rsp;
	private double targetPrice;
	private String discountType;
	private double discountValue;
	private String discountTier;
	private double savingAmount;
	private double savingPercent;
	private double redemptionSavingAmount;
	private double redemptionSavingPercent;
	private double vendorBreakup;
	private double categoryBreakup;
	private double marketingBreakup;
	private double vendorBreakupAmount;
	private double redemptionVendorBreakupAmount;
	private long redemptionCampaignLimit;
	private long redemptionMemberLimit;
	private long redemptionOrderLimit;
	private long liveCampaignRedemptionCount;
	private long liveMemberRedemptionCount;
	private long availableRedemptionQuantity;
	private long remainingMemberLimit;
	private long remainingCampaignLimit;
	private boolean redemption;
	private boolean valid;
	private String validationMessage;
	
	@JsonCreator
	public CampaignDiscount() {}
	
	public CampaignDiscount(long campaignId, double mrp, double targetPrice,
			String discountType, double discountValue, String discountTier, double vendorBreakup,
			int redemptionCampaignLimit, int redemptionMemberLimit, int redemptionOrderLimit,
			int liveCampaignRedemptionCount, int liveMemberRedemptionCount) {
		
		setCampaignId(campaignId);
		setMrp(mrp);
		setTargetPrice(targetPrice);
		setDiscountType(discountType);
		setDiscountValue(discountValue);
		setDiscountTier(discountTier);
		setVendorBreakup(vendorBreakup);
		setRedemptionCampaignLimit(redemptionCampaignLimit);
		setRedemptionMemberLimit(redemptionMemberLimit);
		setRedemptionOrderLimit(redemptionOrderLimit);
		setLiveCampaignRedemptionCount(liveCampaignRedemptionCount);
		setLiveMemberRedemptionCount(liveMemberRedemptionCount);
		
		/**
		 * compute intuitive values at the time of creation
		 * this will be used for evaluation later
		 * 
		 */
		setSp(computeSP());
		setRsp(computeRSP());
		setSavingAmount(computeSavingAmount());
		setSavingPercent(computeSavingPercent());
		setVendorBreakupAmount(computeVendorBreakupAmount());
		setRedemption(computeRedemption());
		setRemainingMemberLimit(computeRemainingCampaignLimit());
		setRemainingCampaignLimit(computeRemainingMemberLimit());
		setAvailableRedemptionQuantity(computeAvailableRedemptionQuantity());
	}

	@JsonProperty("campaign_id")
	public long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
	}

	@JsonProperty("mrp")
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
		
		setValidity();
	}
	
	@JsonProperty("target_price")
	public double getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(double targetPrice) {
		this.targetPrice = targetPrice;
	}

	@JsonProperty("discount_type")
	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	@JsonProperty("discount_value")
	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	@JsonProperty("discount_category")
	public String getDiscountTier() {
		return discountTier;
	}

	public void setDiscountTier(String discountTier) {
		this.discountTier = discountTier;
	}
	
	public double getSavingAmount() {
		return savingAmount;
	}

	public void setSavingAmount(double savingAmount) {
		this.savingAmount = savingAmount;
	}

	public double getSavingPercent() {
		return savingPercent;
	}

	public void setSavingPercent(double savingPercent) {
		this.savingPercent = savingPercent;
	}

	public double getRedemptionSavingAmount() {
		return redemptionSavingAmount;
	}

	public void setRedemptionSavingAmount(double redemptionSavingAmount) {
		this.redemptionSavingAmount = redemptionSavingAmount;
	}

	public double getRedemptionSavingPercent() {
		return redemptionSavingPercent;
	}

	public void setRedemptionSavingPercent(double redemptionSavingPercent) {
		this.redemptionSavingPercent = redemptionSavingPercent;
	}

	@JsonProperty("vendor_funding")
	public double getVendorBreakup() {
		return vendorBreakup;
	}

	public void setVendorBreakup(double vendorBreakup) {
		this.vendorBreakup = vendorBreakup;
	}

	@JsonProperty("category_funding")
	public double getCategoryBreakup() {
		return categoryBreakup;
	}

	public void setCategoryBreakup(double categoryBreakup) {
		this.categoryBreakup = categoryBreakup;
	}

	@JsonProperty("marketing_funding")
	public double getMarketingBreakup() {
		return marketingBreakup;
	}

	public void setMarketingBreakup(double marketingBreakup) {
		this.marketingBreakup = marketingBreakup;
	}

	@JsonProperty("campaign_redemption")
	public long getRedemptionCampaignLimit() {
		return redemptionCampaignLimit;
	}

	public void setRedemptionCampaignLimit(long redemptionCampaignLimit) {
		this.redemptionCampaignLimit = redemptionCampaignLimit;
	}

	@JsonProperty("member_redemption")
	public long getRedemptionMemberLimit() {
		return redemptionMemberLimit;
	}

	public void setRedemptionMemberLimit(long redemptionMemberLimit) {
		this.redemptionMemberLimit = redemptionMemberLimit;
	}

	@JsonProperty("order_redemption")
	public long getRedemptionOrderLimit() {
		return redemptionOrderLimit;
	}

	public void setRedemptionOrderLimit(long redemptionOrderLimit) {
		this.redemptionOrderLimit = redemptionOrderLimit;
	}

	@JsonProperty("live_campaign_redemption")
	public long getLiveCampaignRedemptionCount() {
		return liveCampaignRedemptionCount;
	}

	public void setLiveCampaignRedemptionCount(long liveCampaignRedemptionCount) {
		this.liveCampaignRedemptionCount = liveCampaignRedemptionCount;
	}

	@JsonProperty("live_member_redemption")
	public long getLiveMemberRedemptionCount() {
		return liveMemberRedemptionCount;
	}

	public void setLiveMemberRedemptionCount(long liveMemberRedemptionCount) {
		this.liveMemberRedemptionCount = liveMemberRedemptionCount;
	}

	public long getAvailableRedemptionQuantity() {
		return availableRedemptionQuantity;
	}

	public void setAvailableRedemptionQuantity(long availableRedemptionQuantity) {
		this.availableRedemptionQuantity = availableRedemptionQuantity;
	}
	
	public long getRemainingMemberLimit() {
		return remainingMemberLimit;
	}

	public long getRemainingCampaignLimit() {
		return remainingCampaignLimit;
	}
	
	public void setRemainingMemberLimit(long remainingMemberLimit) {
		this.remainingMemberLimit = remainingMemberLimit;
	}

	public void setRemainingCampaignLimit(long remainingCampaignLimit) {
		this.remainingCampaignLimit = remainingCampaignLimit;
	}
	
	public boolean hasRedemption() {
		return redemption;
	}

	public void setRedemption(boolean redemption) {
		this.redemption = redemption;
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
	
	public double getRsp() {
		return rsp;
	}

	public void setRsp(double rsp) {
		this.rsp = rsp;
	}
	
	public double getVendorBreakupAmount() {
		return vendorBreakupAmount;
	}

	public void setVendorBreakupAmount(double vendorBreakupAmount) {
		this.vendorBreakupAmount = vendorBreakupAmount;
	}
	
	public double getRedemptionVendorBreakupAmount() {
		return redemptionVendorBreakupAmount;
	}

	public void setRedemptionVendorBreakupAmount(double redemptionVendorBreakupAmount) {
		this.redemptionVendorBreakupAmount = redemptionVendorBreakupAmount;
	}

	/**
	 * 
	 * @return
	 */
	private double computeSP() {

		JAbstractFactory discountComputeFactory = 
				FactoryProducer.getFactory(JavelinConstants.DISCOUNT_COMPUTE);
		IDiscountCompute discountCompute = 
				discountComputeFactory.getDiscountCompute(getDiscountTier());
		
		return discountCompute.compute(getMrp(), getTargetPrice(), getDiscountType(), getDiscountValue());
	}
	
	/**
	 * 
	 * @return
	 */
	private double computeRSP() {

		JAbstractFactory discountComputeFactory = 
				FactoryProducer.getFactory(JavelinConstants.DISCOUNT_COMPUTE);
		IDiscountCompute discountCompute = 
				discountComputeFactory.getDiscountCompute(getDiscountTier());
		
		return discountCompute.compute(getMrp(), getTargetPrice(), getDiscountType(), getDiscountValue());
	}
	
	/**
	 * 
	 * @return
	 */
	public double computeVendorBreakupAmount() {

		JAbstractFactory breakupComputeFactory = 
				FactoryProducer.getFactory(JavelinConstants.BREAKUP_COMPUTE);
		IBreakupCompute breakupCompute = 
				breakupComputeFactory.getBreakupCompute(getDiscountType());
		
		return breakupCompute.compute(getVendorBreakup(), getSavingAmount());
	}
	
	/**
	 * 
	 * @return
	 */
	public double computeRedemptionVendorBreakupAmount() {

		JAbstractFactory breakupComputeFactory = 
				FactoryProducer.getFactory(JavelinConstants.BREAKUP_COMPUTE);
		IBreakupCompute breakupCompute = 
				breakupComputeFactory.getBreakupCompute(getDiscountType());
		
		return breakupCompute.compute(getVendorBreakup(), getSavingAmount());
	}
	
	/**
	 * 
	 * @return
	 */
	public double computeSavingPercent() {

		return (getSavingAmount() * 100) / getMrp();
	}
	
	/**
	 * 
	 * @return
	 */
	public double computeSavingAmount() {

		return (getMrp() - getSp());
	}

	/**
	 * 
	 * @return
	 */
	public double computeRedemptionSavingPercent() {

		return (getRedemptionSavingAmount() * 100) / getMrp();
	}
	
	/**
	 * 
	 * @return
	 */
	public double computeRedemptionSavingAmount() {

		return (getMrp() - getRsp());
	}
	
	/**
	 * 
	 * @return
	 */
	private long computeAvailableRedemptionQuantity() {
		
		if(!hasRedemption()) return JavelinConstants.UNLIMITED_REDEMPTION; 
		else {
		
			return Math.min(getRedemptionOrderLimit(), 
					Math.min(getRemainingMemberLimit(), getRemainingCampaignLimit()));
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	private long computeRemainingMemberLimit() {
		
		long remainMemberLimit = getRedemptionMemberLimit() - 
				getLiveMemberRedemptionCount();
		
		return (remainMemberLimit < 0) ? 0 : remainMemberLimit;
	}
	
	/**
	 * 
	 * @return
	 */
	private long computeRemainingCampaignLimit() {
		
		long remainCampaignLimit = getRedemptionCampaignLimit() - 
				getLiveCampaignRedemptionCount();
		
		return (remainCampaignLimit < 0) ? 0 : remainCampaignLimit;
	}
	
	/**
	 * 
	 * @return
	 */
	public double computeSP(double basePrice) {

		JAbstractFactory discountComputeFactory = 
				FactoryProducer.getFactory(JavelinConstants.DISCOUNT_COMPUTE);
		IDiscountCompute discountCompute = 
				discountComputeFactory.getDiscountCompute(getDiscountTier());
		
		/**
		 * 
		 * SP will be computed on MRP if there are no discounts
		 */
		basePrice = basePrice == 0 ? getMrp() : basePrice;
		
		return discountCompute.compute(basePrice, getTargetPrice(), getDiscountType(), getDiscountValue());
	}
	
	/**
	 * 
	 * @return
	 */
	public double computeRSP(double basePrice) {

		JAbstractFactory discountComputeFactory = 
				FactoryProducer.getFactory(JavelinConstants.DISCOUNT_COMPUTE);
		IDiscountCompute discountCompute = 
				discountComputeFactory.getDiscountCompute(getDiscountTier());
		
		/**
		 * 
		 * SP will be computed on MRP if there are no discounts
		 */
		basePrice = basePrice == 0 ? getMrp() : basePrice;
		
		return discountCompute.compute(basePrice, getTargetPrice(), getDiscountType(), getDiscountValue());
	}

	/**
	 * 
	 * @return
	 */
	private boolean computeRedemption() {

		return (getRedemptionCampaignLimit() == JavelinConstants.UNLIMITED_REDEMPTION);
	}
	
	/**
	 * set validity by checking SP
	 */
	private void setValidity() {

		if(getSp() <= 0) { setValid(false); setValidationMessage("SP less than or equal to 0");}
		else if(getSp() >= getMrp()) { setValid(false); setValidationMessage("SP greater or equal to MRP");}
		else setValid(true);
	}
	
	/**
	 * populate initial values 
	 */
	public void populate() {
		
		/**
		 * compute intuitive values at the time of creation
		 * this will be used for evaluation later
		 * 
		 */
		setSp(computeSP());
		setRsp(computeRSP());
		setSavingAmount(computeSavingAmount());
		setSavingPercent(computeSavingPercent());
		setVendorBreakupAmount(computeVendorBreakupAmount());
		setRedemption(computeRedemption());
		setRemainingMemberLimit(computeRemainingCampaignLimit());
		setRemainingCampaignLimit(computeRemainingMemberLimit());
		setAvailableRedemptionQuantity(computeAvailableRedemptionQuantity());
	}

	
	@Override
	public String toString() {
	    
		return "{\"campaign_id\": \""+getCampaignId()+"\","
				+ "\"mrp\": \""+getMrp()+"\","
				+ "\"sp\": \""+getSp()+"\","
				+ "\"rsp\": \""+getRsp()+"\","
				+ "\"target_price\": \""+getTargetPrice()+"\","
				+ "\"discount_type\": \""+getDiscountType()+"\","
				+ "\"discount_value\": \""+getDiscountValue()+"\","
				+ "\"discount_tier\": \""+getDiscountTier()+"\","
				+ "\"saving_amount\": \""+getSavingAmount()+"\","
				+ "\"saving_percent\": \""+getSavingPercent()+"\","
				+ "\"redemption_saving_amount\": \""+getRedemptionSavingAmount()+"\","
				+ "\"redemption_saving_percent\": \""+getRedemptionSavingPercent()+"\","
				+ "\"vendor_breakup\": \""+getVendorBreakup()+"\","
				+ "\"marketing_breakup\": \""+getMarketingBreakup()+"\","
				+ "\"category_breakup\": \""+getCategoryBreakup()+"\","
				+ "\"redemption_order_limit\": \""+getRedemptionOrderLimit()+"\","
				+ "\"redemption_member_limit\": \""+getRedemptionMemberLimit()+"\","
				+ "\"redemption_campaign_limit\": \""+getRedemptionCampaignLimit()+"\","
				+ "\"available_redemption_quantity\": \""+getAvailableRedemptionQuantity()+"\","
				+ "\"live_campaign_redemption_count\": \""+getLiveCampaignRedemptionCount()+"\","
				+ "\"live_member_redemption_count\": \""+getLiveMemberRedemptionCount()+"\","
				+ "\"remaining_campaign_limit\": \""+getRemainingCampaignLimit()+"\","
				+ "\"remaining_member_limit\": \""+getRemainingMemberLimit()+"\","
				+ "\"valid\": \""+isValid()+"\","
				+ "\"validation_message\": \""+getValidationMessage()+"\""
				+ "}";
		
	}

}
