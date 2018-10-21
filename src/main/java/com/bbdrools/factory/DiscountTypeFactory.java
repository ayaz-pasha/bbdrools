/**
 * 
 */
package com.bbdrools.factory;

import com.bbdrools.service.IBreakupCompute;
import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.service.IDiscountType;
import com.bbdrools.service.impl.FixedDiscount;
import com.bbdrools.service.impl.FlatDiscount;
import com.bbdrools.service.impl.PercentDiscount;
import com.bbdrools.util.JavelinConstants;

/**
 * @author ayazpasha
 *
 */
public class DiscountTypeFactory extends JAbstractFactory {

	@Override
	public IDiscountType getDiscountType(String discountType) {

		if(discountType == null) {
			
			return null;
		}
		
		if(discountType.equalsIgnoreCase(JavelinConstants.FIXED)) {
			
			return new FixedDiscount();
		} else if(discountType.equalsIgnoreCase(JavelinConstants.FLAT)) {
			
			return new FlatDiscount();
		} else if(discountType.equalsIgnoreCase(JavelinConstants.PERCENT)) {
			
			return new PercentDiscount();
		} 
		
		return null;
	}

	@Override
	public IDiscountCompute getDiscountCompute(String discountTier) {

		return null;
	}

	@Override
	public IBreakupCompute getBreakupCompute(String discountType) {
		// TODO Auto-generated method stub
		return null;
	}

}
