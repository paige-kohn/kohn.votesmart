package kohn.votesmart;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VoteSmartService {
	//http://api.votesmart.org/State.getState?key=4621bd0bc679f84d6eee42c99c643e57&stateId=NY&o=JSON
	//http://api.votesmart.org/{type}?key=<your_key>&candidateId=9490
	@GET("/{type}?/&o=JSON")
	Call<VoteSmartModel> getData(
			@Path("type") String callType, 
			@Query("key") String APIkey,
			@Query("typeID") String callTypeID);

}
