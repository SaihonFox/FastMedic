package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardCreatingActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_creating);
		
		Bundle bundle = getIntent().getExtras();
		
		TextView skip = findViewById(R.id.skipTextView_cc);
		skip.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), AnalysesActivity.class)));
		
		AutoCompleteTextView autoCompleteTextView = findViewById(R.id.polAutoCompleteTextView_сс);
		List<String> list = new ArrayList<>();
		list.add("Мужской");
		list.add("Женский");
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, list);
		autoCompleteTextView.setAdapter(adapter);
	}
}