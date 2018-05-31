package kohn.votesmart;



public class VoteSmartModel {

	private CandidateList candidateList;
	private StateList stateList;
	private Bills bills;
	private Elections elections;
	
	
	public VoteSmartModel(CandidateList candidateList, StateList stateList, 
			Bills bills, Elections elections) {
		this.candidateList = candidateList;	
		this.stateList = stateList;
		this.bills = bills;
		this.elections = elections;
	}

	
	public CandidateList getCandidateList() {
		return candidateList;
	}
	
	public StateList getStateList() {
		return stateList;
	}
	
	public Bills getBills() {
		return bills;
	}
	
	public Elections getElections() {
		return elections;
	}
	
}
