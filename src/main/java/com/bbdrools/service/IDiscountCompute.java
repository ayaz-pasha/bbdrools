/**
 * 
 */
package com.bbdrools.service;

import com.bbdrools.model.ProductDiscount;

/**
 * @author ayazpasha
 *
 */
public interface IDiscountCompute {
	
	/**
	 * Compute discount price and set selling price in 
	 * ProductDiscount object
	 * 
	 * @param productDiscount
	 * @return ProductDiscount
	 */
	public ProductDiscount compute(ProductDiscount productDiscount);

}
