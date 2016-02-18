package com.epsi.whatieat.API;

import android.content.Context;

import com.epsi.whatieat.Model.Food;
import com.epsi.whatieat.Model.FoodWS;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Florent on 04/02/2016.
 */
public class APIClient {

    //static final String BASE_URL = "http://10.0.2.2:8000";
    static final String BASE_URL = "http://78.193.226.46:8000";
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

    public Call<Food> getFood(String name){
        return apiEndPoint.getFood(name);
    }
}
