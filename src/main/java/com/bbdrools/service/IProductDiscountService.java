/**
 * 
 */
package com.bbdrools.service;

import com.bbdrools.model.ProductDiscount;

/**
 * @author ayazpasha
 *
 */
public interface IProductDiscountService {

	public ProductDiscount runRules(ProductDiscount productDiscount);
}
