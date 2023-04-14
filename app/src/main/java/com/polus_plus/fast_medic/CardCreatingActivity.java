package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CardCreatingActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_creating);
		
		Bundle bundle = getIntent().getExtras();
		
		TextView skip = findViewById(R.id.skipTextView_cc);
		skip.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), AnalysesActivity.class)));
	}
}