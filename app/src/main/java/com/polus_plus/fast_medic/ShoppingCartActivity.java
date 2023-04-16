package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.polus_plus.fast_medic.ViewPager.ShoppingCartListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartActivity extends AppCompatActivity {
	
	ArrayList<HashMap<String, String>> list;
	public static int finalSum = 0;
	public ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_cart);
		
		listView = findViewById(R.id.cartListView_sc);
		
		Button back = findViewById(R.id.backButton_sc);
		back.setOnClickListener(view -> {
			startActivity(new Intent(this, AnalysesActivity.class));
			finish();
		});
		
		ImageView trash = findViewById(R.id.trashImageView_sc);
		trash.setOnClickListener(view -> {
			list.clear();
			((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
		});
		
		Bundle extras = getIntent().getExtras();
		list = (ArrayList<HashMap<String, String>>) extras.get("list");
		
		listView.setAdapter(new ShoppingCartListViewAdapter(this, list, this));
	}
}