/**
 * 
 */
package com.bbdrools.service.impl;

import com.bbdrools.factory.FactoryProducer;
import com.bbdrools.factory.JAbstractFactory;
import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.service.IDiscountType;
import com.bbdrools.util.JavelinConstants;

/**
 * @author ayazpasha
 *
 */
public class ComboDiscountCompute implements IDiscountCompute {

	/**
	 * 
	 */
	public double compute(double mrp, double targetPrice, String discountType, double discountValue) {
		
		JAbstractFactory discountTypeFactory = FactoryProducer.getFactory(JavelinConstants.DISCOUNT_TYPE);
		IDiscountType discountTypeObj = discountTypeFactory.getDiscountType(discountType);
		
		return discountTypeObj.apply(mrp, targetPrice, discountValue);
	}

}
