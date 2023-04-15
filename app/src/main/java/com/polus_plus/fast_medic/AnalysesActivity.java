package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.polus_plus.fast_medic.Requests.APIs.OrderUser.Orders;
import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import java.util.Comparator;
import java.util.List;

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
		Call<List<Orders>> ordersCall = jsonPlaceHolderAPI.getOrders(token);
		
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
		});
	}
}