package kohn.votesmart;

import org.votesmart.data.Election;

public class Elections {
	
	private String zipMessage;
	private Election election;
	private GeneralInfo generalInfo;

	private Elections(Election election) {
		this.election = election;
	}
	
	public Election getElection() {
		return election;
	}
	
	public String getZipMessage() {
		return zipMessage;
	}
	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	

	@Override
	public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("\n").append(election);
			return sb.toString();
	}
}
