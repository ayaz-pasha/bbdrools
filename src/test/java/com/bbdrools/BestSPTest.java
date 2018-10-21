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
			sessionStateful.setGlobal("redemptionLessComboCampaigns", new HashSet<Long>());
			sessionStateful.setGlobal("comboCampaigns", new HashSet<Long>());
			sessionStateful.setGlobal("netAvailableRedemptionQuantity", 9999999l);
			
			/*CampaignDiscount discount1 = new CampaignDiscount(1l, 100.0, 0.0, JavelinConstants.FLAT, 10, JavelinConstants.REGULAR, 5, 9999999, 10, 2, 990, 10);
			CampaignDiscount discount2 = new CampaignDiscount(2l, 100.0, 50.0, JavelinConstants.FIXED, 0, JavelinConstants.REGULAR, 2, 1000, 10, 2, 990, 10);//
			CampaignDiscount discount3 = new CampaignDiscount(3l, 100.0, 0.0, JavelinConstants.FLAT, 12, JavelinConstants.REGULAR, 3, 9999999, 10, 2, 1001, 10);
			CampaignDiscount discount4 = new CampaignDiscount(4l, 100.0, 0.0, JavelinConstants.PERCENT, 20, JavelinConstants.REGULAR, 4, 1000, 10, 2, 990, 5);
			
			CampaignDiscount discount5 = new CampaignDiscount(5l, 100.0, 50.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 1, 9999999, 10, 2, 990, 5);
			CampaignDiscount discount9 = new CampaignDiscount(9l, 100.0, 45.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 2, 1000, 10, 2, 990, 5);
			
			CampaignDiscount discount6 = new CampaignDiscount(6l, 100.0, 0.0, JavelinConstants.FLAT, 10, JavelinConstants.ADDON, 1, 9999999, 10, 2, 990, 9);
			CampaignDiscount discount7 = new CampaignDiscount(7l, 100.0, 0.0, JavelinConstants.PERCENT, 15, JavelinConstants.ADDON, 2, 1000, 10, 2, 990, 5);
			CampaignDiscount discount8 = new CampaignDiscount(8l, 100.0, 0.0, JavelinConstants.FLAT, 5, JavelinConstants.ADDON, 3, 1000, 10, 2, 990, 5);
			
			CampaignDiscount discount10 = new CampaignDiscount(10l, 100.0, 0.0, JavelinConstants.PERCENT, 15, JavelinConstants.COMBO, 1, 10000, 10, 2, 990, 5);
			CampaignDiscount discount11 = new CampaignDiscount(11l, 100.0, 0.0, JavelinConstants.FLAT, 5, JavelinConstants.COMBO, 2, 9999999, 10, 2, 990, 5);
	*/
			CampaignDiscount discount1 = new CampaignDiscount(1l, 100.0, 30.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 5, 1000, 10, 2, 1000, 1);
			CampaignDiscount discount2 = new CampaignDiscount(2l, 100.0, 50.0, JavelinConstants.FIXED, 0, JavelinConstants.REGULAR, 2, 1000, 10, 2, 990, 10);//
			CampaignDiscount discount3 = new CampaignDiscount(3l, 100.0, 101.0, JavelinConstants.FIXED, 12, JavelinConstants.DIFFERENTIAL, 3, 9999999, 10, 2, 1001, 10);
			CampaignDiscount discount4 = new CampaignDiscount(4l, 100.0, 50.0, JavelinConstants.FIXED, 20, JavelinConstants.DIFFERENTIAL, 4, 9999999, 10, 2, 6, 4);//*
			
			CampaignDiscount discount5 = new CampaignDiscount(5l, 100.0, 40.0, JavelinConstants.FIXED, 80, JavelinConstants.DIFFERENTIAL, 1, 9999, 10, 2, 5, 1);//*
			//CampaignDiscount discount9 = new CampaignDiscount(9l, 100.0, 45.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 2, 1000, 10, 2, 990, 5);
			
			CampaignDiscount discount6 = new CampaignDiscount(6l, 100.0, 0.0, JavelinConstants.FLAT, 80, JavelinConstants.REGULAR, 1, 9999, 10, 2, 990, 2);//*
			CampaignDiscount discount7 = new CampaignDiscount(7l, 100.0, 0.0, JavelinConstants.PERCENT, 60, JavelinConstants.ADDON, 2, 1000, 10, 2, 999, 6);
			CampaignDiscount discount8 = new CampaignDiscount(8l, 100.0, 0.0, JavelinConstants.FLAT, 40, JavelinConstants.ADDON, 3, 1000, 10, 2, 996, 4);
			
			CampaignDiscount discount9 = new CampaignDiscount(9l, 100.0, 0.0, JavelinConstants.FLAT, 35, JavelinConstants.ADDON, 1, 1000, 10, 2, 996, 4);
			CampaignDiscount discount10 = new CampaignDiscount(10l, 100.0, 0.0, JavelinConstants.FLAT, 15, JavelinConstants.ADDON, 2, 9999999, 10, 2, 990, 5);
	
			sessionStateful.insert(discount1);
			sessionStateful.insert(discount2);
			sessionStateful.insert(discount3);
			sessionStateful.insert(discount4);
			sessionStateful.insert(discount5);
			sessionStateful.insert(discount6);
			sessionStateful.insert(discount7);
			sessionStateful.insert(discount8);
			sessionStateful.insert(discount9);
			sessionStateful.insert(discount10);
			//sessionStateful.insert(discount11);

            sessionStateful.fireAllRules();
            
            javelinPrice.setCampaigns((Set<Long>) sessionStateful.getGlobal("campaigns"));
            javelinPrice.setRedemptionLessCampaigns((Set<Long>) sessionStateful.getGlobal("redemptionLessCampaigns"));
            
            javelinPrice.setComboCampaigns((Set<Long>) sessionStateful.getGlobal("comboCampaigns"));
            javelinPrice.setRedemptionLessComboCampaigns((Set<Long>) sessionStateful.getGlobal("redemptionLessComboCampaigns"));
            
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
