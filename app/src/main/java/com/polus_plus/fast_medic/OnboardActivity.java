package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.polus_plus.fast_medic.ViewPager.LaRAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class OnboardActivity extends AppCompatActivity {
	ArrayList<HashMap<String, Object>> list = new ArrayList<>(3);
	boolean isLastPage = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_onboard);
		
		{
			HashMap<String, Object> item = new HashMap<>(3);
			item.put("titleText", "Анализы");
			item.put("descText", "Экспресс сбор и получение проб");
			item.put("img", R.drawable.illustration_1);
			list.add(item);
		}
		{
			HashMap<String, Object> item = new HashMap<>(3);
			item.put("titleText", "Уведомления");
			item.put("descText", "Вы быстро узнаете о результатах");
			item.put("img", R.drawable.illustration_2);
			list.add(item);
		}
		{
			HashMap<String, Object> item = new HashMap<>(3);
			item.put("titleText", "Мониторинг");
			item.put("descText", "Наши врачи всегда наблюдают \n" +
					"за вашими показателями здоровья");
			item.put("img", R.drawable.illustration_3);
			list.add(item);
		}
		
		ImageView dot1 = findViewById(R.id.dot1ImageView_Ob);
		ImageView dot2 = findViewById(R.id.dot2ImageView_Ob);
		ImageView dot3 = findViewById(R.id.dot3ImageView_Ob);
		
		TextView titleTextView = findViewById(R.id.titleTextView_Ob);
		TextView descTextView = findViewById(R.id.descTextView_Ob);
		
		TextView skipTextView = findViewById(R.id.skipTextView_Ob);
		
		ViewPager viewPager = findViewById(R.id.viewPager_Ob);
		viewPager.setAdapter(new LaRAdapter(this, list));
		
		skipTextView.setOnClickListener(view -> {
			if(isLastPage) {
				startActivity(new Intent().setClass(this, PasswordCreatingActivity.class));
				finish();
			} else
				viewPager.setCurrentItem(2, true);
		});
		
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				isLastPage = position == 2;
				
				boolean moreThanHalf = positionOffset >= 0.5;
				if(moreThanHalf) {
					dot1.setImageResource(R.drawable.blue_ellipse_outlined);
					if(position == 0) {
						dot2.setImageResource(R.drawable.blue_ellipse_filled);
						
						titleTextView.setText(list.get(position + 1).get("titleText").toString());
						descTextView.setText(list.get(position + 1).get("descText").toString());
					} else if(position == 1) {
						dot2.setImageResource(R.drawable.blue_ellipse_outlined);
						dot3.setImageResource(R.drawable.blue_ellipse_filled);
						
						skipTextView.setText("Завершить");
						
						titleTextView.setText(list.get(position + 1).get("titleText").toString());
						descTextView.setText(list.get(position + 1).get("descText").toString());
					}
				} else {
					dot2.setImageResource(R.drawable.blue_ellipse_outlined);
					if(position == 0) {
						dot1.setImageResource(R.drawable.blue_ellipse_filled);
						
						titleTextView.setText(list.get(position).get("titleText").toString());
						descTextView.setText(list.get(position).get("descText").toString());
					} else if(position == 1) {
						dot2.setImageResource(R.drawable.blue_ellipse_filled);
						dot3.setImageResource(R.drawable.blue_ellipse_outlined);
						
						skipTextView.setText("Пропустить");
						
						titleTextView.setText(list.get(position).get("titleText").toString());
						descTextView.setText(list.get(position).get("descText").toString());
					}
				}
			}
			
			@Override
			public void onPageSelected(int position) {}
			
			@Override
			public void onPageScrollStateChanged(int state) {}
		});
	}
}