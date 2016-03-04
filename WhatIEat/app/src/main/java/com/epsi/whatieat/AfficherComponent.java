package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epsi.whatieat.Model.Component;

import java.util.ArrayList;

public class AfficherComponent extends AppCompatActivity {


    String nom;
    String description;
    String effect;
    ArrayList<Component> listeComponent;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_component);
        Bundle b = getIntent().getExtras();
        nom = b.getString("nomComponent");
        listeComponent = b.getParcelable("listeComponent");

        EditText cNom = (EditText) findViewById(R.id.component_name);
        cNom.setText(nom);
        cNom.setFocusable(false);
        cNom.setClickable(false);

        for(Component c : listeComponent){
            if(c.getName().equals(nom)) {
                description = c.getDescription();
                effect = c.getEffects();
            }
        }

        EditText cDescription = (EditText) findViewById(R.id.component_description);
        cDescription.setText(description);
        cDescription.setFocusable(false);
        cDescription.setClickable(false);

        EditText cEffects = (EditText) findViewById(R.id.component_effects);
        cEffects.setText(effect);
        cEffects.setFocusable(false);
        cEffects.setClickable(false);

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.component_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfficherComponent.this, MenuAccueil.class);
                startActivity(intent);
            }
        });
    }
}
