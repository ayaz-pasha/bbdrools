package com.bbdrools.service.impl;

import com.bbdrools.model.ProductDiscount;
import com.bbdrools.service.IDiscountCompute;

public class RegularDiscountCompute implements IDiscountCompute {

	public ProductDiscount compute(ProductDiscount productDiscount) {
		
		String discountType = productDiscount.getDiscountType();
		
		if(discountType == "percent") {
			// 
		} else if(discountType == "rupees") {
			//
		} else if(discountType == "fixed") {
			//
		} else {
			
			// :(
		}
		
		return productDiscount;
	}

}
