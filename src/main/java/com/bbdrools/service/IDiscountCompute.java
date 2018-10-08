/**
 * 
 */
package com.bbdrools.service;

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
	public double compute(double mrp, double targetPrice, String discountType, double discountValue);

}
