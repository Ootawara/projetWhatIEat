package com.example.florent.whatieat.API;

import com.example.florent.whatieat.Model.FoodWS;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Florent on 04/02/2016.
 */
public interface APIEndPoint {

    @POST("/food/")
    Call<Void> createFood(@Body FoodWS f);
}
