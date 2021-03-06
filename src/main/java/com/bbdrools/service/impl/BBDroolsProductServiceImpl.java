package com.bbdrools.service.impl;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bbdrools.dto.DiscountRequestDTO;
import com.bbdrools.dto.DiscountResponseDTO;
import com.bbdrools.model.Discount;
import com.bbdrools.service.IBBDroolsProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BBDroolsProductServiceImpl implements IBBDroolsProductService {

	public DiscountResponseDTO runRules(DiscountRequestDTO request) {

		DiscountResponseDTO discountResponseDTO = new DiscountResponseDTO();
		
		try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            
            // go !
            
            for(Discount discount : request.getDiscounts()) {
            	kSession.insert(discount);
            }

            kSession.insert(request.getProduct());
            
            kSession.insert(discountResponseDTO);
            
            kSession.fireAllRules();
      
            kSession.dispose();
            kSession.destroy();
            
		} catch (Exception e) {
			
            log.error("error while running rules - {}", e.getMessage());
        }
		
		return discountResponseDTO;
	}

}
