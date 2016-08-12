package com.forwardline.salesforce.connector.types;

public class ForsightRequest {
	private RequestHeader header;
	private Application application; 
	private Analysis analysis;

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

	public Analysis getAnalysis() {
		return analysis;  
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

}
