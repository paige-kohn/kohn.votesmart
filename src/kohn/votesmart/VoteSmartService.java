package kohn.votesmart;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VoteSmartService {
	//http://api.votesmart.org/{type}?key=<your_key>&candidateId=9490
	@GET("{type}?key={key}&{typeID}")
	Call<VoteSmartModel> getData(
			@Path("type") String callType, 
			@Path("typeID") String callTypeID,
			@Path("key") String APIkey);

}
