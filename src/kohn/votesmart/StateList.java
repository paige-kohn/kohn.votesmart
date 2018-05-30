package kohn.votesmart;

import java.util.ArrayList;


public class StateList {

	private GeneralInfo generalInfo;
	private List list;
	
	
	public StateList(List list, GeneralInfo generalInfo) {
		this.list = list;
		this.generalInfo = generalInfo;
	}

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	public List getList() {
		return list;
	}


}

	
class List
	{
		    private ArrayList<State> state;
		    
		    public List(ArrayList<State> state) {
		    	this.state = state;
		    }
		    public ArrayList<State> getState(){
		        return this.state;
		    }
		    @Override
		 public String toString() {
		    	StringBuilder sb = new StringBuilder();
		    	sb.append(this.state);
		    	return sb.toString();
		    }

	}
 class State {
		
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
			StringBuilder sb = new StringBuilder();
			sb.append("\n").append(this.stateId).append(" - ").append(this.name);
			return sb.toString();
		}
	}
	

 class GeneralInfo {
	private String title;
	private String linkBack;

	public String getTitle() {
		return title;
	}

	public String getLinkBack() {
		return linkBack;
	}
	
}
