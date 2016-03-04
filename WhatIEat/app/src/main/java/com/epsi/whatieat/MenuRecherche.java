package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

    EditText myFoodField;
    Button sendAndResearch;
    Button buttonMenu;
    List<Food> listFood;
    EditText myFoodProduct1Field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche);

        myFoodProduct1Field = (EditText)findViewById(R.id.editTextFood);
        sendAndResearch = (Button)findViewById(R.id.food_button_recherche);

        myFoodField = (EditText)findViewById(R.id.editTextFood);
        sendAndResearch = (Button)findViewById(R.id.food_button_recherche);


        sendAndResearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MenuRecherche.this.get_all_foods();
                Intent intent = new Intent(MenuRecherche.this, MenuRechercheResultats.class);
                intent.putExtra("listeFood", (Parcelable) listFood);
                startActivity(intent);
            }
        });

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.food_search_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRecherche.this, MenuAccueil.class);
                startActivity(intent);
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
                listFood = response.body();
                Log.w("HTTP_GET_ALL_FOODS", "test : " + response.body().get(0).getName());

            }
            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP_GET_ALL_FOODS", "Fail" + t.toString());
            }
        });
    }
}