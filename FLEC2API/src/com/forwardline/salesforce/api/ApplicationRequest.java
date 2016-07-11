package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.Application;
import com.forwardline.salesforce.api.pojo.RequestHeader;

public class ApplicationRequest {
	private RequestHeader header;
	private Application application;

	public ApplicationRequest() {

	}

	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
