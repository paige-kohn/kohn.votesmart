package kohn.votesmart;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VoteSmartService {

	
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

	@GET("/Officials.getStatewide?/&o=JSON")
	Call<VoteSmartModel> getStateOfficials(
			@Query("key") String APIkey,
			@Query("stateId") String stateId);

}

