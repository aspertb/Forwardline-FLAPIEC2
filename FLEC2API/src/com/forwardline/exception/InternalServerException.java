package com.forwardline.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class InternalServerException extends WebApplicationException {

	public InternalServerException() {
		super(Response.status(Status.INTERNAL_SERVER_ERROR).build());
	}

	public InternalServerException(String message) {
		super(Response.status(Status.INTERNAL_SERVER_ERROR).entity(message).type("text/json").build());
	}

}
