package com.polus_plus.fast_medic;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PCButtonTouchListener implements View.OnTouchListener {
	boolean isMove = false;
	
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		Button button = (Button) view;
		Context context = PasswordCreatingActivity.context;
		
		String str = "";
		switch (event.getAction()) {
			case MotionEvent.ACTION_MOVE:
				if(button.isPressed()) {
					button.setTextColor(Color.WHITE);
					isMove = false;
				}
				else {
					button.setTextColor(Color.BLACK);
					isMove = true;
				}
				break;
			case MotionEvent.ACTION_UP:
				button.setTextColor(Color.BLACK);
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
				isMove = false;
				button.setTextColor(Color.WHITE);
				break;
		}
		return false;
	}
}