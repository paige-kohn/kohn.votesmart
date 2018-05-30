package kohn.votesmart;



public class VoteSmartModel {

	private CandidateList candidateList;
	private StateList stateList;
	private Bills bills;
	
	
	public VoteSmartModel(CandidateList candidateList, StateList stateList, Bills bills) {
		this.candidateList = candidateList;	
		this.stateList = stateList;
		this.bills = bills;
	}

	
	public CandidateList getCandidateList() {
		return candidateList;
	}
	
	public StateList getStateList() {
		return stateList;
	}
	
	public Bills getBills() {
		return this.bills;
	}
	
	
	
}
