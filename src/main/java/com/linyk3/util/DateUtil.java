package com.linyk3.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private String dt;
	private String tm;
	private int sec;  //超过多少秒
	
	public DateUtil(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSSSS");
		String daytime = df.format(new Date());
		this.dt = daytime.substring(0,8);
		this.tm = daytime.substring(8, 19);
		this.sec = 60;
	}
	
	public DateUtil(String date, String time){
		this.dt = date;
		this.tm = time;
		this.sec = 60;
	}
	
	public DateUtil(String date, String time, int second){
		this.dt = date;
		this.tm = time;
		this.sec = second;
	}
	
	public DateUtil(int second){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSSSS");
		String daytime = df.format(new Date());
		this.dt = daytime.substring(0,8);
		this.tm = daytime.substring(8, 19);
		this.sec = second;
	}
	
	//判断是否超过sec
	public boolean isTimeOut(String date, String time) throws ParseException
	{
		if(!date.equals(dt)) {
			return true;
		}
		SimpleDateFormat simpleFormat = new SimpleDateFormat("HHmmssSSSSS");
		//System.out.println(date+time);
		//System.out.println(dt+tm);
		long tml = simpleFormat.parse(tm).getTime();
		long timel = simpleFormat.parse(time).getTime();
		long d = (tml - timel)/1000;
		//System.out.println("tm:"+tml+"-time"+timel+"="+d);
		
		if(d >= 0 && d < this.sec)
		{
			return false;
		}
		return true;
		
	}
	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}

	@Override
	public String toString() {
		return "DateUtil [dt=" + dt + ", tm=" + tm + "]";
	}
	

}
