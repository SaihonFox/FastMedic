package com.polus_plus.fast_medic.Requests;

import com.polus_plus.fast_medic.Requests.APIs.Catalog.Catalog;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.CreateProfile;
import com.polus_plus.fast_medic.Requests.APIs.News.News;
import com.polus_plus.fast_medic.Requests.APIs.OrderUser.Orders;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.UpdateProfileGet;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.UpdateProfileSend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface JSONPlaceHolderAPI {
	@POST("/api/sendCode")
	int sendCode(@Header("email") String email);
	
	@POST("/api/signin")
	int signin(String email, int code);
	
	//--------------------------------------------------------------------------
	
	@GET("/api/catalog")
	Call<List<Catalog>> getCatalog();
	
	//--------------------------------------------------------------------------
	
	@GET("/api/news")
	Call<List<News>> getNews();
	
	//--------------------------------------------------------------------------
	
	@POST("/api/createProfile")
	Call<List<CreateProfile>> createProfile(@Body CreateProfile profile);
	
	@PUT("/api/updateProfile")
	Call<UpdateProfileGet> updateProfile(@Body UpdateProfileSend updateProfile);
	
	@POST("/api/avatar")
	Call<List<CreateProfile>> avatar(@Body CreateProfile profile);
	
	//--------------------------------------------------------------------------
	
	@POST("/api/order")
	Call<List<CreateProfile>> order(@Body CreateProfile profile);
	
	@POST("/api/saveAudioComment")
	Call<List<CreateProfile>> saveAudioComment(CreateProfile profile);
	
	@GET("/api/orders")
	Call<List<Orders>> getOrders();
}