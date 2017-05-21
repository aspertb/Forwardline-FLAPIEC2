package com.forwardline.api.milo.types;

import com.forwardline.salesforce.connector.types.RequestHeader;

public class ApplicationRequest {
	private RequestHeader header;
	private Application nApplication;

	public ApplicationRequest() {
		// TODO Auto-generated constructor stub
	}

	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header; 
	}

	public Application getnApplication() {
		return nApplication;
	}

	public void setnApplication(Application nApplication) {
		this.nApplication = nApplication;
	}

}
