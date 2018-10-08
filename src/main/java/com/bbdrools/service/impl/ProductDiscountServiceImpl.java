/**
 * 
 */
package com.bbdrools.service.impl;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bbdrools.model.ProductDiscount;
import com.bbdrools.service.IProductDiscountService;
import com.bbdrools.util.KnowledgeSessionHelper;

/**
 * @author ayazpasha
 *
 */
public class ProductDiscountServiceImpl implements IProductDiscountService {

	/**
	 * 
	 */
	public List<ProductDiscount> validate(List<ProductDiscount> productDiscounts) {

		try {

			KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
            KieSession kSession = KnowledgeSessionHelper.
            		getStatefulKnowledgeSessionWithCallback(kContainer, "discount-ksession-rules");
            
            // go !
            
            for(ProductDiscount productDiscount : productDiscounts) {
            	kSession.insert(productDiscount);
            }
            
            kSession.fireAllRules();
            kSession.dispose();
            kSession.destroy();
    		
		} catch (Throwable t) {
            t.printStackTrace();
        }
		
		return productDiscounts;
	}

}
