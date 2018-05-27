package kohn.votesmart;

public class Candidate {

	private String firstName;
	private String lastName;
	private String officeDistrictId;
	private String officeStateId;
	private String electionParties;
	private String candidateId;
	private String officeName;	
	private String electionYear;
	private String electionDate;
	private String electionStatus;

	public Candidate(String officeDistrictId, String officeStateId, String electionParties, String candidateId, 
			String officeName, String firstName,String lastName, String electionYear,  
			String electionDate, String electionStatus) {

		this.officeDistrictId = officeDistrictId;
		this.officeStateId = officeStateId;
		this.electionParties = electionParties;
		this.candidateId = candidateId;
		this.officeName = officeName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.electionYear = electionYear;
		this.electionDate = electionDate;
		this.electionStatus = electionStatus;
	}

	

	public String getOfficeDistrictId() {
		return officeDistrictId;
	}

	public String getOfficeStateId() {
		return officeStateId;
	}

	public String getElectionParties() {
		return electionParties;
	}


	public String getCandidateId() {
		return candidateId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getElectionYear() {
		return electionYear;
	}

	public String getElectionDate() {
		return electionDate;
	}

	public String getElectionStatus() {
		return electionStatus;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[").append(firstName).append(" ").append(lastName).append(", election Date: ").append(electionDate);
		sb.append("\n").append(officeName).append("\t").append(electionParties).append("]");
		return sb.toString();
	}
}
