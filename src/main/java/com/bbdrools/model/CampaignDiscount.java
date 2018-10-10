/**
 * 
 */
package com.bbdrools.model;

import com.bbdrools.factory.FactoryProducer;
import com.bbdrools.factory.JAbstractFactory;
import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.util.JavelinConstants;

/**
 * @author ayazpasha
 *
 */
public class CampaignDiscount {
	
	private long campaignId;
	private double mrp;
	private double sp;
	private double rsp;
	private double targetPrice;
	private String discountType;
	private double discountValue;
	private String discountTier;
	private double vendorBreakup;
	private double categoryBreakup;
	private double marketingBreakup;
	private long redemptionCampaignLimit;
	private long redemptionMemberLimit;
	private long redemptionOrderLimit;
	private long liveCampaignRedemptionCount;
	private long liveMemberRedemptionCount;
	private long availableRedemptionQuantity;
	/*private double bestSP;
	private double redemptionSP;
	private long bestSPQuantity;
	private long redemptionSPQuantity;*/
	private long remainingMemberLimit;
	private long remainingCampaignLimit;
	private boolean redemption;
	private boolean valid;
	private String validationMessage;
	
	public CampaignDiscount() {}
	
	public CampaignDiscount(long campaignId, double mrp, double targetPrice,
			String discountType, double discountValue, String discountTier,
			int redemptionCampaignLimit, int redemptionMemberLimit, int redemptionOrderLimit,
			int liveCampaignRedemptionCount, int liveMemberRedemptionCount) {
		
		setCampaignId(campaignId);
		setMrp(mrp);
		setTargetPrice(targetPrice);
		setDiscountType(discountType);
		setDiscountValue(discountValue);
		setDiscountTier(discountTier);
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
		setRedemption(computeRedemption());
		setRemainingMemberLimit(computeRemainingCampaignLimit());
		setRemainingCampaignLimit(computeRemainingMemberLimit());
		setAvailableRedemptionQuantity(computeAvailableRedemptionQuantity());
	}

	public long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
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
	
	public double getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(double targetPrice) {
		this.targetPrice = targetPrice;
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

	public String getDiscountTier() {
		return discountTier;
	}

	public void setDiscountTier(String discountTier) {
		this.discountTier = discountTier;
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

	public long getLiveCampaignRedemptionCount() {
		return liveCampaignRedemptionCount;
	}

	public void setLiveCampaignRedemptionCount(long liveCampaignRedemptionCount) {
		this.liveCampaignRedemptionCount = liveCampaignRedemptionCount;
	}

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

	/*public double getBestSP() {
		return bestSP;
	}

	public void setBestSP(double bestSP) {
		this.bestSP = bestSP;
	}

	public double getRedemptionSP() {
		return redemptionSP;
	}

	public void setRedemptionSP(double redemptionSP) {
		this.redemptionSP = redemptionSP;
	}

	public long getBestSPQuantity() {
		return bestSPQuantity;
	}

	public void setBestSPQuantity(long bestSPQuantity) {
		this.bestSPQuantity = bestSPQuantity;
	}

	public long getRedemptionSPQuantity() {
		return redemptionSPQuantity;
	}

	public void setRedemptionSPQuantity(long redemptionSPQuantity) {
		this.redemptionSPQuantity = redemptionSPQuantity;
	}*/
	
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
	private long computeAvailableRedemptionQuantity() {
		
		if(!hasRedemption()) return JavelinConstants.UNLIMITED_REDEMPTION; 
		else {
		
			long availableRedemptionQuantity = Math.min(getRedemptionOrderLimit(), 
					Math.min(getRemainingMemberLimit(), getRemainingCampaignLimit()));
			
			return availableRedemptionQuantity;
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	private long computeRemainingMemberLimit() {
		
		long remainingMemberLimit = getRedemptionMemberLimit() - 
				getLiveMemberRedemptionCount();
		
		return (remainingMemberLimit < 0) ? 0 : remainingMemberLimit;
	}
	
	/**
	 * 
	 * @return
	 */
	private long computeRemainingCampaignLimit() {
		
		long remainingCampaignLimit = getRedemptionCampaignLimit() - 
				getLiveCampaignRedemptionCount();
		
		return (remainingCampaignLimit < 0) ? 0 : remainingCampaignLimit;
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

		if(getRedemptionCampaignLimit() == JavelinConstants.UNLIMITED_REDEMPTION) {
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	public void populate() {
		
		/**
		 * compute intuitive values at the time of creation
		 * this will be used for evaluation later
		 * 
		 */
		setSp(computeSP());
		setRsp(computeRSP());
		setRedemption(computeRedemption());
		setRemainingMemberLimit(computeRemainingCampaignLimit());
		setRemainingCampaignLimit(computeRemainingMemberLimit());
		setAvailableRedemptionQuantity(computeAvailableRedemptionQuantity());
	}

	@Override
	public String toString() {
	    StringBuffer buff = new StringBuffer();
	    buff.append("-----CampaignDiscount-----)\n");
	    buff.append("CampaignID=" + getCampaignId() + "\n");
	    buff.append("MRP=" + getMrp() + "\n");
	    buff.append("SP=" + getSp() + "\n");
	    buff.append("RSP=" + getRsp() + "\n");
	    buff.append("TargetPrice=" + getTargetPrice() + "\n");
	    buff.append("DiscountType=" + getDiscountType() + "\n");
	    buff.append("DiscountValue=" + getDiscountValue() + "\n");
	    buff.append("DiscountTier=" + getDiscountTier() + "\n");
	    buff.append("VendorBreakup=" + getVendorBreakup() + "\n");
	    buff.append("MarketingBreakup=" + getMarketingBreakup() + "\n");
	    buff.append("CategoryBreakup=" + getCategoryBreakup() + "\n");
	    buff.append("RedemptionOrderLimit=" + getRedemptionOrderLimit() + "\n");
	    buff.append("RedemptionMemberLimit=" + getRedemptionMemberLimit() + "\n");
	    buff.append("RedemptionCampaignLimit=" + getRedemptionCampaignLimit() + "\n");
	    buff.append("AvailableRedemptionQuanity=" + getAvailableRedemptionQuantity() + "\n");
	    buff.append("LiveCampaignRedemptionCount=" + getLiveCampaignRedemptionCount() + "\n");
	    buff.append("LiveMemberRedemptionCount=" + getLiveMemberRedemptionCount() + "\n");
	    buff.append("RemainingCampaignLimit=" + getRemainingCampaignLimit() + "\n");
	    buff.append("RemainingMemberLimit=" + getRemainingMemberLimit() + "\n");
	    buff.append("Valid=" + isValid() + "\n");
	    buff.append("ValidationMessage=" + getValidationMessage() + "\n");
	    buff.append("-----CampaignDiscount end-)");
	    return buff.toString();
	}

}
