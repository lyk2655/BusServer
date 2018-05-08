package com.linyk3.bean;

public class BUS_USER {
	private String user_id;
	private String user_name;
	private String user_passwd;
	private String user_tell;
	private String user_line;
	private String user_mode;
	private String user_longitude;
	private String user_latitude;
	private String user_chgdt;
	private String user_chgtm;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public String getUser_tell() {
		return user_tell;
	}
	public void setUser_tell(String user_tell) {
		this.user_tell = user_tell;
	}
	public String getUser_line() {
		return user_line;
	}
	public void setUser_line(String user_line) {
		this.user_line = user_line;
	}
	public String getUser_mode() {
		return user_mode;
	}
	public void setUser_mode(String user_mode) {
		this.user_mode = user_mode;
	}
	public String getUser_longitude() {
		return user_longitude;
	}
	public void setUser_longitude(String user_longitude) {
		this.user_longitude = user_longitude;
	}
	public String getUser_latitude() {
		return user_latitude;
	}
	public void setUser_latitude(String user_latitude) {
		this.user_latitude = user_latitude;
	}
	public String getUser_chgdt() {
		return user_chgdt;
	}
	public void setUser_chgdt(String user_chgdt) {
		this.user_chgdt = user_chgdt;
	}
	public String getUser_chgtm() {
		return user_chgtm;
	}
	public void setUser_chgtm(String user_chgtm) {
		this.user_chgtm = user_chgtm;
	}
	@Override
	public String toString() {
		return "BUS_USER [user_id=" + user_id + ", user_name=" + user_name + ", user_passwd=" + user_passwd
				+ ", user_tell=" + user_tell + ", user_line=" + user_line + ", user_mode=" + user_mode
				+ ", user_longitude=" + user_longitude + ", user_latitude=" + user_latitude + ", user_chgdt="
				+ user_chgdt + ", user_chgtm=" + user_chgtm + "]";
	}
	
}
