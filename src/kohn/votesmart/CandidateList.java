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
	
	
	
	public class GeneralInfo {
		private String title;
		private String linkBack;
		
		

		public GeneralInfo(String title, String linkBack) {
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
