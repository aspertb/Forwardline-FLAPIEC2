package com.forwardline.api.fundera.pojo;

import java.util.List;

public class FunderaRequest {
	public RequestHeader RequestHeader;
	public List<Person> owners;
	public Company company;

	public FunderaRequest() {
		// TODO Auto-generated constructor stub
	}

	public RequestHeader getRequestHeader() {
		return RequestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		RequestHeader = requestHeader;
	}

	public List<Person> getOwners() {
		return owners;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
