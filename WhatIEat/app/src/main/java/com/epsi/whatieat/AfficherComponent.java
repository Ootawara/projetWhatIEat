package com.epsi.whatieat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epsi.whatieat.API.APIClient;
import com.epsi.whatieat.Model.Component;
import com.epsi.whatieat.Model.Food;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AfficherComponent extends AppCompatActivity {

    String nom;
    String description;
    String effect;

    EditText cNom;
    EditText cDescription;
    EditText cEffects;

    Button modifierComponent;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_component);
        Bundle b = getIntent().getExtras();
        nom = b.getString("nomComponent");

        APIClient api = new APIClient(this);

        Call<List<Component>> getCall = api.getComponent(nom);
        getCall.enqueue(new Callback<List<Component>>() {
            @Override
            public void onResponse(Response<List<Component>> response, Retrofit retrofit) {
                constructView(response.body().get(0));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }
        });

        // Go to menu principal
        buttonMenu = (Button) findViewById(R.id.component_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfficherComponent.this, MenuAccueil.class);
                startActivity(intent);
            }
        });
    }

    public void constructView(Component c){
        description = c.getDescription();
        effect = c.getEffects();

        cNom = (EditText) findViewById(R.id.component_name);
        cNom.setText(nom);
        cNom.setFocusable(false);
        cNom.setClickable(false);

        cDescription = (EditText) findViewById(R.id.component_description);
        cDescription.setText(description);
        cDescription.setFocusable(false);
        cDescription.setClickable(false);

        cEffects = (EditText) findViewById(R.id.component_effects);
        cEffects.setText(effect);
        cEffects.setFocusable(false);
        cEffects.setClickable(false);

        modifierComponent = (Button) findViewById(R.id.food_send);
        modifierComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifierComponent.setText("ENREGISTRER");
                cNom.setFocusable(true);
                cNom.setClickable(true);
                cNom.setText(nom, TextView.BufferType.EDITABLE);
                cDescription.setFocusable(true);
                cDescription.setClickable(true);
                cDescription.setText(description, TextView.BufferType.EDITABLE);
                cEffects.setFocusable(true);
                cEffects.setClickable(true);
                cDescription.setText(description, TextView.BufferType.EDITABLE);

                modifierComponent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // AfficherComponent.this.save_component();

                        modifierComponent.setText("MODIFIER");
                        cNom.setFocusable(false);
                        cNom.setClickable(false);
                        cDescription.setFocusable(false);
                        cDescription.setClickable(false);
                        cEffects.setFocusable(false);
                        cEffects.setClickable(false);

                        Intent intent = new Intent(AfficherComponent.this, MenuAccueil.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}


