/**
 * 
 */
package com.bbdrools.service;

import java.util.List;

import com.bbdrools.model.CampaignDiscount;
import com.bbdrools.model.JavelinPrice;

/**
 * @author ayazpasha
 *
 */
public interface IJavelinPricingService {
	
	public JavelinPrice compute(List<CampaignDiscount> campaignDiscount);

}
