package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.Lead;
import com.forwardline.salesforce.api.pojo.RequestHeader;

public class LeadRequest {
	
	private RequestHeader header;
	private Lead nlead;
	
	public LeadRequest(RequestHeader header, Lead nlead) {
		super();
		this.header = header;
		this.nlead = nlead;
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
