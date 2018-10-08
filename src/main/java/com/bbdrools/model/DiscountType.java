/**
 * 
 */
package com.bbdrools.model;

/**
 * @author ayazpasha
 *
 */
public interface DiscountType {

	public Double apply(double base, String type, double amount);
}
