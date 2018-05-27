package kohn.votesmart;

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
	return "[ State Name = " + name + "]";
}

}