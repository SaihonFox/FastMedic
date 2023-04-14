package com.polus_plus.fast_medic.Requests;

import com.polus_plus.fast_medic.Requests.APIs.Catalog.Catalog;
import com.polus_plus.fast_medic.Requests.APIs.Messages;
import com.polus_plus.fast_medic.Requests.APIs.User.SendCode;
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
	Call<SendCode> sendCode(@Header("email") String email);
	
	@POST("/api/signin")
	int signin(@Header("email") String email, @Header("code") String code);
	
	//--------------------------------------------------------------------------
	
	@GET("/api/catalog")
	Call<List<Catalog>> getCatalog();
	
	//--------------------------------------------------------------------------
	
	@GET("/api/news")
	Call<List<News>> getNews();
	
	//--------------------------------------------------------------------------
	
	@POST("/api/createProfile")
	Call<List<CreateProfile>> createProfile(@Header("Authorization") String token, @Body CreateProfile profile);
	
	@PUT("/api/updateProfile")
	Call<UpdateProfileGet> updateProfile(@Header("Authorization") String token, @Body UpdateProfileSend updateProfile);
	
	@POST("/api/avatar")
	Call<List<CreateProfile>> avatar(@Header("Authorization") String token, @Body CreateProfile profile);
	
	//--------------------------------------------------------------------------
	
	@POST("/api/order")
	Call<List<CreateProfile>> order(@Header("Authorization") String token, @Body CreateProfile profile);
	
	@POST("/api/saveAudioComment")
	Call<List<CreateProfile>> saveAudioComment(@Header("Authorization") String token, CreateProfile profile);
	
	@GET("/api/orders")
	Call<List<Orders>> getOrders(@Header("Authorization") String token);
}