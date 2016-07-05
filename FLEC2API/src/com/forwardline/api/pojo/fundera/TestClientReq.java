package com.forwardline.api.pojo.fundera;

import java.util.List;

import com.forwardline.salesforce.api.pojo.RequestHeader;

public class TestClientReq {
	public RequestHeader RequestHeader;
	public List<Owners> owners;
	public Company company;

	public TestClientReq(com.forwardline.salesforce.api.pojo.RequestHeader requestHeader, List<Owners> owners,
			Company company) {
		RequestHeader = requestHeader;
		this.owners = owners;
		this.company = company;
	}

	public TestClientReq() {
	}

	public RequestHeader getRequestHeader() {
		return RequestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		RequestHeader = requestHeader;
	}

	public List<Owners> getOwners() {
		return owners;
	}

	public void setOwners(List<Owners> owners) {
		this.owners = owners;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
