package kohn.votesmart;
import java.util.List;
import org.votesmart.*;

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
			private String electionDistrictId;

		    private String officeId;
		    private String title;
		    private String runningMateName;

		    private String nickName;

		    private String electionOfficeId;

		    private String officeStatus;

		    private String electionOfficeTypeId;

		    private String middleName;

		    private String officeDistrictName;

		    private String ballotName;

		    private String electionSpecial;

		    private String preferredName;

		    private String electionDistrictName;

		    private String suffix;

		    private String officeTypeId;

		    private String runningMateId;

		    private String electionOffice;

		    private String officeParties;

		    private String electionStateId;

		    private String electionStage;
		    public Candidate(String firstName, String lastName, String officeDistrictId, String officeStateId,
					String electionParties, String candidateId, String officeName, String electionYear,
					String electionDate, String electionStatus, String electionDistrictId, String officeId,
					String title, String runningMateName, String nickName, String electionOfficeId, String officeStatus,
					String electionOfficeTypeId, String middleName, String officeDistrictName, String ballotName,
					String electionSpecial, String preferredName, String electionDistrictName, String suffix,
					String officeTypeId, String runningMateId, String electionOffice, String officeParties,
					String electionStateId, String electionStage) {
			
				this.firstName = firstName;
				this.lastName = lastName;
				this.officeDistrictId = officeDistrictId;
				this.officeStateId = officeStateId;
				this.electionParties = electionParties;
				this.candidateId = candidateId;
				this.officeName = officeName;
				this.electionYear = electionYear;
				this.electionDate = electionDate;
				this.electionStatus = electionStatus;
				this.electionDistrictId = electionDistrictId;
				this.officeId = officeId;
				this.title = title;
				this.runningMateName = runningMateName;
				this.nickName = nickName;
				this.electionOfficeId = electionOfficeId;
				this.officeStatus = officeStatus;
				this.electionOfficeTypeId = electionOfficeTypeId;
				this.middleName = middleName;
				this.officeDistrictName = officeDistrictName;
				this.ballotName = ballotName;
				this.electionSpecial = electionSpecial;
				this.preferredName = preferredName;
				this.electionDistrictName = electionDistrictName;
				this.suffix = suffix;
				this.officeTypeId = officeTypeId;
				this.runningMateId = runningMateId;
				this.electionOffice = electionOffice;
				this.officeParties = officeParties;
				this.electionStateId = electionStateId;
				this.electionStage = electionStage;
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
			public String getElectionDistrictId() {
				return electionDistrictId;
			}

			public String getOfficeId() {
				return officeId;
			}

			public String getTitle() {
				return title;
			}

			public String getRunningMateName() {
				return runningMateName;
			}

			public String getNickName() {
				return nickName;
			}

			public String getElectionOfficeId() {
				return electionOfficeId;
			}

			public String getOfficeStatus() {
				return officeStatus;
			}

			public String getElectionOfficeTypeId() {
				return electionOfficeTypeId;
			}

			public String getMiddleName() {
				return middleName;
			}

			public String getOfficeDistrictName() {
				return officeDistrictName;
			}

			public String getBallotName() {
				return ballotName;
			}

			public String getElectionSpecial() {
				return electionSpecial;
			}

			public String getPreferredName() {
				return preferredName;
			}

			public String getElectionDistrictName() {
				return electionDistrictName;
			}

			public String getSuffix() {
				return suffix;
			}

			public String getOfficeTypeId() {
				return officeTypeId;
			}

			public String getRunningMateId() {
				return runningMateId;
			}

			public String getElectionOffice() {
				return electionOffice;
			}

			public String getOfficeParties() {
				return officeParties;
			}

			public String getElectionStateId() {
				return electionStateId;
			}

			public String getElectionStage() {
				return electionStage;
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
