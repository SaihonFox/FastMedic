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
		
		JSONPlaceHolderAPI jsonPlaceHolderAPI = RetrofitAPI.api();
		
		SharedPreferences settings = getSharedPreferences("data", Context.MODE_PRIVATE);
		
		String token = settings.getString("token", "");
		
		/*JSONObject toSend = new JSONObject();
		try {
			toSend.put("firstname", "1");
			toSend.put("lastname", "1");
			toSend.put("middlename", "1");
			toSend.put("bith", 1);
			toSend.put("pol", "Мужской");
		} catch (Exception ignored) {}*/
		
		UpdateProfileSend toSend = new UpdateProfileSend();
		toSend.setFirstname("OKI");
		toSend.setLastname("ABOBA");
		toSend.setLastname("BEBRA");
		toSend.setBith("6");
		toSend.setPol("Tractor");
		
		Call<UpdateProfileGet> updateProfileGetCall = jsonPlaceHolderAPI.updateProfile(token, toSend);
		
		updateProfileGetCall.enqueue(new Callback<UpdateProfileGet>() {
			@Override
			public void onResponse(Call<UpdateProfileGet> call, Response<UpdateProfileGet> response) {
				if(!response.isSuccessful()) {
					String array = null;
					try {
						array = new JSONArray(response.body()).toString();
					} catch (JSONException e) {
						throw new RuntimeException(e);
					}
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message() + "\n" + array);
					return;
				}
				
				UpdateProfileGet profileGets = response.body();
				tv.setText(profileGets.getId());
				//profileGets.sort(Comparator.comparingInt(UpdateProfileGet::getId));
				
				//String content = "length: " + profileGets.size() + "\n";
				/*for(UpdateProfileGet profileGet : profileGets) {
					content += "ID: " + profileGet.getId() + "\n";
					content += "Name: " + profileGet.getFirstname() + "\n";
					content += "LastName: " + profileGet.getLastname() + "\n";
					content += "MiddleName: " + profileGet.getMiddlename() + "\n";
					content += "Bith: " + profileGet.getBith() + "\n";
					content += "Pol: " + profileGet.getPol() + "\n";
					content += "Image: " + profileGet.getImage() + "\n";
					
					tv.append(content);
					content = "";
				}*/
			}
			
			@Override
			public void onFailure(Call<UpdateProfileGet> call, Throwable t) {
				tv.setText(t.getMessage());
			}
		});
		
		/*Call<List<Orders>> ordersCall = jsonPlaceHolderAPI.getOrders(token);
		
		ordersCall.enqueue(new Callback<List<Orders>>() {
			@Override
			public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
				if(!response.isSuccessful()) {
					if(response.code() == 403) {
						tv.append("Не авторизованы");
					}
					return;
				}
				
				List<Orders> orders = response.body();
				orders.sort(Comparator.comparingInt(Orders::getId));
				
				
			}
			
			@Override
			public void onFailure(Call<List<Orders>> call, Throwable t) {
				tv.setText(t.getMessage());
			}
		});*/
	}
}