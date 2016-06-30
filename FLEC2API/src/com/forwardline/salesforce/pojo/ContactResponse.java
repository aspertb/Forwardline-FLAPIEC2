package com.forwardline.salesforce.pojo;

public class ContactResponse {
	private int recordSize;
	private boolean success;
	// private List<nContact> nContact;
	private nContact nContact;

	public Integer getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(Integer totalSize) {
		this.recordSize = totalSize;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean done) {
		this.success = done;
	}

	public nContact getNContact() {
		return nContact;
	}

	public void setNContact(nContact records) {
		this.nContact = records;
	}

	public ContactResponse() {
		// TODO Auto-generated constructor stub
	}

}
