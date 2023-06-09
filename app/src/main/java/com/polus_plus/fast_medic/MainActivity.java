package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		loadData();
		
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if(!Data.isLoggedIn)
					startActivity(new Intent().setClass(getApplicationContext(), OnboardActivity.class));
				else {
					if (Data.password.length() == 4 && Data.userCard == null)
						startActivity(new Intent().setClass(getApplicationContext(), CardCreatingActivity.class));
					else if(Data.userCard != null)
						startActivity(new Intent().setClass(getApplicationContext(), AnalysesActivity.class));
				}
				finish();
			}
		};
		new Timer().schedule(timerTask, 2 * 1000);
	}
	
	public void loadData() {
		SharedPreferences settings = getSharedPreferences("data", Context.MODE_PRIVATE);
		if(settings.contains("token"))
			Data.token = settings.getString("token", "");
		if(settings.contains("isLoggedIn"))
			Data.isLoggedIn = settings.getBoolean("isLoggedIn", false);
		if(settings.contains("email"))
			Data.email = settings.getString("email", "");
		if(settings.contains("password"))
			Data.password = settings.getString("password", "");
		if(settings.contains("userCard"))
			Data.userCard = settings.getStringSet("userCard", Set.of("", "", "", "", ""));
	}
}