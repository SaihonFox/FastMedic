package com.polus_plus.fast_medic.Requests;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderAPI {
	@GET("api/catalog")
	Call<List<Post>> getCatalog();
}