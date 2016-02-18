package com.epsi.whatieat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.epsi.whatieat.R;


public class MenuRecherche extends AppCompatActivity {

    private EditText myFoodProduct1Field;
    private EditText myFoodProduct2Field;
    private EditText myFoodProduct3Field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recherche);
    }

}
