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
public class BestVendorFundingCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestVendorFundingCampaign(BestDiscountCampaign campaignDiscount) {

		setCampaignDiscount(campaignDiscount.getCampaignDiscount());
	}
	
}
