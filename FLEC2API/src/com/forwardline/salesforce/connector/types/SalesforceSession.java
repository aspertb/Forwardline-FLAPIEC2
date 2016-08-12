package com.forwardline.salesforce.connector.types;

import java.io.Serializable;

public class SalesforceSession implements Serializable {
	private String	id;
	private String	access_token;
	private String	instance_url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstance_url() {
		return instance_url;
	}

	public void setInstance_url(String instance_url) {
		this.instance_url = instance_url;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
}
