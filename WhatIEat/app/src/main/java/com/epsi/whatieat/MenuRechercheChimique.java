package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
    ArrayList<String> nomsComponent;

    ListView listeResultats;
    List<Component> listeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche_chimique);

        MenuRechercheChimique.this.get_all_chemicals();

        myChemicalProduct1Field = (EditText)findViewById(R.id.editTextProd1);
        sendAndResearch = (Button)findViewById(R.id.buttonRechercheChimique);

        listeResultats = (ListView) findViewById(R.id.listeResultatChimique);

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.chimique_search_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRechercheChimique.this, MenuAccueil.class);
                startActivity(intent);
            }
        });

        sendAndResearch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String toSearch = myChemicalProduct1Field.getText().toString();
                ArrayList<String> filteredComponent = new ArrayList<String>();
                for(String n : nomsComponent){
                    if (n.contains(toSearch)) filteredComponent.add(n);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MenuRechercheChimique.this, android.R.layout.simple_list_item_1, filteredComponent);
                listeResultats.setAdapter(adapter);
                listeResultats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MenuRechercheChimique.this, AfficherComponent.class);
                        AppCompatTextView b = (AppCompatTextView) view;
                        String nom = (String) b.getText();
                        intent.putExtra("nomComponent", nom);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    public void constructList(){
        nomsComponent = new ArrayList<String>();
        for(Component c : listeComponent){
            nomsComponent.add(c.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MenuRechercheChimique.this, android.R.layout.simple_list_item_1, nomsComponent);
        listeResultats.setAdapter(adapter);
        listeResultats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuRechercheChimique.this, AfficherComponent.class);
                AppCompatTextView b = (AppCompatTextView) view;
                String nom = (String) b.getText();
                intent.putExtra("nomComponent", nom);
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
                constructList();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP_GET_ALL_COMPONENTS", "Fail" + t.toString());
            }
        });
    }
}
