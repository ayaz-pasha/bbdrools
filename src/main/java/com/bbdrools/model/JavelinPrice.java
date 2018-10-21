/**
 * 
 */
package com.bbdrools.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ayazpasha
 *
 */
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
	
	public JavelinPrice() { setNarq(9999999l); }
	
	public double getSp() {
		return sp;
	}
	
	public void setSp(double sp) {
		this.sp = sp;
	}
	
	public Set<Long> getCampaigns() {
		return campaigns;
	}
	
	public void setCampaigns(Set<Long> campaigns) {
		this.campaigns = campaigns;
	}
	
	public double getRsp() {
		return rsp;
	}

	public void setRsp(double rsp) {
		this.rsp = rsp;
	}

	public long getNarq() {
		return narq;
	}

	public void setNarq(long narq) {
		this.narq = narq;
	}
	
	public Set<Long> getRedemptionLessCampaigns() {
		return redemptionLessCampaigns;
	}

	public void setRedemptionLessCampaigns(Set<Long> redemptionLessCampaigns) {
		this.redemptionLessCampaigns = redemptionLessCampaigns;
	}
	
	public double getSpCombo() {
		return spCombo;
	}

	public void setSpCombo(double spCombo) {
		this.spCombo = spCombo;
	}

	public double getRspCombo() {
		return rspCombo;
	}

	public void setRspCombo(double rspCombo) {
		this.rspCombo = rspCombo;
	}

	public Set<Long> getComboCampaigns() {
		return comboCampaigns;
	}

	public void setComboCampaigns(Set<Long> comboCampaigns) {
		this.comboCampaigns = comboCampaigns;
	}

	public Set<Long> getRedemptionLessComboCampaigns() {
		return redemptionLessComboCampaigns;
	}

	public void setRedemptionLessComboCampaigns(Set<Long> redemptionLessComboCampaigns) {
		this.redemptionLessComboCampaigns = redemptionLessComboCampaigns;
	}

	@Override
	public String toString() {
	    StringBuffer buff = new StringBuffer();
	    buff.append("-----JavelinPrice-----)\n");
	    buff.append("SP=" + getSp() + "\n");
	    buff.append("RSP=" + getRsp() + "\n");
	    buff.append("ComboSP=" + getSpCombo() + "\n");
	    buff.append("ComboRSP=" + getRspCombo() + "\n");
	    buff.append("NARQ=" + getNarq() + "\n");
	    buff.append("Campaigns=" + getCampaigns() + "\n");
	    buff.append("ComboCampaigns=" + getComboCampaigns() + "\n");
	    buff.append("RedemptionLessCampaigns=" + getRedemptionLessCampaigns() + "\n");
	    buff.append("RedemptionLessComboCampaigns=" + getRedemptionLessComboCampaigns() + "\n");
	    buff.append("-----JavelinPrice end-)");
	    return buff.toString();
	}

}
