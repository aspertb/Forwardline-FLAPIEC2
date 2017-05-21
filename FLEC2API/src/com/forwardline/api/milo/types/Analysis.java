package com.forwardline.api.milo.types;

public class Analysis {
	private String id;
	private boolean branchingComplete;
	private String nextStep;

	public Analysis() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isBranchingComplete() {
		return branchingComplete;
	}

	public void setBranchingComplete(boolean branchingComplete) {
		this.branchingComplete = branchingComplete;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

}
