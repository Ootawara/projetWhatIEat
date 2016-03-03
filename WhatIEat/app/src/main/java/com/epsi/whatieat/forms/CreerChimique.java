package com.epsi.whatieat.forms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epsi.whatieat.MenuRecherche;
import com.epsi.whatieat.R;

public class CreerChimique extends AppCompatActivity {

    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_chimique);



        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.button2);

        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreerChimique.this, MenuRecherche.class);
                startActivity(intent);
            }
        });
    }
}
