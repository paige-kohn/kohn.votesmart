package kohn.votesmart;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.Annotation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTest {
	public static void main(String [] args)throws IOException{
		
		getCandidatebyZipCode("&zip5=11230&zip4=3341");
		
	
	}
	public static void getCandidatebyZipCode(String zipCode) {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.votesmart.org")	
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	
		VoteSmartService service = retrofit.create(VoteSmartService.class);
		
		Call<VoteSmartModel> call = service.getCandidatesbyZipCode("4621bd0bc679f84d6eee42c99c643e57", zipCode);
		
		call.enqueue(new Callback<VoteSmartModel>() {

			@Override
			public void onResponse(Call<VoteSmartModel> call, Response<VoteSmartModel> response) {
				
				VoteSmartModel feed = response.body();
				//System.out.println(response.raw());
				
				System.out.println(feed.getCandidateList().getCandidate().get(1).getFirstName());
				
			}

			@Override
			public void onFailure(Call<VoteSmartModel> call, Throwable t) {		
				t.printStackTrace();
			}			
		});
	}
}
