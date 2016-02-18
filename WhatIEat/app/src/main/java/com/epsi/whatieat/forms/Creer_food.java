package com.epsi.whatieat.forms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epsi.whatieat.API.APIClient;
import com.example.florent.whatieat.R;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Creer_food extends AppCompatActivity {

    EditText name, description;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_food);

        name = (EditText)findViewById(R.id.food_name);
        description = (EditText)findViewById(R.id.food_description);
        send = (Button)findViewById(R.id.food_send);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Creer_food.this.save_food();
            }
        });
    }

    public void save_food(){

        String name = this.name.getText().toString();
        String description = this.description.getText().toString();

        APIClient apiClient = new APIClient(this);
        //Test GET
        /*Call<List<Food>> getCall = apiClient.listFoods();
        getCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Response<List<Food>> response, Retrofit retrofit) {
                Log.w("HTTPGET", "test : " + response.body().get(0).getName());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }
        });*/

        Call<Void> call = apiClient.createFood(name, description);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Response<Void> response, Retrofit retrofit) {
                Log.w("HTTP", response.toString());
                Toast.makeText(Creer_food.this, response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("HTTP", "Fail" + t.toString());
            }
        });
    }
}
