package kohn.votesmart;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VoteSmartService {
	//http://api.votesmart.org/State.getState?key=4621bd0bc679f84d6eee42c99c643e57&stateId=NY&o=JSON
	//http://api.votesmart.org/{type}?key=<your_key>&candidateId=9490

	
	@GET("/Candidates.getByZip?/&o=JSON")
	Call<VoteSmartModel> getCandidatesbyZipCode( 
			@Query("key") String APIkey,
			@Query("zip5") String zip5,
			@Query("zip4") String zip4);
	

	@GET("/State.getStateIDs?/&o=JSON")
	Call<VoteSmartModel> getStateIDs(
			@Query("key") String APIkey);
	
	
	@GET("/Votes.getBillsByYearState?/&o=JSON")
	Call<VoteSmartModel> getBillsByState(
			@Query("key") String APIkey,
			@Query("year") String year,
			@Query("stateId") String stateId);
	
	@GET("/Votes.getBillsByStateRecent?&o=JSON")
	Call<VoteSmartModel> getRecentBills(
			@Query("key") String APIkey,
			@Query("amount") String amount);
	
	@GET("/Election.getElectionByZip?/&o=JSON")
	Call<VoteSmartModel> getElectionByZip(
			@Query("key") String APIkey,
			@Query("zip5") String zip5,
			@Query("zip4") String zip4);
}

