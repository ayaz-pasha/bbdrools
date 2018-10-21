/**
 * 
 */
package com.bbdrools.factory;

import com.bbdrools.service.IBreakupCompute;
import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.service.IDiscountType;
import com.bbdrools.service.impl.AddonDiscountCompute;
import com.bbdrools.service.impl.ComboDiscountCompute;
import com.bbdrools.service.impl.DifferentialDiscountCompute;
import com.bbdrools.service.impl.PercentDiscount;
import com.bbdrools.service.impl.RegularDiscountCompute;
import com.bbdrools.util.JavelinConstants;

/**
 * @author ayazpasha
 *
 */
public class DiscountComputeFactory extends JAbstractFactory {

	@Override
	public IDiscountType getDiscountType(String discountType) {

		return null;
	}

	@Override
	public IDiscountCompute getDiscountCompute(String discountTier) {
		
		if(discountTier == null) {
		
			return null;
		}
		
		if(discountTier.equalsIgnoreCase(JavelinConstants.REGULAR)) {
			
			return new RegularDiscountCompute();
		} else if(discountTier.equalsIgnoreCase(JavelinConstants.DIFFERENTIAL)) {
			
			return new DifferentialDiscountCompute();
		} else if(discountTier.equalsIgnoreCase(JavelinConstants.ADDON)) {
			
			return new AddonDiscountCompute();
		} else if(discountTier.equalsIgnoreCase(JavelinConstants.COMBO)) {
			
			return new ComboDiscountCompute();
		} 
		
		return null;
	}

	@Override
	public IBreakupCompute getBreakupCompute(String discountType) {
		
		return null;
	}

}
