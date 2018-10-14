/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
public class BestDiscountCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestDiscountCampaign(CampaignDiscount campaignDiscount) {

		setCampaignDiscount(campaignDiscount);
	}

	public CampaignDiscount getCampaignDiscount() {
		return campaignDiscount;
	}

	public void setCampaignDiscount(CampaignDiscount campaignDiscount) {
		this.campaignDiscount = campaignDiscount;
	}
	
}
