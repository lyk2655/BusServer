package com.linyk3.bean;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"head","body"})
public class QueryBusRes {
	private ResHeader head;
	private QueryBusResBody body;
	public ResHeader getHead() {
		return head;
	}
	public void setHead(ResHeader head) {
		this.head = head;
	}
	public QueryBusResBody getBody() {
		return body;
	}
	public void setBody(QueryBusResBody body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "QueryBusRes [head=" + head + ", body=" + body + "]";
	}
	
}
