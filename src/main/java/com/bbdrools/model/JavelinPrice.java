/**
 * 
 */
package com.bbdrools.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

/**
 * @author ayazpasha
 *
 */
@Data
public class JavelinPrice {
	
	private double sp;
	private double rsp;
	private double spCombo;
	private double rspCombo;
	private long narq;
	private Set<Long> campaigns = new HashSet<Long>();
	private Set<Long> comboCampaigns = new HashSet<Long>();
	private Set<Long> redemptionLessCampaigns = new HashSet<Long>();
	private Set<Long> redemptionLessComboCampaigns = new HashSet<Long>();
	private List<CampaignDiscount> discounts = new ArrayList<CampaignDiscount>();
	
	public JavelinPrice() { setNarq(9999999l); }
	
	@Override
	public String toString() {
	    
		return "{\"sp\": \""+getSp()+"\","
				+ "\"rsp\": \""+getRsp()+"\","
				+ "\"sp_combo\": \""+getSpCombo()+"\","
				+ "\"rsp_combo\": \""+getRspCombo()+"\","
				+ "\"narq\": \""+getNarq()+"\","
				+ "\"campaigns\": \""+getCampaigns()+"\","
				+ "\"combo_campaigns\": \""+getComboCampaigns()+"\","
				+ "\"redemption_less_campaigns\": \""+getRedemptionLessCampaigns()+"\","
				+ "\"redemption_less_combo_campaigns\": \""+getRedemptionLessComboCampaigns()+"\""
				+ "}";
		
	}

}
