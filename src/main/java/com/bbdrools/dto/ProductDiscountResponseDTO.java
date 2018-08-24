/**
 * 
 */
package com.bbdrools.dto;

import com.bbdrools.model.ProductDiscount;

/**
 * @author ayazpasha
 *
 */
public class ProductDiscountResponseDTO {

	private String status;
	private ProductDiscount productDiscount;

	public ProductDiscountResponseDTO() {
		this.status = "FAIL";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProductDiscount getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(ProductDiscount productDiscount) {
		this.productDiscount = productDiscount;
	}
	
}
