package kohn.votesmart;

import java.util.ArrayList;

import kohn.votesmart.InternalList.State.GeneralInfo;

public class StateList {

	private GeneralInfo generalInfo;
	private InternalList list;

	public StateList(InternalList list, GeneralInfo generalInfo) {
		this.list = list;
		this.generalInfo = generalInfo;
	}

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	public InternalList getList() {
		return list;
	}

}

class InternalList {
	private ArrayList<State> state;

	public InternalList(ArrayList<State> state) {
		this.state = state;
	}

	public ArrayList<State> getState() {
		return this.state;
	}


	public class State {

		private String stateId;
		private String name;

		public String getStateId() {
			return stateId;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return
			"\n"+ stateId +" - "+ name;
		}

		public class GeneralInfo {
			private String title;
			private String linkBack;

			public String getTitle() {
				return title;
			}

			public String getLinkBack() {
				return linkBack;
			}

		}
	}
}