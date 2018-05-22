package kohn.votesmart;

import java.sql.Date;

public class VoteData {
	private String stateId;
	private String year;
	private VoteDataProperties stateProperties;
	private VoteDataProperties votesProperties;

	
	public VoteData(String bills, String categories) {
		votesProperties = new VoteDataProperties(bills, categories);
	}
	
	
	public VoteData(String stateName, String senators,
			String reps, Date generalDate) {
		stateProperties = new VoteDataProperties(stateName, senators, reps, generalDate);	
	}
	
	public String getstateId() {
		return stateId;
	}
	public String yetYear() {
		return year;
	}
	
	public VoteDataProperties getStateProperties() {
		return stateProperties;
	}
	public VoteDataProperties getVotesProperties() {
		return votesProperties;
	}
}
