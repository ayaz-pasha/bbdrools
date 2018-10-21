/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
public class BestVendorFundingRedemptionLessCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestVendorFundingRedemptionLessCampaign(BestDiscountRedemptionLessCampaign campaignDiscount) {

		setCampaignDiscount(campaignDiscount.getCampaignDiscount());
	}

	public CampaignDiscount getCampaignDiscount() {
		return campaignDiscount;
	}

	public void setCampaignDiscount(CampaignDiscount campaignDiscount) {
		this.campaignDiscount = campaignDiscount;
	}
	
}
