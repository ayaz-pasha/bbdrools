/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
public class BestVendorFundingCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestVendorFundingCampaign(BestDiscountCampaign campaignDiscount) {

		setCampaignDiscount(campaignDiscount.getCampaignDiscount());
	}

	public CampaignDiscount getCampaignDiscount() {
		return campaignDiscount;
	}

	public void setCampaignDiscount(CampaignDiscount campaignDiscount) {
		this.campaignDiscount = campaignDiscount;
	}
	
}
