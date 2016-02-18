package com.example.florent.whatieat.API;

import android.content.Context;
import android.util.Log;

import com.example.florent.whatieat.Model.Food;
import com.example.florent.whatieat.Model.FoodWS;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Florent on 04/02/2016.
 */
public class APIClient {

    static final String BASE_URL = "http://10.0.2.2:8000";
    Context ctx;
    APIEndPoint apiEndPoint;

    public APIClient(Context ctx) {
        this.ctx = ctx;

        Retrofit r = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        apiEndPoint = r.create(APIEndPoint.class);
    }

    public Call<Void> createFood(String name, String description){
        FoodWS f = new FoodWS();
        f.setName(name);
        f.setDescription(description);

        return apiEndPoint.createFood(f);
    }

    public Call<List<Food>> listFoods(){
        return apiEndPoint.listFoods();
    }
}
