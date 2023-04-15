package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PasswordCreatingActivity extends AppCompatActivity {
	public static PasswordCreatingActivity instance;
	
	public static Context context;
	public static Resources res;
	public static String password = "";
	
	ImageView dot1, dot2, dot3, dot4;
	Button
			button0, buttonDelete,
			button1, button2, button3,
			button4, button5, button6,
			button7, button8, button9;
	TextView skip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password_creating);
		
		instance = this;
		
		context = getApplicationContext();
		res = getResources();
		
		init();
		
		ButtonLogic();
	}
	
	public void init() {
		skip = findViewById(R.id.skipTextView_pc);
		
		dot1 = findViewById(R.id.dot1ImageView_pc);
		dot2 = findViewById(R.id.dot2ImageView_pc);
		dot3 = findViewById(R.id.dot3ImageView_pc);
		dot4 = findViewById(R.id.dot4ImageView_pc);
		
		buttonDelete = findViewById(R.id.ButtonDelete_pc);
		button0 = findViewById(R.id.Button0_pc);
		button1 = findViewById(R.id.Button1_pc);
		button2 = findViewById(R.id.Button2_pc);
		button3 = findViewById(R.id.Button3_pc);
		button4 = findViewById(R.id.Button4_pc);
		button5 = findViewById(R.id.Button5_pc);
		button6 = findViewById(R.id.Button6_pc);
		button7 = findViewById(R.id.Button7_pc);
		button8 = findViewById(R.id.Button8_pc);
		button9 = findViewById(R.id.Button9_pc);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	public void ButtonLogic() {
		skip.setOnClickListener(view -> {
			Intent intent = new Intent(this, CardCreatingActivity.class);
			if(password.length() == 4)
				intent.putExtra("password", password);
			else
				intent.putExtra("password", "0");
			startActivity(intent);
			finish();
		});
		
		button0.setOnTouchListener(new PCButtonTouchListener());
		button1.setOnTouchListener(new PCButtonTouchListener());
		button2.setOnTouchListener(new PCButtonTouchListener());
		button3.setOnTouchListener(new PCButtonTouchListener());
		button4.setOnTouchListener(new PCButtonTouchListener());
		button5.setOnTouchListener(new PCButtonTouchListener());
		button6.setOnTouchListener(new PCButtonTouchListener());
		button7.setOnTouchListener(new PCButtonTouchListener());
		button8.setOnTouchListener(new PCButtonTouchListener());
		button9.setOnTouchListener(new PCButtonTouchListener());
	}
	
	public void UpdateDots() {
		int passwordLength = password.length();
		
		dot1.setImageResource(R.drawable.blue_ellipse_outlined);
		dot2.setImageResource(R.drawable.blue_ellipse_outlined);
		dot3.setImageResource(R.drawable.blue_ellipse_outlined);
		dot4.setImageResource(R.drawable.blue_ellipse_outlined);
		if(passwordLength == 1)
			dot1.setImageResource(R.drawable.blue_ellipse_filled);
		if(passwordLength == 2) {
			dot1.setImageResource(R.drawable.blue_ellipse_filled);
			dot2.setImageResource(R.drawable.blue_ellipse_filled);
		} if(passwordLength == 3) {
			dot1.setImageResource(R.drawable.blue_ellipse_filled);
			dot2.setImageResource(R.drawable.blue_ellipse_filled);
			dot3.setImageResource(R.drawable.blue_ellipse_filled);
		} if(passwordLength == 4) {
			dot1.setImageResource(R.drawable.blue_ellipse_filled);
			dot2.setImageResource(R.drawable.blue_ellipse_filled);
			dot3.setImageResource(R.drawable.blue_ellipse_filled);
			dot4.setImageResource(R.drawable.blue_ellipse_filled);
			
			skip.setText("Завершить");
		}
		else
			skip.setText("Пропустить");
	}
}