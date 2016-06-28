package com.forwardline.salesforce.pojo;

import java.util.List;

public class ContactResponse {
	private int totalSize;
	private boolean done;
	private List<Contact> records;

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public List<Contact> getRecords() {
		return records;
	}

	public void setRecords(List<Contact> records) {
		this.records = records;
	}

	public ContactResponse() {
		// TODO Auto-generated constructor stub
	}

}
