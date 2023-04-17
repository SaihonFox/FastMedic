package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import static androidx.navigation.Navigation.findNavController;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.UpdateProfileSend;
import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;
import com.polus_plus.fast_medic.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class AnalysesActivity extends AppCompatActivity {
	public static ArrayList<HashMap<String, String>> list = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_analyses);
		
		BottomNavigationView bottomNavView = findViewById(R.id.bottomNavigationView_analys);
		NavController controller = findNavController(this, R.id.fragmentContainerView_analys);
		
		SharedPreferences settings = getSharedPreferences("data", Context.MODE_PRIVATE);
		String token = settings.getString("token", "");
		
		UpdateProfileSend toSend = new UpdateProfileSend("OKI", "ABOBA", "BEBRA", "6", "Tractor"); // --work
		/*toSend.setFirstname("OKI");
		toSend.setLastname("ABOBA");
		toSend.setLastname("BEBRA"); --error, doesn't work
		toSend.setBith("6");
		toSend.setPol("Tractor");*/
		
		JSONPlaceHolderAPI jsonPlaceHolderAPI = RetrofitAPI.api();
		/*Call<List<Catalog>> updateProfileGetCall = jsonPlaceHolderAPI.getCatalog();
		updateProfileGetCall.enqueue(new Callback<List<Catalog>>() {
			@Override
			public void onResponse(Call<List<Catalog>> call, Response<List<Catalog>> response) {
				if(!response.isSuccessful()) {
					if(response.code() == 403)
						Toast.makeText(AnalysesActivity.this, "Не авторизованы", Toast.LENGTH_SHORT).show();
					if(response.code() == 422)
						Toast.makeText(AnalysesActivity.this, "Ошибку возвращает сервер", Toast.LENGTH_SHORT).show();
					
					return;
				}
				
				List<Catalog> catalogs = response.body();
				catalogs.sort(Comparator.comparingInt(Catalog::getId));
				
				for(Catalog catalog : catalogs) {
					HashMap<String, String> map = new HashMap<>();
					map.put("title", catalog.getName());
					map.put("price", catalog.getPrice());
					map.put("patient", "1");
					list.add(map);
				}
				
				bottomNavigationView.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ShoppingCartActivity.class).putExtra("list", list)));
			}
			
			@Override
			public void onFailure(Call<List<Catalog>> call, Throwable t) {}
		});*/
	}
}