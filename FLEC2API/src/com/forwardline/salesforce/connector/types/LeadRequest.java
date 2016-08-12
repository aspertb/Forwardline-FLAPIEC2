package com.forwardline.salesforce.connector.types;

public class LeadRequest {
	
	private RequestHeader header;
	private Lead nlead;
	
	public LeadRequest(RequestHeader header, Lead nlead) {
		super();
		this.header = header;
		this.nlead = nlead;
	}
	
	public LeadRequest() {
		// TODO Auto-generated constructor stub
	}

	public RequestHeader getHeader() {
		return header;
	}
	public void setHeader(RequestHeader header) {
		this.header = header;
	}
	public Lead getNlead() {
		return nlead;
	}
	public void setNlead(Lead nlead) {
		this.nlead = nlead;
	}

}
