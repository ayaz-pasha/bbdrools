/**
 * 
 */
package com.bbdrools.service;

import com.bbdrools.model.CampaignDiscount;

/**
 * @author ayazpasha
 *
 */
public interface ICampaignDiscountService {
	
	public CampaignDiscount runRules(CampaignDiscount campaignDiscount);

}
