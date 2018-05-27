package kohn.votesmart;



public class VoteSmartModel {

	private CandidateList candidateList;
	private StateList stateList;
	
	public VoteSmartModel(CandidateList candidateList, StateList stateList) {
		this.candidateList = candidateList;	
		this.stateList = stateList;
	}

	
	public CandidateList getCandidateList() {
		return candidateList;
	}
	public StateList getStateList() {
		return stateList;
	}
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(candidateList.toString()).append("\n").append(stateList.toString());
	return sb.toString();
}
	
	
}
