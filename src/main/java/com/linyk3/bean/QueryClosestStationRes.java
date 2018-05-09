package com.linyk3.bean;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"head","body"})
public class QueryClosestStationRes {
	private ResHeader head;
	private Line body;
	public ResHeader getHead() {
		return head;
	}
	public void setHead(ResHeader head) {
		this.head = head;
	}
	public Line getBody() {
		return body;
	}
	public void setBody(Line body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "QueryClosestStationRes [head=" + head + ", body=" + body + "]";
	}
	
	
}
