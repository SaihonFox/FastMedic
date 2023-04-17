package com.polus_plus.fast_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;

public class CardCreatingActivity extends AppCompatActivity {
	EditText birthday;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_creating);
		
		birthday = findViewById(R.id.birthdayEditText_cc);
		birthday.setOnFocusChangeListener((view, hasFocus) -> {
			if(hasFocus) {
				showDialog();
				view.clearFocus();
			}
		});
		
		Bundle bundle = getIntent().getExtras();
		
		TextView skip = findViewById(R.id.skipTextView_cc);
		skip.setOnClickListener(view -> {
			startActivity(new Intent(getApplicationContext(), AnalysesActivity.class));
			finish();
		});
		
		Spinner spinner = findViewById(R.id.polSpinner_cc);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView text1 = view.findViewById(android.R.id.text1);
				
				view.setPadding((int) (14 * 2.75), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
				text1.setTextSize(18);
				
				if(position == getCount()) {
					text1.setText("");
					text1.setHint((CharSequence) getItem(getCount()));
					text1.setHintTextColor(getResources().getColor(R.color.some_gray));
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
		adapter.add("Мужской");
		adapter.add("Женский");
		adapter.add("Пол");
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(adapter.getCount());
	}
	
	public void showDialog() {
		Calendar calendar = Calendar.getInstance();
		new DatePickerDialog(getApplicationContext(), (view1, year, month, dayOfMonth) -> {
			String date = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
					.withLocale(new Locale("ru"))
					.format(LocalDate.of(year, month + 1, dayOfMonth));
			date = date.substring(0, date.length() - 3);
			birthday.setText(date);
		}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
				.show();
	}
}