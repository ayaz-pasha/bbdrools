/**
 * 
 */
package com.bbdrools.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bbdrools.model.CampaignDiscount;
import com.bbdrools.service.ICampaignDiscountService;
import com.bbdrools.util.KnowledgeSessionHelper;

/**
 * @author ayazpasha
 *
 */
public class CampaignDiscountServiceImpl implements ICampaignDiscountService {

	public CampaignDiscount runRules(CampaignDiscount campaignDiscount) {

		try {

			KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
            KieSession kSession = KnowledgeSessionHelper.
            		getStatefulKnowledgeSessionWithCallback(kContainer, "render-ksession-rules");
            
            // go !
            
            kSession.insert(campaignDiscount);
            
            kSession.fireAllRules();
            kSession.dispose();
            kSession.destroy();
            
            
            // computation !
            
            
            // for all valid campaign discounts
            
            // get the best regular & differential discount
            
            // compute SP
            
            // get the best addon discount on top of computed SP
            
            // compute BSP & RSP based on NARQ
            
            // return final discount with BSP & RSP with appropriate quantity
    		
		} catch (Throwable t) {
            t.printStackTrace();
        }
		
		return campaignDiscount;
	}

}
