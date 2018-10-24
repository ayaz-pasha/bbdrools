/**
 * 
 */
package com.bbdrools.dto;

import java.util.Map;

import com.bbdrools.model.ProductDiscount;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ayazpasha
 *
 */
public class DiscountValidationResponseDTO {
	
	private String status;
	private String statusMsg;
	private Map<String, ProductDiscount> data;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("status_msg")
	public String getStatusMsg() {
		return statusMsg;
	}
	
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public Map<String, ProductDiscount> getData() {
		return data;
	}

	public void setData(Map<String, ProductDiscount> data) {
		this.data = data;
	}
	
}
