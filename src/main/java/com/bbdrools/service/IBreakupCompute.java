/**
 * 
 */
package com.bbdrools.service;

/**
 * @author ayazpasha
 *
 */
public interface IBreakupCompute {

	/**
	 * Compute breakup amount and set in 
	 * CampaignDiscount object
	 * 
	 * @param discountType
	 * @param savingAmount
	 * @return breakupAmount
	 */
	public double compute(double breakupValue, double savingAmount);

}
