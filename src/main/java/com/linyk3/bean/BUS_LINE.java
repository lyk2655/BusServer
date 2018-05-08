package com.linyk3.bean;

public class BUS_LINE {
	private String line_id;
	private String line_stanum;
	private String line_staname;
	private String line_longitude;
	private String line_latitude;
	private String line_uptime;
	private String line_downtime;
	private String line_chgdt;
	private String line_chgtm;
	
	public String getLine_id() {
		return line_id;
	}
	public void setLine_id(String line_id) {
		this.line_id = line_id;
	}
	public String getLine_stanum() {
		return line_stanum;
	}
	public void setLine_stanum(String line_stanum) {
		this.line_stanum = line_stanum;
	}
	public String getLine_staname() {
		return line_staname;
	}
	public void setLine_staname(String line_staname) {
		this.line_staname = line_staname;
	}
	public String getLine_longitude() {
		return line_longitude;
	}
	public void setLine_longitude(String line_longitude) {
		this.line_longitude = line_longitude;
	}
	public String getLine_latitude() {
		return line_latitude;
	}
	public void setLine_latitude(String line_latitude) {
		this.line_latitude = line_latitude;
	}
	public String getLine_uptime() {
		return line_uptime;
	}
	public void setLine_uptime(String line_uptime) {
		this.line_uptime = line_uptime;
	}
	public String getLine_downtime() {
		return line_downtime;
	}
	public void setLine_downtime(String line_downtime) {
		this.line_downtime = line_downtime;
	}
	public String getLine_chgdt() {
		return line_chgdt;
	}
	public void setLine_chgdt(String line_chgdt) {
		this.line_chgdt = line_chgdt;
	}
	public String getLine_chgtm() {
		return line_chgtm;
	}
	public void setLine_chgtm(String line_chgtm) {
		this.line_chgtm = line_chgtm;
	}
	
	
	@Override
	public String toString() {
		return "BUS_LINE [line_id=" + line_id + ", line_stanum=" + line_stanum + ", line_staname=" + line_staname
				+ ", line_longitude=" + line_longitude + ", line_latitude=" + line_latitude + ", line_uptime="
				+ line_uptime + ", line_downtime=" + line_downtime + ", line_chgdt=" + line_chgdt + ", line_chgtm="
				+ line_chgtm + "]";
	}
	
}
