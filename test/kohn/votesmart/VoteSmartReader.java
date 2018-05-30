package kohn.votesmart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VoteSmartReader {
	public static void main(String [] args) throws FileNotFoundException {
		
		
		Gson gson = new GsonBuilder()				
				.setLenient()
				.create();	
		
 			BufferedReader in;
			in = new BufferedReader(
					new FileReader(new File("src/kohn/votesmart/Candidates.getByZip.json")));
		
		 VoteSmartModel feed = gson.fromJson(in, VoteSmartModel.class);
		   System.out.println(feed.getCandidateList().getCandidate().get(1).getLastName());
	}
}
