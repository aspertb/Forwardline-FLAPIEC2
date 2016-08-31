package com.forwardline.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class UnauthorizedException extends WebApplicationException {

	public UnauthorizedException() {
		super(Response.status(Status.UNAUTHORIZED).build());
	}

	public UnauthorizedException(String message) {
		super(Response.status(Status.UNAUTHORIZED).entity(message).type("text/json").build());
	}

}