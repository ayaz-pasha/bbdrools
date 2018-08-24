/**
 * 
 */
package com.bbdrools.service.impl;

import com.bbdrools.model.ProductDiscount;
import com.bbdrools.service.IDiscountCompute;

/**
 * @author ayazpasha
 *
 */
public class DifferentialDiscountCompute implements IDiscountCompute {

	public ProductDiscount compute(ProductDiscount productDiscount) {

		return productDiscount;
	}

}
