package com.linyk3.bean;

public class ReqBody {
	private String line;
	private String mode;
	private String stanum;
	private String longitude;
	private String latitude;
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getStanum() {
		return stanum;
	}
	public void setStanum(String stanum) {
		this.stanum = stanum;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "ReqBody [line=" + line + ", mode=" + mode + ", stanum=" + stanum + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}
	
}
