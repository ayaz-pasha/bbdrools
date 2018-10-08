/**
 * 
 */
package com.bbdrools.service;

import java.util.List;

import com.bbdrools.model.ProductDiscount;

/**
 * @author ayazpasha
 *
 */
public interface IProductDiscountService {

	public List<ProductDiscount> validate(List<ProductDiscount> productDiscount);
}
