package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.polus_plus.fast_medic.Requests.APIs.User.SendCode;
import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginAndRegistrationActivity extends AppCompatActivity {
	boolean buttonEnabled = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_registration);
		
		Button button = findViewById(R.id.nextButton_lar);
		EditText editText = findViewById(R.id.emailEditText_lar);
		
		button.setOnClickListener(view -> {
			if(buttonEnabled) {
				
				SharedPreferences settings = getSharedPreferences("data", Context.MODE_PRIVATE);
				if(!settings.contains("email"))
					settings.edit().putString("email", editText.getText().toString()).apply();
				else
					settings.edit().remove("email").putString("email", editText.getText().toString()).apply();
				
				JSONPlaceHolderAPI jsonPlaceHolderAPI = RetrofitAPI.api();
				Call<SendCode> sendCodeCall = jsonPlaceHolderAPI.sendCode(editText.getText().toString());
				
				sendCodeCall.enqueue(new Callback<SendCode>() {
					@Override
					public void onResponse(Call<SendCode> call, Response<SendCode> response) {
						if(!response.isSuccessful())
							return;
						
						Toast.makeText(LoginAndRegistrationActivity.this, "Код был отправлен на вашу почту", Toast.LENGTH_SHORT).show();
						startActivity(new Intent().setClass(getApplicationContext(), EmailCodeActivity.class));
					}
					
					@Override
					public void onFailure(Call<SendCode> call, Throwable t) {
						Toast.makeText(LoginAndRegistrationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
		
		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String regex = "/^\\S+@\\S+\\.\\S+$/";
				String text = editText.getText().toString();
				
				
				if(Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
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
	
	public void sendEmailCode(String emailAddress) {
	
	}
}