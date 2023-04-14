package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import retrofit2.Retrofit;

public class EmailCodeActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_code);
		
		TextView tv = findViewById(R.id.textView2);
		
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
		
		
	}
}