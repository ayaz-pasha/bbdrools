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

import lombok.extern.slf4j.Slf4j;

/**
 * @author ayazpasha
 *
 */
@Slf4j
public class JavelinPricingServiceImpl implements IJavelinPricingService {

	/**
	 * 
	 */
	public JavelinPrice compute(List<CampaignDiscount> campaignDiscounts) {
		
		JavelinPrice javelinPrice = new JavelinPrice();
		
		KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.
        		getStatefulKnowledgeSessionWithCallback(kContainer, "pricing-ksession-rules");
        
		try {

			// go !
            
            kSession.setGlobal("javelinPrice", javelinPrice);
            kSession.setGlobal("redemptionLessCampaigns", new HashSet<Long>());
            kSession.setGlobal("campaigns", new HashSet<Long>());
            kSession.setGlobal("redemptionLessComboCampaigns", new HashSet<Long>());
            kSession.setGlobal("comboCampaigns", new HashSet<Long>());
            kSession.setGlobal("netAvailableRedemptionQuantity", 999999l);
            
            for(CampaignDiscount campaignDiscount : campaignDiscounts) {
            	campaignDiscount.populate();
            	kSession.insert(campaignDiscount);
            }
			
            // fire !
            
            kSession.fireAllRules();
            
            javelinPrice.setCampaigns((Set<Long>) kSession.getGlobal("campaigns"));
            javelinPrice.setRedemptionLessCampaigns((Set<Long>) kSession.getGlobal("redemptionLessCampaigns"));
            
            javelinPrice.setComboCampaigns((Set<Long>) kSession.getGlobal("comboCampaigns"));
            javelinPrice.setRedemptionLessComboCampaigns((Set<Long>) kSession.getGlobal("redemptionLessComboCampaigns"));
            javelinPrice.setDiscounts(campaignDiscounts);
            
            log.info("best discount - "+ javelinPrice);
            
            // destroy !
            
            kSession.dispose();
            kSession.destroy();
            
		} catch (Exception e) {
            log.error("error while running rules - {}", e.getMessage());
            
            // destroy !
            
            kSession.dispose();
            kSession.destroy();
        }
		
		return javelinPrice;
	}

}
