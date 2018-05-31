package kohn.votesmart;

import java.util.ArrayList;

public class Elections {

	private String zipMessage;
	private ArrayList<Election> election;
	private GeneralInfo generalInfo;

	public Elections(ArrayList<Election> election) {
		this.election = election;
	}

	public ArrayList<Election> getElection() {
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

	public class Election {
		private String electionYear;
		private String stateId;
		private String name;
		private String electionId;
		private String special;
		private Stage stage;

		public Election(String electionYear, String stateId, String name, 
				String electionId, String special, Stage stage) {
			this.electionYear = electionYear;
			this.stateId = stateId;
			this.name = name;
			this.electionId = electionId;
			this.special = special;
			this.stage = stage;
		}

		public String getElectionYear() {
			return electionYear;
		}

		public String getStateId() {
			return stateId;
		}

		public String getName() {
			return name;
		}

		public String getElectionId() {
			return electionId;
		}

		public String getSpecial() {
			return special;
		}
		public Stage getStage() {
			return stage;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("\n").append(name).append(" ").append(electionId);
			sb.append("\n").append(stage);
			return sb.toString();
		}
	}

	public class Stage {

		private String stageId;
		private String electionElectionstageId;
		private String name;
		private String stateId;
		private String electionDate;

		public Stage(String stageId, String electionElectionstageId, String name, String stateId, String electionDate,
				String filingDeadline, String npatMailed) {
			this.stageId = stageId;
			this.electionElectionstageId = electionElectionstageId;
			this.name = name;
			this.stateId = stateId;
			this.electionDate = electionDate;

		}

		public String getStageId() {
			return stageId;
		}

		public String getElectionElectionstageId() {
			return electionElectionstageId;
		}

		public String getName() {
			return name;
		}

		public String getStateId() {
			return stateId;
		}

		public String getElectionDate() {
			return electionDate;
		}

		@Override
		public String toString() {
			return "Stage [stageId=" + stageId + ", electionElectionstageId=" + electionElectionstageId + ", name="
					+ name + ", stateId=" + stateId + ", electionDate=" + electionDate + "]";
		}

	}

}
