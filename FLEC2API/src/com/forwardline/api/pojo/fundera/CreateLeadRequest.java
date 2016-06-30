package com.forwardline.api.pojo.fundera;

import java.util.List;

public class CreateLeadRequest {
	public RequestHeader RequestHeader;
	public List<Owners> owners;
	public Company company;

	public CreateLeadRequest() {
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
