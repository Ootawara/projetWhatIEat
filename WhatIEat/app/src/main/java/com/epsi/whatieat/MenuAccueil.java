package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epsi.whatieat.forms.CreerChimique;
import com.epsi.whatieat.forms.Creer_food;

public class MenuAccueil extends AppCompatActivity {

    Button buttonSearchComponent;
    Button buttonSearchFood;
    Button buttonCreerComponent;
    Button buttonCreerFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_accueil);

        // Go to menu search
        buttonSearchComponent = (Button)findViewById(R.id.buttonComponentSearch);

        buttonSearchComponent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAccueil.this, MenuRechercheChimique.class);
                startActivity(intent);
            }
        });

        buttonSearchFood = (Button)findViewById(R.id.buttonFoodSearch);

        buttonSearchFood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAccueil.this, MenuRecherche.class);
                startActivity(intent);
            }
        });

        buttonCreerComponent = (Button)findViewById(R.id.buttonCreerComponent);

        buttonCreerComponent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAccueil.this, CreerChimique.class);
                startActivity(intent);
            }
        });

        buttonCreerFood = (Button)findViewById(R.id.buttonCreerFood);

        buttonCreerFood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAccueil.this, Creer_food.class);
                startActivity(intent);
            }
        });
    }




}
