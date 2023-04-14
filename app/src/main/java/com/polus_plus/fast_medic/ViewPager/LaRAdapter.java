package com.polus_plus.fast_medic.ViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.polus_plus.fast_medic.R;

import java.util.ArrayList;
import java.util.HashMap;

public class LaRAdapter extends PagerAdapter {
	Context context;
	ArrayList<HashMap<String, Object>> list;
	
	public LaRAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		return 3;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}
	
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = LayoutInflater.from(context).inflate(R.layout.lar_viewpager, container, false);
		
		ImageView image = view.findViewById(R.id.illustrationImageView_viewPager_lar);
		image.setImageResource(Integer.parseInt(list.get(position).get("img").toString()));
		
		if(position == 0)
			image.setPadding((int) (86 * 3), 0, (int) (86 * 3), 0);
		else
			image.setPadding(0, 0, 0, 0);
		
		container.addView(view);
		return view;
	}
}