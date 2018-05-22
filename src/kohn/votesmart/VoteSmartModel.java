package kohn.votesmart;

import java.util.List;

public class VoteSmartModel {
	private List<VoteData> states;
	private List<VoteData> votes;
	private List<VoteData> candidates;
	private List<VoteData> district;
	private List<VoteData> election;
	
	
	public VoteSmartModel(List<VoteData> states, List<VoteData> votes, List<VoteData> candidates,
	 List<VoteData> district, List<VoteData> election) {
		this.states = states;
		this.votes= votes;
		this.candidates = candidates;
		this.district = district;
		this.election = election;
		
	}
	
	
	public List<VoteData> getStates(){
		return states;
	}
	
	public List<VoteData> getVotes(){
		return votes;
	}
	
	public List<VoteData> getCandidates(){
		return candidates;
	}
	
	public List<VoteData> getDistrict(){
		return district;
	}
	
	public List<VoteData> getElection(){
		return election;
	}
}
