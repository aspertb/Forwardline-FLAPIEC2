package com.forwardline.salesforce.connector.exception;

public class InvalidSessionException extends Exception {
	public InvalidSessionException(String message) {
		super(message);
	}

	public InvalidSessionException(Throwable t) {
		super(t);
	}
}
