package com.forwardline.salesforce.api.pojo;

public class SalesforceRequest<T> {
	private T request;

	public T getRequest() {
		return request;
	}

	public void setRequest(T request) {
		this.request = request;
	}
}
