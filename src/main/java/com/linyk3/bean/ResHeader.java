package com.linyk3.bean;


public class ResHeader {
	private String RTNSTS; 
	private String ERRMSG;
	
	public String getRTNSTS() {
		return RTNSTS;
	}
	public void setRTNSTS(String rTNSTS) {
		RTNSTS = rTNSTS;
	}
	public String getERRMSG() {
		return ERRMSG;
	}
	public void setERRMSG(String eRRMSG) {
		ERRMSG = eRRMSG;
	}

	public void setHeader(String rTNSTS,String eRRMSG) {
		RTNSTS = rTNSTS;
		ERRMSG=eRRMSG;
	}
	@Override
	public String toString() {
		return "ResHeader [RTNSTS=" + RTNSTS + ", ERRMSG=" + ERRMSG + "]";
	}
	
}
