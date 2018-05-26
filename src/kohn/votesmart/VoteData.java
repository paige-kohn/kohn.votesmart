package kohn.votesmart;



public class VoteData {
	
	private String stateId;
	private String year;
	private VoteDataProperties stateProperties;
	private VoteDataProperties votesProperties;
	
	
	private CandidatesProperties candidatesProperties;

	public VoteData(String firstName, String lastName, int zip) {
	}
	

	
	public String getstateId() {
		return stateId;
	}
	public String yetYear() {
		return year;
	}
	
	public VoteDataProperties getStateProperties() {
		return stateProperties;
	}
	public VoteDataProperties getVotesProperties() {
		return votesProperties;
	}
	
	public CandidatesProperties getCandidatesProps() {
		return candidatesProperties;
	}
}
