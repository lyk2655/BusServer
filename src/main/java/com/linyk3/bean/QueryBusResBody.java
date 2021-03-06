package com.linyk3.bean;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"bus_id","bus_num","bus_line","bus_driver","bus_tell","bus_longitude1","bus_latitude1","bus_longitude2","bus_latitude2","bus_longitude3","bus_latitude3","bus_uploadid","bus_uploaddt","bus_uploadtm","bus_laststa","bus_lasttm","bus_nextsta","bus_nexttm","bus_nextdis","bus_chgdt","bus_chgtm","stanum","stadis","statime"})
public class QueryBusResBody {
	private String bus_id;
	private String bus_num;
	private String bus_line;
	private String bus_driver;
	private String bus_tell;
	private String bus_longitude1;
	private String bus_latitude1;
	private String bus_longitude2;
	private String bus_latitude2;
	private String bus_longitude3;
	private String bus_latitude3;
	private String bus_uploadid;
	private String bus_uploaddt;
	private String bus_uploadtm;
	private String bus_laststa;
	private String bus_lasttm;
	private String bus_nextsta;
	private String bus_nexttm;
	private String bus_nextdis;
	private String bus_chgdt;
	private String bus_chgtm;
	private String stanum;
	private String stadis;
	private String statime;
	
	public void setBus(Bus bus) {
		this.bus_id =bus.getBus_id();
		this.bus_num =bus.getBus_num();
		this.bus_line =bus.getBus_line();
		this.bus_driver =bus.getBus_driver();
		this.bus_tell =bus.getBus_tell();
		this.bus_longitude1 =bus.getBus_longitude1();
		this.bus_latitude1 =bus.getBus_latitude1();
		this.bus_longitude2 =bus.getBus_longitude2();
		this.bus_latitude2 =bus.getBus_latitude2();
		this.bus_longitude3 =bus.getBus_longitude3();
		this.bus_latitude3 =bus.getBus_latitude3();
		this.bus_uploadid =bus.getBus_uploadid();
		this.bus_uploaddt =bus.getBus_uploaddt();
		this.bus_uploadtm =bus.getBus_uploadtm();
		this.bus_laststa =bus.getBus_laststa();
		this.bus_lasttm =bus.getBus_lasttm();
		this.bus_nextsta =bus.getBus_nextsta();
		this.bus_nexttm =bus.getBus_nexttm();
		this.bus_nextdis =bus.getBus_nextdis();
		this.bus_chgdt =bus.getBus_chgdt();
		this.bus_chgtm =bus.getBus_chgtm();
		this.stanum = "1";
		this.stadis = "0";
		this.statime = "0";
	}
	
	public String getBus_id() {
		return bus_id;
	}
	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}
	public String getBus_num() {
		return bus_num;
	}
	public void setBus_num(String bus_num) {
		this.bus_num = bus_num;
	}
	public String getBus_line() {
		return bus_line;
	}
	public void setBus_line(String bus_line) {
		this.bus_line = bus_line;
	}
	public String getBus_driver() {
		return bus_driver;
	}
	public void setBus_driver(String bus_driver) {
		this.bus_driver = bus_driver;
	}
	public String getBus_tell() {
		return bus_tell;
	}
	public void setBus_tell(String bus_tell) {
		this.bus_tell = bus_tell;
	}
	public String getBus_longitude1() {
		return bus_longitude1;
	}
	public void setBus_longitude1(String bus_longitude1) {
		this.bus_longitude1 = bus_longitude1;
	}
	public String getBus_latitude1() {
		return bus_latitude1;
	}
	public void setBus_latitude1(String bus_latitude1) {
		this.bus_latitude1 = bus_latitude1;
	}
	public String getBus_longitude2() {
		return bus_longitude2;
	}
	public void setBus_longitude2(String bus_longitude2) {
		this.bus_longitude2 = bus_longitude2;
	}
	public String getBus_latitude2() {
		return bus_latitude2;
	}
	public void setBus_latitude2(String bus_latitude2) {
		this.bus_latitude2 = bus_latitude2;
	}
	public String getBus_longitude3() {
		return bus_longitude3;
	}
	public void setBus_longitude3(String bus_longitude3) {
		this.bus_longitude3 = bus_longitude3;
	}
	public String getBus_latitude3() {
		return bus_latitude3;
	}
	public void setBus_latitude3(String bus_latitude3) {
		this.bus_latitude3 = bus_latitude3;
	}
	public String getBus_uploadid() {
		return bus_uploadid;
	}
	public void setBus_uploadid(String bus_uploadid) {
		this.bus_uploadid = bus_uploadid;
	}
	public String getBus_uploaddt() {
		return bus_uploaddt;
	}
	public void setBus_uploaddt(String bus_uploaddt) {
		this.bus_uploaddt = bus_uploaddt;
	}
	public String getBus_uploadtm() {
		return bus_uploadtm;
	}
	public void setBus_uploadtm(String bus_uploadtm) {
		this.bus_uploadtm = bus_uploadtm;
	}
	public String getBus_laststa() {
		return bus_laststa;
	}
	public void setBus_laststa(String bus_laststa) {
		this.bus_laststa = bus_laststa;
	}
	public String getBus_lasttm() {
		return bus_lasttm;
	}
	public void setBus_lasttm(String bus_lasttm) {
		this.bus_lasttm = bus_lasttm;
	}
	public String getBus_nextsta() {
		return bus_nextsta;
	}
	public void setBus_nextsta(String bus_nextsta) {
		this.bus_nextsta = bus_nextsta;
	}
	public String getBus_nexttm() {
		return bus_nexttm;
	}
	public void setBus_nexttm(String bus_nexttm) {
		this.bus_nexttm = bus_nexttm;
	}
	public String getBus_nextdis() {
		return bus_nextdis;
	}
	public void setBus_nextdis(String bus_nextdis) {
		this.bus_nextdis = bus_nextdis;
	}
	public String getBus_chgdt() {
		return bus_chgdt;
	}
	public void setBus_chgdt(String bus_chgdt) {
		this.bus_chgdt = bus_chgdt;
	}
	public String getBus_chgtm() {
		return bus_chgtm;
	}
	public void setBus_chgtm(String bus_chgtm) {
		this.bus_chgtm = bus_chgtm;
	}
	public String getStanum() {
		return stanum;
	}
	public void setStanum(String stanum) {
		this.stanum = stanum;
	}
	public String getStadis() {
		return stadis;
	}
	public void setStadis(String stadis) {
		this.stadis = stadis;
	}
	public String getStatime() {
		return statime;
	}
	public void setStatime(String statime) {
		this.statime = statime;
	}
	@Override
	public String toString() {
		return "QueryBusResBody [bus_id=" + bus_id + ", bus_num=" + bus_num + ", bus_line=" + bus_line + ", bus_driver="
				+ bus_driver + ", bus_tell=" + bus_tell + ", bus_longitude1=" + bus_longitude1 + ", bus_latitude1="
				+ bus_latitude1 + ", bus_longitude2=" + bus_longitude2 + ", bus_latitude2=" + bus_latitude2
				+ ", bus_longitude3=" + bus_longitude3 + ", bus_latitude3=" + bus_latitude3 + ", bus_uploadid="
				+ bus_uploadid + ", bus_uploaddt=" + bus_uploaddt + ", bus_uploadtm=" + bus_uploadtm + ", bus_laststa="
				+ bus_laststa + ", bus_lasttm=" + bus_lasttm + ", bus_nextsta=" + bus_nextsta + ", bus_nexttm="
				+ bus_nexttm + ", bus_nextdis=" + bus_nextdis + ", bus_chgdt=" + bus_chgdt + ", bus_chgtm=" + bus_chgtm
				+ ", stanum=" + stanum + ", stadis=" + stadis + ", statime=" + statime + "]";
	}
	
	
}
