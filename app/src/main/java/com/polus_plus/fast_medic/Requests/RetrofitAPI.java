package com.polus_plus.fast_medic.Requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
	public static Retrofit retrofit;
	public static String url = "https://medic.madskill.ru";
	
	public RetrofitAPI() {
	
	}
	
	public static Retrofit instance() {
		if(retrofit == null)
			retrofit = new Retrofit.Builder()
					.baseUrl(url)
					.addConverterFactory(GsonConverterFactory.create())
					.build();
		return retrofit;
	}
	
	public static JSONPlaceHolderAPI api() {
		return instance().create(JSONPlaceHolderAPI.class);
	}
}