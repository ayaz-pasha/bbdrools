package com.bbdrools.service.impl;

import com.bbdrools.model.ProductDiscount;
import com.bbdrools.service.IDiscountCompute;
import com.bbdrools.util.JavelinConstants;

public class RegularDiscountCompute implements IDiscountCompute {

	public ProductDiscount compute(ProductDiscount productDiscount) {
		
		String discountType = productDiscount.getDiscountType();
		
		if(discountType.equals(JavelinConstants.FIXED)) {
			// 
		} else if(discountType.equals(JavelinConstants.FLAT)) {
			//
		} else if(discountType.equals(JavelinConstants.PERCENT)) {
			//
		} else {
			
			// :(
		}
		
		return productDiscount;
	}

}
