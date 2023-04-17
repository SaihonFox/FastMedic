package com.polus_plus.fast_medic.Requests;

import com.polus_plus.fast_medic.Requests.APIs.Catalog.Catalog;
import com.polus_plus.fast_medic.Requests.APIs.Messages;
import com.polus_plus.fast_medic.Requests.APIs.OrderUser.Order;
import com.polus_plus.fast_medic.Requests.APIs.OrderUser.OrderGet;
import com.polus_plus.fast_medic.Requests.APIs.Token;
import com.polus_plus.fast_medic.Requests.APIs.User.SendCode;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.CreateProfile;
import com.polus_plus.fast_medic.Requests.APIs.News.News;
import com.polus_plus.fast_medic.Requests.APIs.OrderUser.Orders;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.UpdateProfileGet;
import com.polus_plus.fast_medic.Requests.APIs.UserProfile.UpdateProfileSend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface JSONPlaceHolderAPI {
	@POST("/api/sendCode")
	Call<SendCode> sendCode(@Header("email") String email);
	
	@POST("/api/signin")
	Call<Token> signin(@Header("email") String email, @Header("code") String code);
	
	//--------------------------------------------------------------------------
	
	@GET("/api/catalog")
	Call<List<Catalog>> getCatalog();
	
	//--------------------------------------------------------------------------
	
	@GET("/api/news")
	Call<List<News>> getNews();
	
	//--------------------------------------------------------------------------
	
	@POST("/api/createProfile")
	Call<List<CreateProfile>> createProfile(@Header("Authorization") String token, @Body CreateProfile profile);
	
	@Headers({"Accept: application/json"})
	@PUT("/api/updateProfile")
	Call<UpdateProfileGet> updateProfile(@Header("Authorization") String token, @Body UpdateProfileSend json);
	
	@POST("/api/avatar")
	Call<List<CreateProfile>> avatar(@Header("Authorization") String token, @Body CreateProfile profile);
	
	//--------------------------------------------------------------------------
	
	@POST("/api/order")
	Call<OrderGet> order(@Header("Authorization") String token, @Body Order profile);
	
	@GET("/api/orders")
	Call<List<Orders>> getOrders(@Header("Authorization") String token);
}