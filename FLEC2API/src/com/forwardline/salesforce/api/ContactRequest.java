package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.Contact;
import com.forwardline.salesforce.api.pojo.RequestHeader;

public class ContactRequest {
	private Contact contact;
	private Boolean useDefaultOLAAccount;
	private RequestHeader header;

	public ContactRequest() {
		// TODO Auto-generated constructor stub
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Boolean getUseDefaultOLAAccount() {
		return useDefaultOLAAccount;
	}

	public void setUseDefaultOLAAccount(Boolean useDefaultOLAAccount) {
		this.useDefaultOLAAccount = useDefaultOLAAccount;
	}

	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header;
	}

}
