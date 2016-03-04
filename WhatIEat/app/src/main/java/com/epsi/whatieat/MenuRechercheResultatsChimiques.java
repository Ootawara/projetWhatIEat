package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.epsi.whatieat.Model.Component;

import java.util.ArrayList;

public class MenuRechercheResultatsChimiques extends AppCompatActivity {

    ListView listeResultats;
    ArrayList<Component> listeComponent;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche_resultats_chimiques);

        Bundle b = getIntent().getExtras();
        listeComponent = (ArrayList<Component>) b.getSerializable("listeComponent");
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
                startActivity(intent);
            }
        });

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.chimique_result_menu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRechercheResultatsChimiques.this, MenuAccueil.class);
                startActivity(intent);
            }
        });

    }
}
