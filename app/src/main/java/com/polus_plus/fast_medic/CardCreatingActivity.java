package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class CardCreatingActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_creating);
		
		Bundle bundle = getIntent().getExtras();
		
		TextView skip = findViewById(R.id.skipTextView_cc);
		skip.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), AnalysesActivity.class)));
		
		Spinner spinner = findViewById(R.id.polSpinner_cc);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView text1 = view.findViewById(android.R.id.text1);
				
				text1.setPadding((int) (14 * 2.75), text1.getPaddingTop(), text1.getPaddingRight(), text1.getPaddingBottom());
				text1.setTextSize(18);
				
				if(position == getCount()) {
					((TextView) view.findViewById(android.R.id.text1)).setText("");
					((TextView) view.findViewById(android.R.id.text1)).setHint((CharSequence) getItem(getCount()));
					((TextView) view.findViewById(android.R.id.text1)).setHintTextColor(getResources().getColor(R.color.some_gray));
				}
				else
					((TextView) view.findViewById(android.R.id.text1)).setHintTextColor(getResources().getColor(R.color.black));
				
				return view;
			}
			
			@Override
			public int getCount() {
				return super.getCount() - 1;
			}
		};
		//ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pol, R.layout.spinner_dropdown_menu);
		adapter.add("Мужской");
		adapter.add("Женский");
		adapter.add("Пол");
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(adapter.getCount());
	}
	
	class MySpinnerAdapter implements SpinnerAdapter {
		@Override
		public View getDropDownView(int position, View convertView, ViewGroup parent) {
			return null;
		}
		
		@Override
		public void registerDataSetObserver(DataSetObserver observer) {
		
		}
		
		@Override
		public void unregisterDataSetObserver(DataSetObserver observer) {
		
		}
		
		@Override
		public int getCount() {
			return 0;
		}
		
		@Override
		public Object getItem(int position) {
			return null;
		}
		
		@Override
		public long getItemId(int position) {
			return 0;
		}
		
		@Override
		public boolean hasStableIds() {
			return false;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return null;
		}
		
		@Override
		public int getItemViewType(int position) {
			return 0;
		}
		
		@Override
		public int getViewTypeCount() {
			return 0;
		}
		
		@Override
		public boolean isEmpty() {
			return false;
		}
	}
}