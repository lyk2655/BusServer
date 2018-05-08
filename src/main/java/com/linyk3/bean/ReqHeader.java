package com.linyk3.bean;


public class ReqHeader {
	private String TRACDE; //前端交易码
	private String TRADAT; //交易日期
	private String TRATIM; //交易时间
	private String USRNAM; //登陆用户名
	
	public String getTRACDE() {
		return TRACDE;
	}
	public void setTRACDE(String tRACDE) {
		TRACDE = tRACDE;
	}
	public String getTRADAT() {
		return TRADAT;
	}
	public void setTRADAT(String tRADAT) {
		TRADAT = tRADAT;
	}
	public String getTRATIM() {
		return TRATIM;
	}
	public void setTRATIM(String tRATIM) {
		TRATIM = tRATIM;
	}
	public String getUSRNAM() {
		return USRNAM;
	}
	public void setUSRNAM(String uSRNAM) {
		USRNAM = uSRNAM;
	}
	@Override
	public String toString() {
		return "ReqHeader [TRACDE=" + TRACDE + ", TRADAT=" + TRADAT + ", TRATIM=" + TRATIM + ", USRNAM=" + USRNAM
				+ "]";
	}
	

}
