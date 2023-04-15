package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.polus_plus.fast_medic.Requests.APIs.Token;
import com.polus_plus.fast_medic.Requests.JSONPlaceHolderAPI;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailCodeActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_code);
		
		View button = findViewById(R.id.backButton_ec);
		button.setOnClickListener(view -> startActivity(new Intent(this, LoginAndRegistrationActivity.class)));
		
		EditText editText1 = findViewById(R.id.number1EditText_ec);
		EditText editText2 = findViewById(R.id.number2EditText_ec);
		EditText editText3 = findViewById(R.id.number3EditText_ec);
		EditText editText4 = findViewById(R.id.number4EditText_ec);
		
		selectNext(editText1, editText2);
		selectNext(editText2, editText3);
		selectNext(editText3, editText4);
		
		onFinal(editText1, editText2, editText3, editText4);
		onFinal(editText2, editText1, editText3, editText4);
		onFinal(editText3, editText2, editText1, editText4);
		onFinal(editText4, editText2, editText3, editText1);
		
		selectPrev(editText2, editText1);
		selectPrev(editText3, editText2);
		selectPrev(editText4, editText3);
	}
	
	public void selectNext(EditText editText1, EditText editText2) {
		editText1.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length() == 1)
					editText2.requestFocus();
			}
			
			@Override
			public void afterTextChanged(Editable s) {}
		});
	}
	
	public void selectPrev(EditText editText1, EditText editText2) {
		editText1.setOnKeyListener((view, keyCode, event) -> {
			if(editText1.getText().toString().length() != 0)
				return super.onKeyUp(keyCode, event);
			
			if(editText1.isFocused() && keyCode == KeyEvent.KEYCODE_DEL)
				editText2.requestFocus();
			
			return super.onKeyUp(keyCode, event);
		});
	}
	
	public void onFinal(EditText editText1, EditText editText2, EditText editText3, EditText editText4) {
		editText1.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(editText1.getText().toString().length() == 1) {
					editText1.clearFocus();
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
					
					if(editText1.getText().length() == 1
							&& editText2.getText().length() == 1
							&& editText3.getText().length() == 1
							&& editText4.getText().length() == 1) {
						SharedPreferences settings = getSharedPreferences("data", Context.MODE_PRIVATE);
						
						String code = editText1.getText().toString() + editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString();
						
						JSONPlaceHolderAPI jsonPlaceHolderAPI = RetrofitAPI.api();
						Call<Token> tokenCall = jsonPlaceHolderAPI.signin(settings.getString("email", ""), code);
						
						tokenCall.enqueue(new Callback<Token>() {
							@Override
							public void onResponse(Call<Token> call, Response<Token> response) {
								if(!response.isSuccessful()) {
									Toast.makeText(EmailCodeActivity.this, "Произошли некоторые ошибки", Toast.LENGTH_SHORT).show();
									return;
								}
								
								if(settings.contains("isLoggedIn"))
									settings.edit().remove("isLoggedIn").apply();
								settings.edit().putBoolean("isLoggedIn", true).apply();
								
								Toast.makeText(getApplicationContext(), "Вы успешно вошли", Toast.LENGTH_SHORT).show();
								startActivity(new Intent(getApplicationContext(), PasswordCreatingActivity.class));
							}
							
							@Override
							public void onFailure(Call<Token> call, Throwable t) {
								Toast.makeText(EmailCodeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
							}
						});
					}
				}
			}
			
			@Override
			public void afterTextChanged(Editable s) {}
		});
	}
}