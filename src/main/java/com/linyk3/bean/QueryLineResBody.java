package com.linyk3.bean;

import java.util.List;

public class QueryLineResBody {
	private List<Line> stationList;

	public List<Line> getStationList() {
		return stationList;
	}

	public void setStationList(List<Line> stationList) {
		this.stationList = stationList;
	}

	@Override
	public String toString() {
		return "QueryLineResBody [stationList=" + stationList + "]";
	}

	
	

	
}
