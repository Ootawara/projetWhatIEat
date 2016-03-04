package com.epsi.whatieat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.epsi.whatieat.Model.Food;

import java.util.ArrayList;

public class AfficherFood extends AppCompatActivity {

    String nom;
    String description;
    ArrayList<Food> listeFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_food);
        Bundle b = getIntent().getExtras();
        nom = b.getString("nomFood");
        listeFood = b.getParcelable("listeFood");

        EditText cNom = (EditText) findViewById(R.id.food_name);
        cNom.setText(nom);
        cNom.setFocusable(false);
        cNom.setClickable(false);

        for(Food f : listeFood){
            if(f.getName().equals(nom)) description = f.getDescription();
        }

        EditText cDescription = (EditText) findViewById(R.id.food_description);
        cDescription.setText(description);
        cDescription.setFocusable(false);
        cDescription.setClickable(false);
    }
}
