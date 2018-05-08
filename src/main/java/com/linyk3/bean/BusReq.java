package com.linyk3.bean;

public class BusReq {
	private ReqHeader head = new ReqHeader();
	private ReqBody body = new ReqBody();
	public ReqHeader getHead() {
		return head;
	}
	public void setHead(ReqHeader head) {
		this.head = head;
	}
	public ReqBody getBody() {
		return body;
	}
	public void setBody(ReqBody body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "QueryLineReq [head=" + head + ", body=" + body + "]";
	}
	
	
	
}
