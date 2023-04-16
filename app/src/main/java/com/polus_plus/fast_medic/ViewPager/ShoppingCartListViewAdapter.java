package com.polus_plus.fast_medic.ViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.polus_plus.fast_medic.R;
import com.polus_plus.fast_medic.ShoppingCartActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartListViewAdapter extends BaseAdapter {
	Context context;
	ArrayList<HashMap<String, String>> list;
	ShoppingCartActivity activity;
	
	int patientsCount = 1;
	//int pos;
	
	TextView patients;
	TextView sum;
	
	public ShoppingCartListViewAdapter(Context context, ArrayList<HashMap<String, String>> list, ShoppingCartActivity activity) {
		this.context = context;
		this.list = list;
		this.activity = activity;
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
		patientsCount = Integer.parseInt(list.get(position).get("patient"));
		activity.finalSum += Integer.parseInt(list.get(position).get("price"));
		activity.sum.setText(activity.finalSum + " ₽");
		
		View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
		ImageView BG = view.findViewById(R.id.bgImageView_sc);
		
		TextView title = view.findViewById(R.id.titleTextView_sc);
		sum = view.findViewById(R.id.sumTextView_sc);
		patients = view.findViewById(R.id.patientsCountTextView_sc);
		
		ImageView addPatient = view.findViewById(R.id.plusImageView_sc);
		ImageView minusPatient = view.findViewById(R.id.minusImageView_sc);
		addPatient.setOnClickListener(apView -> {
			patientsCount++;
		});
		minusPatient.setOnClickListener(mpView -> {
			if(patientsCount > 1)
				patientsCount--;
			activity.sum.setText((Integer.parseInt(list.get(position).get("price")) * patientsCount) + " ₽");
		});
		
		Button delete = view.findViewById(R.id.deleteButton_sc);
		delete.setOnClickListener(dView -> {
			list.remove(position);
			notifyDataSetChanged();
		});
		
		if(position == getCount() - 1) {
			ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) BG.getLayoutParams();
			params.setMargins(0, 0, 0, 0);
		}
		
		title.setText(list.get(position).get("title"));
		sum.setText(list.get(position).get("price") + " ₽");
		
		return view;
	}
}
