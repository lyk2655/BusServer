package com.linyk3.bean;

import java.util.List;
import java.util.Map;

public class GAPI_DISTANCE {

	private String status;
	private String info;
	private String infocode;
	
	private List<GAPI_DISTANCE_RESULT> results;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public List<GAPI_DISTANCE_RESULT> getResults() {
		return results;
	}

	public void setResults(List<GAPI_DISTANCE_RESULT> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "GAPI_DISTANCE [status=" + status + ", info=" + info + ", infocode=" + infocode + ", results=" + results
				+ "]";
	}


}
