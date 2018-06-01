package kohn.votesmart;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VoteSmartService {

	static final String APIKEY = "4621bd0bc679f84d6eee42c99c643e57";
	
	@GET("/Candidates.getByZip?/&o=JSON&key=" + APIKEY)
	Call<VoteSmartModel> getCandidatesbyZipCode( 
			@Query("zip5") String zip5,
			@Query("zip4") String zip4);
	

	@GET("/State.getStateIDs?/&o=JSON&key=" + APIKEY)
	Call<VoteSmartModel> getStateIDs();
	
	
	@GET("/Votes.getBillsByYearState?/&o=JSON&key=" + APIKEY)
	Call<VoteSmartModel> getBillsByState(			
			@Query("year") String year,
			@Query("stateId") String stateId);
	
	@GET("/Votes.getBillsByStateRecent?&o=JSON&key=" + APIKEY)
	Call<VoteSmartModel> getRecentBills(
			@Query("amount") String amount);
	
	@GET("/Election.getElectionByZip?/&o=JSON&key=" + APIKEY)
	Call<VoteSmartModel> getElectionByZip(
			@Query("zip5") String zip5,
			@Query("zip4") String zip4);

	@GET("/Officials.getStatewide?/&o=JSON&key=" + APIKEY)
	Call<VoteSmartModel> getStateOfficials(
			@Query("stateId") String stateId);

}

