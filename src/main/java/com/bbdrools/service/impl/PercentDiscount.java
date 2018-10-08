/**
 * 
 */
package com.bbdrools.service.impl;

import com.bbdrools.service.IDiscountType;

/**
 * @author ayazpasha
 *
 */
public class PercentDiscount implements IDiscountType {

	/**
	 * 
	 */
	public double apply(double mrp, double targetPrice, double discountValue) {

		return mrp - (mrp * discountValue / 100);
	}

}
