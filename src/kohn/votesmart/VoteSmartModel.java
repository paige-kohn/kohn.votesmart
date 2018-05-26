package kohn.votesmart;



public class VoteSmartModel {

	private CandidateList candidateList;
	
	public VoteSmartModel(CandidateList candidateList) {
		this.candidateList = candidateList;	
	}

	
	public CandidateList getCandidateList() {
		return candidateList;
	}
	
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(candidateList.toString());
	return sb.toString();
}
	
	
}
