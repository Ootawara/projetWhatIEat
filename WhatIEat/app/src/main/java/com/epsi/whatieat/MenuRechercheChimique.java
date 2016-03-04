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
import com.epsi.whatieat.Model.Component;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MenuRechercheChimique extends AppCompatActivity {

    EditText myChemicalProduct1Field;
    Button sendAndResearch;
    Button buttonMenu;

    List<Component> listeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche_chimique);

        myChemicalProduct1Field = (EditText)findViewById(R.id.editTextProd1);
        sendAndResearch = (Button)findViewById(R.id.buttonRechercheChimique);

        sendAndResearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MenuRechercheChimique.this.get_all_chemicals();
                Intent intent = new Intent(MenuRechercheChimique.this, MenuRechercheResultatsChimiques.class);
                intent.putExtra("listeComponent", (ArrayList<Component>) listeComponent);
                startActivity(intent);
            }
        });

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.chimique_search_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRechercheChimique.this, MenuAccueil.class);
                startActivity(intent);
            }
        });
    }

    public void get_all_chemicals(){

        APIClient apiClient = new APIClient(this);
        //Test GET
        Call<List<Component>> getCall = apiClient.listComponents();
        getCall.enqueue(new Callback<List<Component>>() {
            @Override
            public void onResponse(Response<List<Component>> response, Retrofit retrofit) {
                Log.w("HTTP_GET_ALL_COMPONENTS", "test : " + response.body().get(0).getName());
                listeComponent = response.body();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP_GET_ALL_COMPONENTS", "Fail" + t.toString());
            }
        });
    }
}
