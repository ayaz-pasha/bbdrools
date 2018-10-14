/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
public class BestDiscountRedemptionLessCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestDiscountRedemptionLessCampaign(CampaignDiscount campaignDiscount) {

		setCampaignDiscount(campaignDiscount);
	}

	public CampaignDiscount getCampaignDiscount() {
		return campaignDiscount;
	}

	public void setCampaignDiscount(CampaignDiscount campaignDiscount) {
		this.campaignDiscount = campaignDiscount;
	}
	
}
