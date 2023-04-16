package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.polus_plus.fast_medic.Requests.APIs.Catalog.Catalog;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
	
	ArrayList<Catalog> shoppingCartList = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_cart);
		
		
	}
}