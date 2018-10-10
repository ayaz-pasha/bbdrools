/**
 * 
 */
package com.bbdrools.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bbdrools.model.CampaignDiscount;
import com.bbdrools.model.JavelinPrice;
import com.bbdrools.service.IJavelinPricingService;
import com.bbdrools.util.KnowledgeSessionHelper;

/**
 * @author ayazpasha
 *
 */
public class JavelinPricingServiceImpl implements IJavelinPricingService {

	/**
	 * 
	 */
	public JavelinPrice compute(List<CampaignDiscount> campaignDiscounts) {
		
		JavelinPrice javelinPrice = new JavelinPrice();
		
		try {

			KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
            KieSession kSession = KnowledgeSessionHelper.
            		getStatefulKnowledgeSessionWithCallback(kContainer, "pricing-ksession-rules");
            
            // go !
            
            kSession.setGlobal("javelinPrice", javelinPrice);
            kSession.setGlobal("redemptionLessCampaigns", new HashSet<Long>());
            kSession.setGlobal("campaigns", new HashSet<Long>());
            kSession.setGlobal("netAvailableRedemptionQuantity", 999999l);
            
            for(CampaignDiscount campaignDiscount : campaignDiscounts) {
            	campaignDiscount.populate();
            	kSession.insert(campaignDiscount);
            }
			
            // fire !
            
            kSession.fireAllRules();
            
            javelinPrice.setCampaigns((Set<Long>) kSession.getGlobal("campaigns"));
            javelinPrice.setRedemptionLessCampaigns((Set<Long>) kSession.getGlobal("redemptionLessCampaigns"));
            
            System.out.println("Best Discount final: "+ javelinPrice);
			
            
            // destroy !
            
            kSession.dispose();
            kSession.destroy();
            
		} catch (Throwable t) {
            t.printStackTrace();
        }
		
		return javelinPrice;
	}

}
