package kohn.votesmart;


public class CandidatesProperties {
	private int candidateId;
	
	private String firstName;
	private String lastName;
	private String electionParties;
	private String electionDistrictId;
	private String electionOffice;
	private String electionStateId;
	private String generalInfo;
	private Candidate candidateList;
	
	public CandidatesProperties(Candidate candidateList) {
		this.candidateList = candidateList;
	}
	
	
	public CandidatesProperties(String generalInfo, String firstName, String lastName, String electionParties,
			String electionDistrictId, String electionOffice, String electionStateId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.electionParties = electionParties;
		this.electionDistrictId = electionDistrictId;
		this.electionOffice = electionOffice;
		this.electionStateId = electionStateId;
		this.generalInfo = generalInfo;
	}

	public String getGeneralInfo() {
		return generalInfo;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public Candidate getCandidateList(){
		return candidateList;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getElectionParties() {
		return electionParties;
	}


	public String getElectionDistrictId() {
		return electionDistrictId;
	}


	public String getElectionOffice() {
		return electionOffice;
	}


	public String getElectionStateId() {
		return electionStateId;
	}
	
	 
	
	
}
