package com.linyk3.bean;


public class ResHeader {
	public String RTNSTS;
	public String ERRMSG;

	public ResHeader()
	{
		
	}
	public ResHeader(String RTNSTS, String ERRMSG) {
		this.ERRMSG = ERRMSG;
		this.RTNSTS = RTNSTS;
	}

	public void setRTNSTS(String RTNSTS) {
		this.RTNSTS = RTNSTS;
	}

	public void setERRMSG(String ERRMSG) {
		this.ERRMSG = ERRMSG;
	}
	
	public void setHeader(String RTNSTS,String ERRMSG) {
		this.RTNSTS = RTNSTS;
		this.ERRMSG = ERRMSG;
	}
	
	public String getRTNSTS() {
		return RTNSTS;
	}
	public String getERRMSG() {
		return ERRMSG;
	}
	@Override
	public String toString() {
		return "ResHeader [RTNSTS=" + RTNSTS + ", ERRMSG=" + ERRMSG + "]";
	}
	
}
