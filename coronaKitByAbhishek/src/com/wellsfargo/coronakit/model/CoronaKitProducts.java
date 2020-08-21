package com.wellsfargo.coronakit.model;

public class CoronaKitProducts {
	private Integer pId;
	private String pName;
	private String pDesc;
	private Integer pCost;
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public Integer getpCost() {
		return pCost;
	}
	public void setpCost(Integer pCost) {
		this.pCost = pCost;
	}
	@Override
	public String toString() {
		return "CoronaKitProducts [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pCost=" + pCost + "]";
	}
	
}
