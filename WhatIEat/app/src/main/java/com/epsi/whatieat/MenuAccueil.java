package com.epsi.whatieat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuAccueil extends AppCompatActivity {

    Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_accueil);

        // Go to menu search
        buttonSearch = (Button)findViewById(R.id.buttonMainSearch);

        buttonSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAccueil.this, MenuRecherche.class);
                startActivity(intent);
            }
        });
    }




}
