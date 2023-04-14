package com.polus_plus.fast_medic.Requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
	public static Retrofit retrofit;
	
	public static Retrofit instance() {
		if(retrofit == null) {
			retrofit = new Retrofit.Builder()
					.baseUrl("https://medic.madskill.ru")
					.addConverterFactory(GsonConverterFactory.create())
					.build();
		}
		return retrofit;
	}
}