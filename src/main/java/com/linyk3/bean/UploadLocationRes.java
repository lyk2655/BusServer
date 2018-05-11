package com.linyk3.bean;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"head","body"})
public class UploadLocationRes {
	private ResHeader head;
	private Bus body;
	public ResHeader getHead() {
		return head;
	}
	public void setHead(ResHeader head) {
		this.head = head;
	}
	public Bus getBody() {
		return body;
	}
	public void setBody(Bus body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "UploadLocationRes [head=" + head + ", body=" + body + "]";
	}
	
}
