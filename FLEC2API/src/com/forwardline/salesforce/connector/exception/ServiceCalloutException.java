package com.forwardline.salesforce.connector.exception;

public class ServiceCalloutException extends Exception {
	public ServiceCalloutException(String message) {
		super(message);
	}
	
	public ServiceCalloutException(Throwable t) {
		super(t);
	}
}
