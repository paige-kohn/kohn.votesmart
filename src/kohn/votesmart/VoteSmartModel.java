package kohn.votesmart;



public class VoteSmartModel {

	private CandidateList candidateList;
	//private List stateList;
	
	public VoteSmartModel(CandidateList candidateList) {
		this.candidateList = candidateList;	
		
	}

	
	public CandidateList getCandidateList() {
		return candidateList;
	}
//	public List getStateList() {
//		return stateList;
//	}
//@Override
//public String toString() {
//	StringBuilder sb = new StringBuilder();
//	sb.append(candidateList.toString()).append("\n").append(stateList.toString());
//	return sb.toString();
//}
	
	
}
