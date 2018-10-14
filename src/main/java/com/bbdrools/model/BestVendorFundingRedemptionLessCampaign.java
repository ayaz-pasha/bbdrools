/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
public class BestVendorFundingRedemptionLessCampaign {
	
	private BestDiscountRedemptionLessCampaign campaignDiscount;
	
	public BestVendorFundingRedemptionLessCampaign(BestDiscountRedemptionLessCampaign campaignDiscount) {

		setCampaignDiscount(campaignDiscount);
	}

	public BestDiscountRedemptionLessCampaign getCampaignDiscount() {
		return campaignDiscount;
	}

	public void setCampaignDiscount(BestDiscountRedemptionLessCampaign campaignDiscount) {
		this.campaignDiscount = campaignDiscount;
	}
	
}
