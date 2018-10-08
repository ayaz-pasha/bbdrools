/**
 * 
 */
package com.bbdrools.service.impl;

import com.bbdrools.service.IDiscountType;

/**
 * @author ayazpasha
 *
 */
public class FlatDiscount implements IDiscountType {

	/**
	 * 
	 */
	public double apply(double mrp, double targetPrice, double discountValue) {

		return mrp - discountValue;
	}

}
