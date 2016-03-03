package com.epsi.whatieat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epsi.whatieat.API.APIClient;
import com.epsi.whatieat.Model.Food;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MenuRecherche extends AppCompatActivity {

    EditText myFoodProduct1Field;
    EditText myFoodProduct2Field;
    EditText myFoodProduct3Field;
    Button sendAndResearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche);

        myFoodProduct1Field = (EditText)findViewById(R.id.editTextProd1);
        myFoodProduct2Field = (EditText)findViewById(R.id.editTextProd2);
        myFoodProduct3Field = (EditText)findViewById(R.id.editTextProd3);
        sendAndResearch = (Button)findViewById(R.id.buttonRecherche);

        sendAndResearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MenuRecherche.this.get_all_foods();
            }
        });
    }

    public void get_all_foods(){

        APIClient apiClient = new APIClient(this);
        //Test GET
        Call<List<Food>> getCall = apiClient.listFoods();
        getCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Response<List<Food>> response, Retrofit retrofit) {
                Log.w("HTTP_GET_ALL_FOODS", "test : " + response.body().get(0).getName());
            }
            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP_GET_ALL_FOODS", "Fail" + t.toString());
            }
        });
    }
}