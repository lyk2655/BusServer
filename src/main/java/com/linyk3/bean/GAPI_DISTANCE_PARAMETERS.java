package com.linyk3.bean;

public class GAPI_DISTANCE_PARAMETERS {
	private String key;
	private String origins;
	private String destination;
	private String type;
	private String output;
	
	public GAPI_DISTANCE_PARAMETERS() {
		this.key = "8ad12a9140feb5b3ebdcd83abf021d45";
		this.type = "1";
		this.output = "json";
	}
	
	public GAPI_DISTANCE_PARAMETERS(String ori, String des) {
		this.key = "8ad12a9140feb5b3ebdcd83abf021d45";
		this.type = "1";
		this.output = "json";
		this.origins = ori;
		this.destination = des;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOrigins() {
		return origins;
	}
	public void setOrigins(String origins) {
		this.origins = origins;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	@Override
	public String toString() {
		return "GAPI_DISTANCE_PARAMETERS [key=" + key + ", origins=" + origins + ", destination=" + destination
				+ ", type=" + type + ", output=" + output + "]";
	}
	
	
	
}
