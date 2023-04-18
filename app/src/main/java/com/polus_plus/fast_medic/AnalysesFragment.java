package com.polus_plus.fast_medic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.polus_plus.fast_medic.Requests.APIs.Catalog.Catalog;
import com.polus_plus.fast_medic.Requests.APIs.News.News;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalysesFragment extends Fragment {
	int newsCount = 0;
	int catalogCount = 0;
	List<News> newsList;
	ArrayList<Catalog> catalogList = new ArrayList<>();
	
	static int selectedCategory = 0;
	
	ListView cardListView;
	LinearLayout categoriesLayout;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		newsRequests();
		catalogRequests();
		
		View view = inflater.inflate(R.layout.fragment_analyses, container, false);
		
		cardListView = view.findViewById(R.id.cardListView_fa);
		cardListView.setAdapter(new CardListViewAdapter(newsList));
		
		categoriesLayout = view.findViewById(R.id.categoriesLayout_fa);
		
		return view;
	}
	
	class CardListViewAdapter extends BaseAdapter {
		List<News> list;
		
		public CardListViewAdapter(List<News> list) {
			this.list = list;
		}
		
		@Override
		public int getCount() {
			return newsCount;
		}
		
		@Override
		public Object getItem(int position) {
			return newsList.get(position);
		}
		
		
		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = LayoutInflater.from(getContext()).inflate(R.layout.card_listview_item, parent, false);
			
			if(position == 0) {
				ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
				params.setMargins((int) (20 * 2.75), 0, 0, 0);
			}
			
			return view;
		}
	}
	
	public void newsRequests() {
		Call<List<News>> newsCall = RetrofitAPI.api().getNews();
		newsCall.enqueue(new Callback<>() {
			@Override
			public void onResponse(Call<List<News>> call, Response<List<News>> response) {
				newsList = response.body();
				newsCount = newsList.size();
			}
			
			@Override
			public void onFailure(Call<List<News>> call, Throwable t) {
			
			}
		});
	}
	
	Button button;
	
	public void catalogRequests() {
		Call<ArrayList<Catalog>> newsCall = RetrofitAPI.api().getCatalog();
		newsCall.enqueue(new Callback<>() {
			@Override
			public void onResponse(Call<ArrayList<Catalog>> call, Response<ArrayList<Catalog>> response) {
				if(!response.isSuccessful()) {
					Toast.makeText(getContext(), "Code: " + response.code() + "\nMsg: " + response.message(), Toast.LENGTH_SHORT).show();
					return;
				}
				
				catalogList = response.body();
				catalogCount = catalogList.size();
				
				ArrayList<String> catalogs = new ArrayList<>();
				for(Catalog catalog : catalogList)
					if(!catalogs.contains(catalog.getCategory()))
						catalogs.add(catalog.getCategory());
				
				FrameLayout.LayoutParams categoriesParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
				categoriesParams.setMargins((int) (12 * 2.75), 0, (int) (12 * 2.75), 0);
				categoriesLayout.setLayoutParams(categoriesParams);
				for(int i = 0; i < catalogs.size(); i++) {
					button = new Button(getContext());
					
					RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
					params.setMargins(20, 0, 20, 0);
					button.setLayoutParams(params);
					
					final int finalI = i;
					button.setOnClickListener(view -> {
						selectedCategory = finalI;
						UpdateButtonColor(finalI);
					});
					
					if(i == selectedCategory) {
						button.setBackgroundResource(R.drawable.fa_button_selected);
						button.setTextColor(getResources().getColor(R.color.green));
					} else {
						button.setBackgroundResource(R.drawable.fa_button);
						button.setTextColor(getResources().getColor(R.color.black));
					}
					
					button.setText(catalogs.get(i));
					button.setBackgroundResource(R.drawable.fa_button_selected);
					button.setPadding(8, 0, 8, 0);
					categoriesLayout.addView(button);
				}
			}
			
			@Override
			public void onFailure(Call<ArrayList<Catalog>> call, Throwable t) {
			
			}
		});
	}
	
	public void UpdateButtonColor(int i) {
		if(i == selectedCategory) {
			button.setBackgroundResource(R.drawable.fa_button_selected);
			button.setTextColor(getResources().getColor(R.color.green));
		} else {
			button.setBackgroundResource(R.drawable.fa_button);
			button.setTextColor(getResources().getColor(R.color.black));
		}
	}
}