package com.polus_plus.fast_medic.ViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.polus_plus.fast_medic.Lists.ShoppingCartList;
import com.polus_plus.fast_medic.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartListViewAdapter extends BaseAdapter {
	Context context;
	ArrayList<HashMap<String, String>> list;
	static int patientsCount = 1;
	
	public ShoppingCartListViewAdapter(Context context, ArrayList<HashMap<String, String>> list) {
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}
	
	@Override
	public Object getItem(int position) {
		return list.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
		ImageView BG = view.findViewById(R.id.bgImageView_sc);
		TextView title = view.findViewById(R.id.titleTextView_sc);
		TextView sum = view.findViewById(R.id.sumTextView_sc);
		TextView patients = view.findViewById(R.id.patientsCountTextView_sc);
		Button delete = view.findViewById(R.id.deleteButton_sc);
		
		if(position == getCount() - 1) {
			ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) BG.getLayoutParams();
			params.setMargins(0,0,0,0);
		}
		
		title.setText(list.get(position).get("title"));
		sum.setText(list.get(position).get("price") + " ₽");
		
		return view;
	}
}
