package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				startActivity(new Intent().setClass(getApplicationContext(), OnboardActivity.class));
				finish();
			}
		};
		new Timer().schedule(timerTask, 2 * 1000);
	}
}