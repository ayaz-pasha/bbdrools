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
public class BestDiscountCampaign {
	
	private CampaignDiscount campaignDiscount;
	
	public BestDiscountCampaign(CampaignDiscount campaignDiscount) {

		setCampaignDiscount(campaignDiscount);
	}
	
}
