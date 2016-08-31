package com.forwardline.exception;

public class ConnectorException extends Exception {
	public ConnectorException(String message) {
		super(message);
	}

	public ConnectorException(Throwable t) {
		super(t);
	}

}
