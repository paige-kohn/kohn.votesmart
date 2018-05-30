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
	
	
	
}	}
	
	
	public List<VoteData> getStates(){
		return states;
	}
	
	public List<VoteData> getVotes(){
		return votes;
	}
	
	public List<VoteData> getCandidates(){
		return candidates;
	}
	
	public List<VoteData> getDistrict(){
		return district;
	}
	
	public List<VoteData> getElection(){
		return election;
	}
}
