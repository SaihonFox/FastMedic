package com.polus_plus.fast_medic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.polus_plus.fast_medic.Requests.APIs.News.News;
import com.polus_plus.fast_medic.Requests.RetrofitAPI;

import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalysesFragment extends Fragment {
	int count = 0;
	List<News> newsList;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		newsRequests();
		
		View view = inflater.inflate(R.layout.fragment_analyses, container, false);
		
		ListView cardListView = view.findViewById(R.id.cardListView_fa);
		cardListView.setAdapter(new CardListViewAdapter());
		
		return view;
	}
	
	class CardListViewAdapter extends BaseAdapter {
		List<News> list;
		
		public CardListViewAdapter(List<News> list) {
			this.list = list;
		}
		
		@Override
		public int getCount() {
			return count;
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
				count = newsList.size();
			}
			
			@Override
			public void onFailure(Call<List<News>> call, Throwable t) {
			
			}
		});
	}
}