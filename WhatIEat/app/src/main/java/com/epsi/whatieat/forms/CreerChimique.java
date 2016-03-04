package com.epsi.whatieat.forms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epsi.whatieat.API.APIClient;
import com.epsi.whatieat.MenuAccueil;
import com.epsi.whatieat.R;

public class CreerChimique extends AppCompatActivity {

    EditText name;
    EditText description;
    EditText effets;
    EditText emplacement;
    Button send;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_chimique);

        name = (EditText)findViewById(R.id.chimique_name);
        description = (EditText)findViewById(R.id.chimique_description);
        effets = (EditText)findViewById(R.id.chimique_effets);
        emplacement = (EditText)findViewById(R.id.chimique_empl);
        send = (Button)findViewById(R.id.chimique_send);

        // Go to menu principal
        buttonMenu = (Button)findViewById(R.id.chimique_menu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreerChimique.this, MenuAccueil.class);
                startActivity(intent);
            }
        });
    }

    public void save_chimique(){

        String name = this.name.getText().toString();
        String description = this.description.getText().toString();
        String effets = this.effets.getText().toString();
        String emplacement = this.emplacement.getText().toString();

        APIClient apiClient = new APIClient(this);
        //Test GET
   /*     Call<List<Chimique>> getCall = apiClient.listFoods();
        getCall.enqueue(new Callback<List<Chimique>>() {
            @Override
            public void onResponse(Response<List<Chimique>> response, Retrofit retrofit) {
                String[] foodChimique = new String[response.body().size()];
                for (int i = 0; i < response.body().size(); i++) {
                    foodChimique[i] = response.body().get(i).getName();
                }
                Log.w("HTTPGET", "test : " + foodChimique[1]);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }
        });

        Call<Void> call = apiClient.createChimique(name, description);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Response<Void> response, Retrofit retrofit) {
                //Log.w("HTTP", response.toString());
                Toast.makeText(Creer_Chimique.this, response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }

        });*/
    }
}
