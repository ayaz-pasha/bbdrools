/**
 * 
 */
package com.bbdrools.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bbdrools.model.ProductDiscount;
import com.bbdrools.service.IProductDiscountService;
import com.bbdrools.util.KnowledgeSessionHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ayazpasha
 *
 */
@Slf4j
public class ProductDiscountServiceImpl implements IProductDiscountService {

	/**
	 * 
	 */
	public ProductDiscount validate(ProductDiscount productDiscount) {

		try {

			KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
            KieSession kSession = KnowledgeSessionHelper.
            		getStatefulKnowledgeSessionWithCallback(kContainer, "discount-ksession-rules");
            
            // go !
            
        	kSession.insert(productDiscount);
            
            kSession.fireAllRules();
            kSession.dispose();
            kSession.destroy();
            
            log.info("validation complete");
    		
		} catch (Exception e) {
			
			log.error("error while validate - {}", e.getMessage());
        }
		
		return productDiscount;
	}

}
