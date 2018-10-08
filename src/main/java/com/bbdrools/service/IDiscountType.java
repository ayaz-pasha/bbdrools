/**
 * 
 */
package com.bbdrools.service;

/**
 * @author ayazpasha
 *
 */
public interface IDiscountType {
	
	/**
	 * 
	 * 
	 */
	public double apply(double mrp, double targetPrice, double discountValue);
}
