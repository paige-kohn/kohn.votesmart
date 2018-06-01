package kohn.votesmart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VoteSmartServiceTest {

	@Test
	public void testElectionsByZip() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.votesmart.org")
				.addConverterFactory(GsonConverterFactory.create()).build();
		VoteSmartService service = retrofit.create(VoteSmartService.class);
		Call<VoteSmartModel> call = service.getElectionByZip("11230", "3341");
		Response<VoteSmartModel> response = call.execute();
		assertNotNull(response.body());

		Elections election = response.body().getElections();
		assertFalse(election.getElection().toString().isEmpty());

		String name = election.getElection().getName();
		assertNotNull(name);

	}

	public void testBillsByState() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.votesmart.org")
				.addConverterFactory(GsonConverterFactory.create()).build();
		VoteSmartService service = retrofit.create(VoteSmartService.class);
		Call<VoteSmartModel> call = service.getBillsByState("2017", "NY");
		Response<VoteSmartModel> response = call.execute();
		assertNotNull(response.body());

		Bills bills = response.body().getBills();
		assertTrue(!bills.getBill().isEmpty());

		String title = bills.getBill().get(0).getTitle();
		assertNotNull(title);
	}
	
	public void testCandidatesByZip() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.votesmart.org")
				.addConverterFactory(GsonConverterFactory.create()).build();
		VoteSmartService service = retrofit.create(VoteSmartService.class);
		Call<VoteSmartModel> call = service.getCandidatesbyZipCode( "11230", "3341");
		Response<VoteSmartModel> response = call.execute();
		assertNotNull(response.body());
		
		CandidateList list = response.body().getCandidateList();
		assertFalse(list.getCandidate().isEmpty());
		
		String name = list.getCandidate().get(0).getFirstName();
		assertNotNull(name);
	}
	
	

}