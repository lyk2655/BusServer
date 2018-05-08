package com.linyk3.bean;

public class QueryLineRes {
	private ResHeader head;
	private QueryLineResBody body;
	public ResHeader getHead() {
		return head;
	}
	public void setHead(ResHeader head) {
		this.head = head;
	}
	public QueryLineResBody getBody() {
		return body;
	}
	public void setBody(QueryLineResBody body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "QueryLineRes [head=" + head + ", body=" + body + "]";
	}
	
	
}
