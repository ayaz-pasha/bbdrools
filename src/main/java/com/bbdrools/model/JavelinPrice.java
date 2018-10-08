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
	private long narq;
	private Set<Long> campaigns = new HashSet<Long>();
	private Set<Long> redemptionLessCampaigns = new HashSet<Long>();
	
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

	@Override
	public String toString() {
	    StringBuffer buff = new StringBuffer();
	    buff.append("-----JavelinPrice-----)\n");
	    buff.append("SP=" + getSp() + "\n");
	    buff.append("RSP=" + getRsp() + "\n");
	    buff.append("NARQ=" + getNarq() + "\n");
	    buff.append("Campaigns=" + getCampaigns() + "\n");
	    buff.append("RedemptionLessCampaigns=" + getRedemptionLessCampaigns() + "\n");
	    buff.append("-----JavelinPrice end-)");
	    return buff.toString();
	}

}
