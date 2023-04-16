package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.polus_plus.fast_medic.Requests.APIs.Catalog.Catalog;
import com.polus_plus.fast_medic.ViewPager.ShoppingCartListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartActivity extends AppCompatActivity {
	
	ArrayList<Catalog> shoppingCartList = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_cart);
		
		ListView listView = findViewById(R.id.cartListView_sc);
		
		Bundle extras = getIntent().getExtras();
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>) extras.get("list");
		
		listView.setAdapter(new ShoppingCartListViewAdapter(this, list));
	}
}