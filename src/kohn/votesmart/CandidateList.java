package kohn.votesmart;

import java.util.List;

public class CandidateList {
	
	private GeneralInfo generalInfo;
	private List<Candidate> candidate;
	private String zipMessage;

	public CandidateList( GeneralInfo generalInfo, List<Candidate> candidate, String zipMessage) {
		this.generalInfo = generalInfo;
		this.candidate = candidate;
		this.zipMessage = zipMessage;
	}	

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	public List<Candidate> getCandidate() {
		return candidate;
	}
	
	public String getZipMessage() {
		return zipMessage;
	}

	
	

	 public class Candidate {
	        
			public String firstName;
			public String lastName;
			public String officeDistrictId;
			public String officeStateId;
			public String electionParties;
			public String candidateId;
			public String officeName;	
			public String electionYear;
			public String electionDate;
			public String electionStatus;
			
			
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
				sb.append("CANDIDATE ID: ").append(candidateId);
				sb.append("\n\t").append(lastName).append(", ").append(firstName);
				sb.append("  PARTY: ").append(electionParties);
				sb.append("\n").append(officeName).append("\tELECTION DATE: ").append(electionDate).append("\n\n");
				return sb.toString();
			}
	}
	 
	

	 
}
