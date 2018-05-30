package kohn.votesmart;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.JTextComponent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoteSmartController {
	private VoteSmartView view;
	private VoteSmartService service;
	private String api = "4621bd0bc679f84d6eee42c99c643e57";
	
	public VoteSmartController(VoteSmartView view, VoteSmartService service) {
		this.view = view;
		this.service = service;
	}

	
	private void requestVoteSmartData(Call<VoteSmartModel> call, JTextComponent data) {
		 call.enqueue(new Callback<VoteSmartModel>() {
			@Override
			public void onResponse(Call<VoteSmartModel> call, 
					Response<VoteSmartModel> response) {
				VoteSmartModel feed = response.body();
				showData(data, feed);
			}
			@Override
			public void onFailure(Call<VoteSmartModel> call, Throwable t) {
				t.printStackTrace();
			}			
		});	
	}
	
	private void showData(JTextComponent data, VoteSmartModel feed) {
		ArrayList<String> voteSmartFeed = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
			feed.getCandidateList()
				.getCandidate()
				.stream()
				.forEach(e -> voteSmartFeed.add(e.toString()));
			int size = voteSmartFeed.size();
			for(int i =0; i<size; i++) {
				sb.append("\n").append(voteSmartFeed.get(i));
			}
		data.setText(sb.toString());
	}
	
	public void requestCandidateData()
	{
		requestVoteSmartData(service.getCandidatesbyZipCode(api, view.getZip5(), view.getZip4()), view.getCandidatebyZip());
	}
}
