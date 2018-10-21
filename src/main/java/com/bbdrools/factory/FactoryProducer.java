/**
 * 
 */
package com.bbdrools.factory;

import com.bbdrools.util.JavelinConstants;

/**
 * @author ayazpasha
 *
 */
public class FactoryProducer {
	
	public static JAbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase(JavelinConstants.DISCOUNT_COMPUTE)) {
			return new DiscountComputeFactory();

		} else if (choice.equalsIgnoreCase(JavelinConstants.DISCOUNT_TYPE)) {
			return new DiscountTypeFactory();
			
		} else if (choice.equalsIgnoreCase(JavelinConstants.BREAKUP_COMPUTE)) {
			return new BreakupComputeFactory();
		}

		return null;
	}
}
