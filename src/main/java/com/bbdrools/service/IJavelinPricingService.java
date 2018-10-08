/**
 * 
 */
package com.bbdrools.service;

import com.bbdrools.model.CampaignDiscount;

/**
 * @author ayazpasha
 *
 */
public interface IJavelinPricingService {
	
	public CampaignDiscount compute(CampaignDiscount campaignDiscount);

}
