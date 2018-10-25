/**
 * 
 */
package com.bbdrools.dto;

import java.util.Map;

import com.bbdrools.model.ProductDiscount;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author ayazpasha
 *
 */
@Data
public class DiscountValidationResponseDTO {
	
	private String status;
	
	@JsonProperty("status_msg")
	private String statusMsg;
	
	private Map<String, ProductDiscount> data;

	@Override
	public String toString() {

		return "{\"status\": \""+getStatus()+"\","
				+ "\"status_msg\": \""+getStatusMsg()+"\","
				+ "\"data\": \""+getData()+"\","
				+ "}";
	}
	
}
