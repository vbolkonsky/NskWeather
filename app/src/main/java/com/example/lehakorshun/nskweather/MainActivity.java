package com.example.lehakorshun.nskweather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lehakorshun.nskweather.interfaces.RestBackendInterface;
import com.example.lehakorshun.nskweather.model.Mmweather;
import com.example.lehakorshun.nskweather.modules.RetrofitModule;
import com.example.lehakorshun.nskweather.component.DaggerRetrofitComponent;
import com.example.lehakorshun.nskweather.component.RetrofitComponent;
import com.example.lehakorshun.nskweather.model.Town;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    AppCompatActivity context;
    Town town;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = ProgressDialog.show(context,
                        "Loading", "Loading data");

                loadData();

            }
        });
    }

    private void loadData() {

        RetrofitComponent retrofitComponent = DaggerRetrofitComponent.builder()
                .retrofitModule(new RetrofitModule()).build();

        Retrofit retrofit = retrofitComponent.provideRetrofit();

        RestBackendInterface restBackendInterface = retrofit.create(RestBackendInterface.class);
        Call<Mmweather> call = restBackendInterface.getWeather();
        call.enqueue(new Callback<Mmweather>() {
            @Override
            public void onResponse(Response<Mmweather> response, Retrofit retrofit) {
                town = response.body().getTown();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
