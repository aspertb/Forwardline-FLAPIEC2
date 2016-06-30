package com.forwardline.salesforce.pojo;

public class SObject {
	private String Id;
	private String Name;
	private Attribute attributes;

	public SObject() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setId(String id) {
		Id = id;
	}

	public Attribute getAttributes() {
		return attributes;
	}

	public void setAttributes(Attribute attributes) {
		this.attributes = attributes;
	}

}
