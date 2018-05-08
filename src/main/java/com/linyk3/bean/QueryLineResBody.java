package com.linyk3.bean;

import java.util.List;

public class QueryLineResBody {
	private List<Line> LineList;

	public List<Line> getLineList() {
		return LineList;
	}

	public void setLineList(List<Line> lineList) {
		LineList = lineList;
	}

	@Override
	public String toString() {
		return "QueryLineResBody [LineList=" + LineList + "]";
	}
	

	
}
