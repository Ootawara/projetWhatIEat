package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epsi.whatieat.API.APIClient;
import com.epsi.whatieat.Model.Food;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AfficherFood extends AppCompatActivity {

    String nom;
    String description;
    Button modifierFood;
    EditText cNom;
    EditText cDescription;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_food);
        Bundle b = getIntent().getExtras();
        nom = b.getString("nomFood");

        APIClient api = new APIClient(this);

        Food f = (Food) api.getFood(nom);
        description = f.getDescription();

        cNom = (EditText) findViewById(R.id.food_name);
        cNom.setText(nom);
        cNom.setFocusable(false);
        cNom.setClickable(false);

        cDescription = (EditText) findViewById( R.id.food_description);
        cDescription.setText(description);
        cDescription.setFocusable(false);
        cDescription.setClickable(false);

        modifierFood = (Button) findViewById(R.id.food_send);
        modifierFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifierFood.setText("ENREGISTRER");
                cNom.setFocusable(true);
                cNom.setClickable(true);
                cNom.setText(nom, TextView.BufferType.EDITABLE);
                cDescription.setFocusable(true);
                cDescription.setClickable(true);
                cDescription.setText(description, TextView.BufferType.EDITABLE);

                modifierFood.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AfficherFood.this.save_food();

                        modifierFood.setText("MODIFIER");
                        cNom.setFocusable(false);
                        cNom.setClickable(false);
                        cDescription.setFocusable(false);
                        cDescription.setClickable(false);

                        Intent intent = new Intent(AfficherFood.this, MenuAccueil.class);
                        startActivity(intent);
                    }
                });
            }
        });

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.food_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfficherFood.this, MenuAccueil.class);
                startActivity(intent);
            }
        });
    }

    public void save_food(){

        String name = this.cNom.getText().toString();
        String description = this.cDescription.getText().toString();
        String id = "";

        APIClient apiClient = new APIClient(this);
        //Test GET
        Call<List<Food>> getCall = apiClient.listFoods();
        getCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Response<List<Food>> response, Retrofit retrofit) {
                String[] foodName = new String[response.body().size()];
                for (int i = 0; i < response.body().size(); i++) {
                    foodName[i] = response.body().get(i).getName();
                }

                Log.w("HTTPGET", "test : " + foodName[1]);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }
        });
        Call<Void> call = apiClient.createFood(name, description, id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Response<Void> response, Retrofit retrofit) {
                //Log.w("HTTP", response.toString());
                Toast.makeText(AfficherFood.this, response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }
        });
    }
}
