/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
public class BestVendorFundingCampaign {
	
	private BestDiscountCampaign campaignDiscount;
	
	public BestVendorFundingCampaign(BestDiscountCampaign campaignDiscount) {

		setCampaignDiscount(campaignDiscount);
	}

	public BestDiscountCampaign getCampaignDiscount() {
		return campaignDiscount;
	}

	public void setCampaignDiscount(BestDiscountCampaign campaignDiscount) {
		this.campaignDiscount = campaignDiscount;
	}
	
}
