/**
 * 
 */
package com.bbdrools.service.impl;

import com.bbdrools.service.IBreakupCompute;

/**
 * @author ayazpasha
 *
 */
public class PercentBreakup implements IBreakupCompute {

	public double compute(double breakupValue, double savingAmount) {

		return (breakupValue / 100 * savingAmount);
	}

}
