package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class LoginAndRegistrationActivity extends AppCompatActivity {
	boolean buttonEnabled = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_registration);
		
		Button button = findViewById(R.id.nextButton_lar);
		EditText editText = findViewById(R.id.emailEditText_lar);
		
		button.setOnClickListener(view -> {
			if(buttonEnabled)
				startActivity(new Intent().setClass(this, EmailCodeActivity.class));
		});
		
		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String regex = "^(.+)@(.+)$";
				String text = editText.getText().toString();
				if(text.matches(regex)) {
					button.setBackgroundResource(R.drawable.rounded_button_enabled);
					buttonEnabled = true;
				}
				else {
					button.setBackgroundResource(R.drawable.rounded_button_disabled);
					buttonEnabled = false;
				}
			}
			
			@Override
			public void afterTextChanged(Editable s) {}
		});
	}
}