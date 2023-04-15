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
						tv.append("Не авторизованы: " + settings.getString("token", "non"));
					}
					return;
				}
				
				List<Orders> orders = response.body();
				orders.sort(Comparator.comparingInt(Orders::getId));
				
				String content = "";
				for(Orders order : orders) {
					content += "ID: " + order.getId();
					content += "OrderID: " + order.getOrder_id();
					content += "PatientID: " + order.getPatient_id();
					content += "CatalogID: " + order.getCatalog_id();
					content += "Created at: " + order.getCreated_at();
					content += "Updated at: " + order.getUpdated_at();
					content += "Price: " + order.getPrice();
					content += "-----Patient-----";
					content += "Patient ID: " + order.getPatient().getId();
					content += "Patient Name: " + order.getPatient().getName();
					content += "Patient Created at: " + order.getPatient().getCreated_at();
					content += "Patient Updated at: " + order.getPatient().getUpdated_at();
					content += "-----Item-----";
					content += "Item ID: " + order.getItem().getId();
					content += "Item Name: " + order.getItem().getName();
					content += "Item Bio: " + order.getItem().getBio();
					content += "Item Preparation: " + order.getItem().getPreparation();
					content += "Item Description: " + order.getItem().getDescription();
					content += "Item Time result: " + order.getItem().getTime_result();
					content += "Item Price: " + order.getItem().getPrice();
					content += "Item Category: " + order.getItem().getCategory();
					content += "-----Order-----";
					content += "Order ID: " + order.getOrder().getId();
					content += "Order Address: " + order.getOrder().getAddress();
					content += "Order Comment: " + order.getOrder().getComment();
					content += "Order Audio Comment: " + order.getOrder().getAudio_comment();
					content += "Order Created at: " + order.getOrder().getCreated_at();
					content += "Order Updated at: " + order.getOrder().getUpdated_at();
					content += "Order Phone: " + order.getOrder().getPhone();
					content += "Order Date time: " + order.getOrder().getDate_time();
					
					tv.append(content);
					content = "";
				}
			}
			
			@Override
			public void onFailure(Call<List<Orders>> call, Throwable t) {
				tv.setText(t.getMessage());
			}
		});
	}
}