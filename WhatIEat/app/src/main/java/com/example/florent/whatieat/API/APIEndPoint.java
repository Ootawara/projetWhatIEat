package com.example.florent.whatieat.API;

import com.example.florent.whatieat.Model.Food;
import com.example.florent.whatieat.Model.FoodWS;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Florent on 04/02/2016.
 */
public interface APIEndPoint {

    @POST("/food/")
    Call<Void> createFood(@Body FoodWS f);
    @GET("/food")
    Call<List<Food>> listFoods();
    @GET("/food/{name}")
    Call<FoodWS> food(@Path("name") String name);
}
