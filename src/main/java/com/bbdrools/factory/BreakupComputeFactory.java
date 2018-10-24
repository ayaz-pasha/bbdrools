/**
 * 
 */
package com.bbdrools.factory;

import com.bbdrools.service.IBreakupCompute;
import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.service.IDiscountType;
import com.bbdrools.service.impl.INRBreakup;
import com.bbdrools.service.impl.PercentBreakup;

/**
 * @author ayazpasha
 *
 */
public class BreakupComputeFactory extends JAbstractFactory {

	@Override
	public IDiscountType getDiscountType(String discountType) {

		return null;
	}

	@Override
	public IDiscountCompute getDiscountCompute(String discountTier) {

		return null;
	}

	@Override
	public IBreakupCompute getBreakupCompute(String discountType) {
		
		if(discountType == null) {
			
			return null;
		}
		
		if(discountType.equalsIgnoreCase("FLAT") 
				|| discountType.equalsIgnoreCase("FIXED")) {

			return new INRBreakup();
		} else if(discountType.equalsIgnoreCase("PERCENT")) {
			
			return new PercentBreakup();
		}
		
		return null;
	}

}
