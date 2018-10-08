/**
 * 
 */
package com.bbdrools.dto;

import com.bbdrools.model.BestDiscount;

/**
 * @author ayazpasha
 *
 */
public class PricingResponseDTO {
	
	private String skuId;
	private BestDiscount bestDiscount;
	
	public String getSkuId() {
		return skuId;
	}
	
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	
	public BestDiscount getBestDiscount() {
		return bestDiscount;
	}
	
	public void setBestDiscount(BestDiscount bestDiscount) {
		this.bestDiscount = bestDiscount;
	}
	
}
