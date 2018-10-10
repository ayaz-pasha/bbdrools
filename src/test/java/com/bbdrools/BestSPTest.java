package com.bbdrools;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.bbdrools.model.CampaignDiscount;
import com.bbdrools.model.JavelinPrice;
import com.bbdrools.util.JavelinConstants;
import com.bbdrools.util.KnowledgeSessionHelper;

public class BestSPTest {

	StatelessKieSession sessionStateless = null;
	KieSession sessionStateful = null;
	static KieContainer kieContainer;
	
	@Before
	public void setUp() {
		System.out.println("------------Before-----------");
	}

	@After
	public void tearDown() {
		System.out.println("------------After-----------");
	}
	
	@BeforeClass
	public static void beforeStart() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Test
	public void testFirstOne() {
		sessionStateful = KnowledgeSessionHelper.
				getStatefulKnowledgeSession(kieContainer, 
						"pricing-ksession-rules");		

		sessionStateful.addEventListener(new RuleRuntimeEventListener() {
			
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object updated "
						+ event.getObject().toString());
			}
			
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted "
						+ event.getObject().toString());
			}
			
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object retracted "
						+ event.getOldObject().toString());
			}
		});
		
		
		try {
            
            // go !
			
			JavelinPrice javelinPrice = new JavelinPrice();
			sessionStateful.setGlobal("javelinPrice", javelinPrice);
			sessionStateful.setGlobal("redemptionLessCampaigns", new HashSet<Long>());
			sessionStateful.setGlobal("campaigns", new HashSet<Long>());
			sessionStateful.setGlobal("netAvailableRedemptionQuantity", 999999l);
			
			CampaignDiscount discount1 = new CampaignDiscount(1l, 100.0, 0.0, JavelinConstants.FLAT, 10, JavelinConstants.REGULAR, 9999999, 10, 2, 990, 10);
			CampaignDiscount discount2 = new CampaignDiscount(2l, 100.0, 50.0, JavelinConstants.FIXED, 0, JavelinConstants.REGULAR, 1000, 10, 2, 990, 10);
			CampaignDiscount discount3 = new CampaignDiscount(3l, 100.0, 0.0, JavelinConstants.PERCENT, 25, JavelinConstants.REGULAR, 9999999, 10, 2, 1001, 10);
			CampaignDiscount discount4 = new CampaignDiscount(4l, 100.0, 0.0, JavelinConstants.PERCENT, 20, JavelinConstants.REGULAR, 1000, 10, 2, 990, 5);
			
			CampaignDiscount discount5 = new CampaignDiscount(5l, 100.0, 50.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 9999999, 10, 2, 990, 5);
			CampaignDiscount discount9 = new CampaignDiscount(9l, 100.0, 45.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 1000, 10, 2, 990, 5);
			
			CampaignDiscount discount6 = new CampaignDiscount(6l, 100.0, 0.0, JavelinConstants.FLAT, 10, JavelinConstants.ADDON, 9999999, 10, 2, 990, 9);
			CampaignDiscount discount7 = new CampaignDiscount(7l, 100.0, 0.0, JavelinConstants.PERCENT, 15, JavelinConstants.ADDON, 1000, 10, 2, 990, 5);
			CampaignDiscount discount8 = new CampaignDiscount(8l, 100.0, 0.0, JavelinConstants.FLAT, 5, JavelinConstants.ADDON, 1000, 10, 2, 990, 5);
			
			sessionStateful.insert(discount1);
			sessionStateful.insert(discount2);
			sessionStateful.insert(discount3);
			sessionStateful.insert(discount4);
			sessionStateful.insert(discount5);
			sessionStateful.insert(discount6);
			sessionStateful.insert(discount7);
			sessionStateful.insert(discount8);
			sessionStateful.insert(discount9);

            sessionStateful.fireAllRules();
            
            javelinPrice.setCampaigns((Set<Long>) sessionStateful.getGlobal("campaigns"));
            javelinPrice.setRedemptionLessCampaigns((Set<Long>) sessionStateful.getGlobal("redemptionLessCampaigns"));
            System.out.println(sessionStateful.getGlobal("netAvailableRedemptionQuantity"));
            
            System.out.println("Best SP final: "+ javelinPrice);
			
            sessionStateful.dispose();
            sessionStateful.destroy();

		} catch (Throwable t) {
            t.printStackTrace();
        }
		
		/*Account a = new Account();
		
		FactHandle handlea = sessionStateful.insert(a);
		System.out.println("First fire all rules");
		sessionStateful.fireAllRules();
		
		//a.setAccountNo(1);
		
		sessionStateful.update(handlea, a);
		System.out.println("Second fire all rules");
		
		sessionStateful.fireAllRules();*/
	}


}
