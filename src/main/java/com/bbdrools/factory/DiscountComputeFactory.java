/**
 * 
 */
package com.bbdrools.factory;

import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.service.IDiscountType;
import com.bbdrools.service.impl.AddonDiscountCompute;
import com.bbdrools.service.impl.ComboDiscountCompute;
import com.bbdrools.service.impl.DifferentialDiscountCompute;
import com.bbdrools.service.impl.RegularDiscountCompute;

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
		
		if(discountTier.equalsIgnoreCase("ADDON")) {

			return new AddonDiscountCompute();
		} else if(discountTier.equalsIgnoreCase("COMBO")) {
			
			return new ComboDiscountCompute();
		} else if(discountTier.equalsIgnoreCase("DIFFERENTIAL")) {
			
			return new DifferentialDiscountCompute();
		} else if(discountTier.equalsIgnoreCase("REGULAR")) {
			
			return new RegularDiscountCompute();
		} 
		
		return null;
	}

}
