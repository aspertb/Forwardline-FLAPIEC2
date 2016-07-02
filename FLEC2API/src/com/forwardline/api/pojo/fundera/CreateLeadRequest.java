package com.forwardline.api.pojo.fundera;

import com.forwardline.salesforce.pojo.Lead;
import com.forwardline.salesforce.pojo.RequestHeader;

public class CreateLeadRequest {
	
	private RequestHeader header;
	private Lead nlead;
	
	public CreateLeadRequest(RequestHeader header, Lead nlead) {
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
