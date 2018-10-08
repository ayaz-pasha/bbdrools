/**
 * 
 */
package com.bbdrools.service.impl;

import java.util.ArrayList;
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
	public CampaignDiscount compute(CampaignDiscount campaignDiscount) {

		try {

			KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
            KieSession kSession = KnowledgeSessionHelper.
            		getStatefulKnowledgeSessionWithCallback(kContainer, "render-ksession-rules");
            
            // go !
            
            JavelinPrice javelinPrice = new JavelinPrice();
            kSession.setGlobal("bestDiscount", javelinPrice);
            kSession.setGlobal("campaigns", new ArrayList<Long>());
            kSession.setGlobal("netAvailableRedemptionQuantity", 9999999l);
            
            kSession.insert(campaignDiscount);
            
            // fire !
            
            kSession.fireAllRules();
            
            
            javelinPrice.setCampaigns((Set<Long>) kSession.getGlobal("campaigns"));
            System.out.println("Best Discount final: "+ javelinPrice);
			
            
            // destroy !
            
            kSession.dispose();
            kSession.destroy();
            
		} catch (Throwable t) {
            t.printStackTrace();
        }
		
		return campaignDiscount;
	}

}
