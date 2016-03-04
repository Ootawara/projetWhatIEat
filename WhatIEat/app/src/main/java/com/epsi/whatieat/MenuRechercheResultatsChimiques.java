package com.epsi.whatieat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.epsi.whatieat.Model.Component;
import com.epsi.whatieat.Model.Food;

import java.util.ArrayList;

public class MenuRechercheResultatsChimiques extends AppCompatActivity {

    ListView listeResultats;
    ArrayList<Component> listeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche_resultats_chimiques);

        Bundle b = getIntent().getExtras();
        listeComponent = b.getParcelable("listeComponent");
        ArrayList<String> nomsComponent = new ArrayList<>();
        for(Component c : listeComponent){
            nomsComponent.add(c.getName());
        }
        listeResultats = (ListView) findViewById(R.id.listeResultat);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MenuRechercheResultatsChimiques.this, android.R.layout.simple_list_item_1, nomsComponent);
        listeResultats.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRechercheResultatsChimiques.this, AfficherComponent.class);
                Button b = (Button) v;
                String nom = (String) b.getText();
                intent.putExtra("nomComponent", nom);
                intent.putExtra("listeComponent", listeComponent);
                startActivity(intent);
            }
        });

    }
}
