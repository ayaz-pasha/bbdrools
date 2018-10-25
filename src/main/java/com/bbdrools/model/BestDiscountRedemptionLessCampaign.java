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
public class BestDiscountRedemptionLessCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestDiscountRedemptionLessCampaign(CampaignDiscount campaignDiscount) {

		setCampaignDiscount(campaignDiscount);
	}
	
}
