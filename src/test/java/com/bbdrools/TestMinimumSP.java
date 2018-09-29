package com.bbdrools;

import java.util.ArrayList;
import java.util.List;

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

import com.bbdrools.model.BestDiscount;
import com.bbdrools.model.Discount;
import com.bbdrools.model.Product;
import com.bbdrools.util.KnowledgeSessionHelper;

public class TestMinimumSP {

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
						"minimim-sp-ksession-rules");		

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
			
			Product product = new Product();
			product.setId(1);
			product.setCp(100.0);
			product.setDesc("Some product");
			product.setMrp(120.0);
			
			BestDiscount bestDiscount = new BestDiscount();
			sessionStateful.setGlobal("bestDiscount", bestDiscount);
			
			sessionStateful.setGlobal("campaigns", new ArrayList<Long>());
			
			List<Discount> discounts = new ArrayList<Discount>();
			Discount discount1 = new Discount(1, 2.0, "A", 1, 11);
			Discount discount2 = new Discount(2, 0.0, "A", 2, 22);
			Discount discount3 = new Discount(3, 5.0, "B", 3, 33);
			Discount discount4 = new Discount(4, 25.0, "B", 4, 44);
			Discount discount5 = new Discount(5, 1.0, "C", 5, 55);
			Discount discount6 = new Discount(6, 15.0, "A", 6, 66);
			Discount discount7 = new Discount(7, 60.0, "B", 7, 77);
			Discount discount8 = new Discount(8, 0.5, "C", 8, 88);
			Discount discount9 = new Discount(9, 55.0, "A", 9, 99);
			Discount discount10 = new Discount(10, 15.0, "B", 10, 101);
			Discount discount11 = new Discount(11, 50.0, "A", 11, 111);
			Discount discount12 = new Discount(12, 15.0, "B", 12, 122);
			
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
			sessionStateful.insert(discount11);
			sessionStateful.insert(discount12);
			
			product.setDiscounts(discounts);
            
            //sessionStateful.insert(product);
            
            sessionStateful.fireAllRules();
            
            bestDiscount.setCampaigns((ArrayList<Long>) sessionStateful.getGlobal("campaigns"));
            System.out.println("Best Discount final: "+ bestDiscount);
			
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
