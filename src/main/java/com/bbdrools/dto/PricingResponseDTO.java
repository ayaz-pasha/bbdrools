/**
 * 
 */
package com.bbdrools.dto;

import java.util.Map;

import com.bbdrools.model.JavelinPrice;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ayazpasha
 *
 */
public class PricingResponseDTO {
	
	private String status;
	
	private String statusMsg;
	private Map<String, JavelinPrice> data;

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

	public Map<String, JavelinPrice> getData() {
		return data;
	}

	public void setData(Map<String, JavelinPrice> data) {
		this.data = data;
	}
	
}
