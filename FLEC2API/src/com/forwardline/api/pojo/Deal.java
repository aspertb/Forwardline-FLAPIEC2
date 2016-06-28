package com.forwardline.api.pojo;

import java.io.Serializable;

public class Deal implements Serializable {
	private float rate;
	private float approvedAmount;
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getApprovedAmount() {
		return approvedAmount;
	}
	public void setApprovedAmount(float approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
}
