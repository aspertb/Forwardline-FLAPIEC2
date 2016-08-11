package com.forwardline.salesforce.api.pojo;

public class Analysis {

	private String id;
	private String name;
	private String forsightScore;
	private Boolean branchingComplete;
	private String nextStep;
	private String currentReportType;
	private Integer consumerIndex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForsightScore() {
		return forsightScore;
	}

	public void setForsightScore(String forsightScore) {
		this.forsightScore = forsightScore;
	}

	public Boolean getBranchingComplete() {
		return branchingComplete;
	}

	public void setBranchingComplete(Boolean branchingComplete) {
		this.branchingComplete = branchingComplete;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getCurrentReportType() {
		return currentReportType;
	}

	public void setCurrentReportType(String currentReportType) {
		this.currentReportType = currentReportType;
	}

	public Integer getConsumerIndex() {
		return consumerIndex;
	}

	public void setConsumerIndex(Integer consumerIndex) {
		this.consumerIndex = consumerIndex;
	}

}
