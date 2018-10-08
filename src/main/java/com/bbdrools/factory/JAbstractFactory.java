/**
 * 
 */
package com.bbdrools.factory;

import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.service.IDiscountType;

/**
 * @author ayazpasha
 *
 */
public abstract class JAbstractFactory {

	public abstract IDiscountType getDiscountType(String discountType);
	public abstract IDiscountCompute getDiscountCompute(String discountTier);
}
