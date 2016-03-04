package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.epsi.whatieat.Model.Food;

import java.util.ArrayList;

public class MenuRechercheResultats extends AppCompatActivity {

    Button buttonMenu;
    ListView listeResultats;
    ArrayList<Food> listeFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche_resultats);

        Bundle b = getIntent().getExtras();
        listeFood = b.getParcelable("listeFood");
        ArrayList<String> nomsFood = new ArrayList<>();
        for(Food f : listeFood){
            nomsFood.add(f.getName());
        }
        listeResultats = (ListView) findViewById(R.id.listeResultat);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MenuRechercheResultats.this, android.R.layout.simple_list_item_1, nomsFood);
        listeResultats.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRechercheResultats.this, AfficherFood.class);
                Button b = (Button) v;
                String nom = (String) b.getText();
                intent.putExtra("nomFood", nom);
                startActivity(intent);
            }
        });

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.food_result_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRechercheResultats.this, MenuAccueil.class);
                startActivity(intent);
            }
        });
    }
}
