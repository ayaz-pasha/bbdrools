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
public class BestVendorFundingRedemptionLessCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestVendorFundingRedemptionLessCampaign(BestDiscountRedemptionLessCampaign campaignDiscount) {

		setCampaignDiscount(campaignDiscount.getCampaignDiscount());
	}

}
