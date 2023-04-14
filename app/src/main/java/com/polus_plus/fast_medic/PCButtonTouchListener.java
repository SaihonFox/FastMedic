package com.polus_plus.fast_medic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PCButtonTouchListener implements View.OnTouchListener {
	boolean outOfCorners = false;
	boolean isMove = false;
	
	@SuppressLint("SetTextI18n")
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		Button button = (Button) view;
		Context context = PasswordCreatingActivity.context;
		
		String str = "";
		switch (event.getAction()) {
			case MotionEvent.ACTION_MOVE:
				/*TextView tv = (TextView) PasswordCreatingActivity.instance.findViewById(R.id.textView);
				double XCoord = Math.sin(Math.toRadians(event.getX() - (float) view.getWidth() / 2 * 0));
				double YCoord = Math.sin(Math.toRadians(event.getY() - (float) view.getHeight() / 2 * 0));
				
				tv.setText(XCoord + "|" + YCoord);
				
				outOfCorners = !(Math.abs(XCoord) < 110 || Math.abs(YCoord) < 110);
				
				if(outOfCorners) {
					button.setTextColor(Color.BLACK);
					button.setBackgroundResource(R.drawable.big_gray_ellipse_filled);
				} else {
					button.setTextColor(Color.WHITE);
					button.setBackgroundResource(R.drawable.big_blue_ellipse_filled);
				}*/
				isMove = true;
				break;
			case MotionEvent.ACTION_UP:
				button.setTextColor(Color.BLACK);
				button.setBackgroundResource(R.drawable.big_gray_ellipse_filled);
				if(!isMove) {
					char buttonChar = PasswordCreatingActivity.res.getResourceEntryName(view.getId()).charAt(6);
					if(buttonChar != 'D')
						if(PasswordCreatingActivity.password.length() < 4)
							PasswordCreatingActivity.password += buttonChar;
					else
						PasswordCreatingActivity.password = PasswordCreatingActivity.password.substring(0, PasswordCreatingActivity.password.length() - 1);
					
					isMove = false;
				}
				PasswordCreatingActivity.instance.UpdateDots();
				break;
			case MotionEvent.ACTION_DOWN:
				button.setTextColor(Color.WHITE);
				button.setBackgroundResource(R.drawable.big_blue_ellipse_filled);
				break;
		}
		return false;
	}
	
	/*@Override
	public boolean onTouch(View view, MotionEvent event) {
		Button button = (Button) view;
		
		Context context = PasswordCreatingActivity.context;
		
		int action = event.getAction();
		switch (action) {
			case MotionEvent.ACTION_DOWN:
				Toast.makeText(context, "DOWN", Toast.LENGTH_SHORT).show();
				*//*button.setTextColor(Color.WHITE);
				button.setBackgroundResource(R.drawable.big_blue_ellipse_filled);*//*
				*//*button.setTextColor(Color.WHITE);
				button.setBackgroundResource(R.drawable.big_blue_ellipse_filled);
				String num = PasswordCreatingActivity.res.getResourceEntryName(view.getId()).substring(6, 7);
				Toast.makeText(PasswordCreatingActivity.context, num, Toast.LENGTH_SHORT).show();
				TimerTask timerTask = new TimerTask() {
					@Override
					public void run() {
						button.setTextColor(Color.BLACK);
						view.setBackgroundResource(R.drawable.big_gray_ellipse_filled);
					}
				};
				new Timer().schedule(timerTask, 25);*//*
				break;
			case MotionEvent.ACTION_HOVER_ENTER:
				Toast.makeText(context, "ENTER", Toast.LENGTH_SHORT).show();
				*//*button.setTextColor(Color.BLACK);
				button.setBackgroundResource(R.drawable.big_gray_ellipse_filled);*//*
				break;
			case MotionEvent.ACTION_HOVER_EXIT:
				Toast.makeText(context, "EXIT", Toast.LENGTH_SHORT).show();
				break;
			case MotionEvent.ACTION_UP:
				Toast.makeText(context, "UP", Toast.LENGTH_SHORT).show();
				Outline outline = new Outline();
				outline.setOval(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
				Rect rect = new Rect();
				outline.setRect(rect);
				Toast.makeText(context, rect.top + "" + rect.right, Toast.LENGTH_SHORT).show();
				*//*if(PasswordCreatingActivity.res.getResourceEntryName(view.getId()).charAt(6) != 'D')
					if(PasswordCreatingActivity.password.length() < 4)
						PasswordCreatingActivity.password += PasswordCreatingActivity.res.getResourceEntryName(view.getId()).charAt(6);
				else
					PasswordCreatingActivity.password = PasswordCreatingActivity.password.substring(0, PasswordCreatingActivity.password.length() - 1);
				PasswordCreatingActivity.instance.UpdateDots();*//*
				break;
		}
		return false;
	}*/
}