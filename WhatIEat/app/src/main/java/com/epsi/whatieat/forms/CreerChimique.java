package com.epsi.whatieat.forms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epsi.whatieat.API.APIClient;
import com.epsi.whatieat.MenuAccueil;
import com.epsi.whatieat.Model.Component;
import com.epsi.whatieat.R;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CreerChimique extends AppCompatActivity {

    EditText name;
    EditText description;
    EditText effects;
    Button send;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_chimique);

        name = (EditText)findViewById(R.id.chimique_name);
        description = (EditText)findViewById(R.id.chimique_description);
        effects = (EditText)findViewById(R.id.chimique_effets);
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
        String effects = this.effects.getText().toString();

        APIClient apiClient = new APIClient(this);
        //Test GET
        Call<List<Component>> getCall = apiClient.listComponents();
        getCall.enqueue(new Callback<List<Component>>() {
            @Override
            public void onResponse(Response<List<Component>> response, Retrofit retrofit) {
                String[] chimique = new String[response.body().size()];
                for (int i = 0; i < response.body().size(); i++) {
                    chimique[i] = response.body().get(i).getName();
                }
                Log.w("HTTPGET", "test : " + chimique[1]);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }
        });

        Call<Void> call = apiClient.createComponent(name, description, effects);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Response<Void> response, Retrofit retrofit) {
                //Log.w("HTTP", response.toString());
                Toast.makeText(CreerChimique.this, response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }

        });
    }
}
