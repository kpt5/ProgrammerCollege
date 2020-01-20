package com.internousdev.webproj3.dto;

public class InquiryDTO {
	private String name;
	private String qtype;
	private String body;

	public void setName(String name) {
		this.name = name;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public String getQtype() {
		return qtype;
	}

	public String getBody() {
		return body;
	}
}
