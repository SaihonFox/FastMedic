package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.polus_plus.fast_medic.Requests.APIs.User.SendCode;
import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EmailCodeActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_code);
		
		View button = findViewById(R.id.backButton_ec);
		button.setOnClickListener(view -> startActivity(new Intent(this, PasswordCreatingActivity.class)));
		
		TextView tv = new TextView(this);
		
		Retrofit retrofit = RetrofitAPI.instance();
		
		JSONPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JSONPlaceHolderAPI.class);
		
		/*Call<List<Orders>> ordersCall = jsonPlaceHolderAPI.getOrders();
		
		ordersCall.enqueue(new Callback<List<Orders>>() {
			@Override
			public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
				if(!response.isSuccessful()) {
					try{tv.setText("Code: " + response.code() + " " + response.errorBody().string());}
					catch (Exception e) {tv.setText(e.getLocalizedMessage());}
					return;
				}
				
				List<Orders> ordersPosts = response.body();
				ordersPosts.sort(Comparator.comparingInt(Orders::getId));
				
				String content = "";
				for(Orders orders : ordersPosts) {
					content += "ID: " + orders.getId() + "\n";
					content += "Order ID: " + orders.getOrder_id() + "\n";
					content += "Catalog ID: " + orders.getCatalog_id() + "\n";
					content += "Patient ID: " + orders.getPatient_id() + "\n";
					content += "Created at: " + orders.getCreated_at() + "\n";
					content += "Created at: " + orders.getCreated_at() + "\n";
					content += "Updated at: " + orders.getUpdated_at() + "\n";
					content += "Price at: " + orders.getPrice() + "\n";
					content += "-----Patient-----" + "\n";
					content += "PatientID: " + orders.getPatient().getId() + "\n";
					content += "PatientName: " + orders.getPatient().getName() + "\n";
					content += "PatientCreated at: " + orders.getPatient().getCreated_at() + "\n";
					content += "PatientUpdated at: " + orders.getPatient().getUpdated_at() + "\n";
					content += "-----Order-----" + "\n";
					content += "OrderID: " + orders.getOrder().getId() + "\n";
					content += "OrderAddress: " + orders.getOrder().getAddress() + "\n";
					content += "OrderCreated at: " + orders.getOrder().getCreated_at() + "\n";
					content += "OrderUpdated at: " + orders.getOrder().getUpdated_at() + "\n";
					content += "OrderDateTime: " + orders.getOrder().getDate_time() + "\n";
					content += "OrderPhone: " + orders.getOrder().getPhone() + "\n";
					content += "OrderComment: " + orders.getOrder().getComment() + "\n";
					content += "OrderAudioComment: " + orders.getOrder().getAudio_comment() + "\n";
					content += "-----Item-----" + "\n";
					content += "ItemID: " + orders.getItem().getId() + "\n";
					content += "ItemName: " + orders.getItem().getName() + "\n";
					content += "ItemCategory: " + orders.getItem().getCategory() + "\n";
					content += "ItemPrice: " + orders.getItem().getPrice() + "\n";
					content += "ItemBio: " + orders.getItem().getBio() + "\n";
					content += "ItemUpdated at: " + orders.getItem().getUpdated_at() + "\n";
					content += "ItemPreparation: " + orders.getItem().getPreparation() + "\n";
					content += "ItemTime result: " + orders.getItem().getTime_result() + "\n";
					content += "ItemCreated at: " + orders.getItem().getCreated_at() + "\n";
					content += "ItemDescription: " + orders.getItem().getDescription() + "\n\n\n";
					
					tv.append(content);
					content = "";
				}
			}
			
			@Override
			public void onFailure(Call<List<Orders>> call, Throwable t) {
				tv.setText(t.getMessage());
			}
		});*/
		
		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzIiwianRpIjoiOTBmNzExODFmODZhZWJjNWM1ZTllNTllNGE5NjFhNTg3NDkyMjcxYWY3NWU5MTNlYTBkODc0ZGQxOTdmMGM2MzUzYTE2YjU1OTY5NTM5MzciLCJpYXQiOjE2ODE0ODg1MjguOTgyMywibmJmIjoxNjgxNDg4NTI4Ljk4MjMwNiwiZXhwIjoxNzEzMTEwOTI4Ljk3NzQ4NSwic3ViIjoiOTQzIiwic2NvcGVzIjpbXX0.n8_HrY1jEKH6WG8zGgChaDwfj9d-qJxDGcXWffHpLtuONiqzkRMZ0EUIlIwv427OF-WuxH8Dm5j3R3Xv3EvM2Ddiyh3OYFcYAy2kwjXEyqHVIaKso2SApWZWf4cFcA4cOa4YG1Nx_ycXz1E9vEz8CCHw_5pJaQGGiXrb0iWfA6EF9zZuDUXwxkoIplK90VmYma5FEtR-8-o3CXspnuAGc3XNUza7JClaBBV8Rnx8GU574j02RRAGBqWAHkUGM5mxYy8Ed5xeuuzhqLoyr01yrLVQQCoKekFzFoKoftoc6vAATeqZyrGAP2JKNGU-5M-Foq1hq9rN4nsCY5G_vb9QMNOY8XKruDSODmKNCJNSo4U3Ox60TkBY-lKWnLJabqhBhEV5VIAxO4B8ibExFFDHut37wT2NwVH3qX00TGcUhUdWvbc3Pt9YQDh3QfCqsoAimleT-bpY9TZ39FO7bBQQ56CdR-Q-q7d_XTIso_DuueXW7yyqIbMssg9ueNcHj8VqwVNe40HzzZWd2_4qLpo3Dru75vyzQWXGDUHu4OIw4vzpd1p1b-uZUhgMFVaVH_vJNX9ykYoVuW6qE-1DROVguMZHKvbHXOeydRk5N5icMdTnpj-MF7d31O3eoa15TS3thO4ABIKFaWiTnU-WhTMHo6Rz5k6azanUClEZfxtu_NM";
		
		Call<SendCode> sendCodeCall = jsonPlaceHolderAPI.sendCode("jemkaplayed@gmail.com");
		
		sendCodeCall.enqueue(new Callback<SendCode>() {
			@Override
			public void onResponse(Call<SendCode> call, Response<SendCode> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + ",\n:Message " + response.message());
					return;
				}
				
				SendCode code = response.body();
				tv.setText("Message:"  + code.getMessage() + ",\nError: " + code.getError());
			}
			
			@Override
			public void onFailure(Call<SendCode> call, Throwable t) {
				tv.setText(t.getMessage());
			}
		});
	}
}