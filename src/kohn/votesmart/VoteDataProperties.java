package kohn.votesmart;

import java.sql.Date;
import java.sql.Time;

public class VoteDataProperties {

	
	private String bills;
	private String categories;
	private String stateName;
	private String senators;
	private String reps;
	private Date generalDate;
	
	
	public VoteDataProperties(String bills, String categories) {
		this.bills = bills;
		this.categories = categories;
	}

	public VoteDataProperties(String stateName, String senators,
			String reps, Date generalDate) {
		this.stateName = stateName;
		this.senators = senators;
		this.reps = reps;
		this.generalDate = generalDate;
	}
	
	public String getBills() {
		return bills;
	}
	
	public String getCategories() {
		return categories;
	}
	
	public String getStateName() {
		return stateName;		
	}
	
	public String getSenators() {
		return senators;
	}
	
	public String getReps() {
		return reps;
	}
	public Date getGeneralDate() {
		return generalDate;
	}

}
