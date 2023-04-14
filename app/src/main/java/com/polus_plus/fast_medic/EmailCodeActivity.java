package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmailCodeActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_code);
		
		TextView tv = findViewById(R.id.textView2);
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://medic.madskill.ru")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		JSONPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JSONPlaceHolderAPI.class);
		
		Call<List<Post>> call = jsonPlaceHolderAPI.getCatalog();
		
		call.enqueue(new Callback<List<Post>>() {
			@Override
			public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code());
					return;
				}
				
				List<Post> posts = response.body();
				
				for(Post post : posts) {
					String content = "";
					content += "ID: " + post.getId() + "\n";
					content += "Name: " + post.getName() + "\n";
					content += "Description: " + post.getDescription() + "\n";
					content += "Price: " + post.getPrice() + "\n";
					content += "Category: " + post.getCategory() + "\n";
					content += "Time result: " + post.getTime_result() + "\n";
					content += "Preparation: " + post.getPreparation() + "\n";
					content += "Bio: " + post.getBio() + "\n";
					
					tv.append(content);
				}
			}
			
			@Override
			public void onFailure(Call<List<Post>> call, Throwable t) {
				tv.setText(t.getMessage());
			}
		});
	}
}