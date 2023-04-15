package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.TextView;

import com.polus_plus.fast_medic.Requests.APIs.OrderUser.Orders;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.UpdateProfileGet;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.UpdateProfileSend;
import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalysesActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analyses);
		
		TextView tv = findViewById(R.id.textView2_analys);
		
		SharedPreferences settings = getSharedPreferences("data", Context.MODE_PRIVATE);
		
		String token = settings.getString("token", "");
		
		UpdateProfileSend toSend = new UpdateProfileSend("OKI", "ABOBA", "BEBRA", "6", "Tractor"); // --work
		/*toSend.setFirstname("OKI");
		toSend.setLastname("ABOBA");
		toSend.setLastname("BEBRA"); --error, doesn't work
		toSend.setBith("6");
		toSend.setPol("Tractor");*/
		
		JSONPlaceHolderAPI jsonPlaceHolderAPI = RetrofitAPI.api();
		Call<UpdateProfileGet> updateProfileGetCall = jsonPlaceHolderAPI.updateProfile(token, toSend);
		
		updateProfileGetCall.enqueue(new Callback<UpdateProfileGet>() {
			@Override
			public void onResponse(Call<UpdateProfileGet> call, Response<UpdateProfileGet> response) {
				if(!response.isSuccessful()) {
					String array = "null";
					try {
						array = new JSONArray(response.body()).length() + "";
					} catch (JSONException e) {
						throw new RuntimeException(e);
					}
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message() + "\n" + array);
					return;
				}
				
				UpdateProfileGet profileGet = response.body();
				tv.append("ID: " + profileGet.getId() + "\n");
				tv.append("FirstName: " + profileGet.getFirstname() + "\n");
				tv.append("LastName: " + profileGet.getLastname() + "\n");
				tv.append("MiddleName: " + profileGet.getMiddlename() + "\n");
				tv.append("Pol: " + profileGet.getPol() + "\n");
				tv.append("Bith: " + profileGet.getBith() + "\n");
				tv.append("Image: " + profileGet.getImage() + "\n");
			}
			
			@Override
			public void onFailure(Call<UpdateProfileGet> call, Throwable t) {
				tv.setText(t.getMessage());
			}
		});
	}
}