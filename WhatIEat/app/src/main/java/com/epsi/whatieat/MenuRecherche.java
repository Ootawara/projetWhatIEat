package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.epsi.whatieat.API.APIClient;
import com.epsi.whatieat.Model.Food;

import java.io.Serializable;
import java.util.ArrayList;
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
    ListView listeResultats;
    List<String> nomsFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche);

        myFoodField = (EditText)findViewById(R.id.editTextFood);
        sendAndResearch = (Button)findViewById(R.id.food_button_recherche);

        listeResultats = (ListView) findViewById(R.id.listeResultat);
        nomsFood = new ArrayList<String>();

        for(Food f : listFood){
            nomsFood.add(f.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MenuRecherche.this, android.R.layout.simple_list_item_1, nomsFood);
        listeResultats.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRecherche.this, AfficherFood.class);
                Button b = (Button) v;
                String nom = (String) b.getText();
                intent.putExtra("nomFood", nom);
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