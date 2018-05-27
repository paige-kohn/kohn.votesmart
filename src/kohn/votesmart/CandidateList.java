package kohn.votesmart;

import java.util.List;

public class CandidateList {
	
	private GeneralInfo generalInfo;
	private List<Candidate> candidate;

	public CandidateList( GeneralInfo generalInfo, List<Candidate> candidate) {
		this.generalInfo = generalInfo;
		this.candidate = candidate;
	}	

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	public List<Candidate> getCandidate() {
		return candidate;
	}

	@Override
	public String toString() {
		return "\nCandidates: " + candidate + "\n";
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
				sb.append("\n[").append(firstName).append(" ").append(lastName).
				append("\t").append(officeName).append("\t").append(electionParties).
				append(", Election Date: ").append(electionDate).append("]");
				return sb.toString();
			}
	}
	 
		public class GeneralInfo {
			private String title;
			private String linkBack;
			
			

			public GeneralInfo(String title, String linkBack) {
				super();
				this.title = title;
				this.linkBack = linkBack;
			}

			public String getTitle() {
				return title;
			}

			public String getLinkBack() {
				return linkBack;
			}

			@Override
			public String toString() {
				return  title;
			}
		}
}
