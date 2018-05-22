package kohn.votesmart;

import java.util.ArrayList;

import javax.swing.text.JTextComponent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoteSmartController {
	private VoteSmartView view;
	private VoteSmartService service;
	String api = "4621bd0bc679f84d6eee42c99c643e57";
	
	public VoteSmartController(VoteSmartView view, VoteSmartService service) {
		this.view = view;
		this.service = service;
	}
	
	
	private void requestVoteSmartData(Call<VoteSmartModel> call, JTextComponent data) {
		call.enqueue(new Callback<VoteSmartModel>() {

			@Override
			public void onResponse(Call<VoteSmartModel> call, Response<VoteSmartModel> response) {
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
		
		ArrayList<String>list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		feed.getStates()
			.stream()
			.forEach(e -> list.add(e.getStateProperties().getSenators()));
		for(String state: list ) {
			sb.append("\t").append(state);
		}
		System.out.println(data);
		data.setText(sb.toString());
	}
	
	public void requestStateData()
	{
		requestVoteSmartData(service.getData("State.getState", api, view.getStateID().getText()), view.getStateID());
	}
}
