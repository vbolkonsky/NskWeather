package com.example.lehakorshun.nskweather;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.interfaces.RestBackendInterface;
import com.example.lehakorshun.nskweather.model.Mmweather;
import com.example.lehakorshun.nskweather.modules.RetrofitModule;
import com.example.lehakorshun.nskweather.component.DaggerRetrofitComponent;
import com.example.lehakorshun.nskweather.component.RetrofitComponent;
import com.example.lehakorshun.nskweather.model.Town;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    AppCompatActivity context;
    Town town;

    @Bind(R.id.emptyText)
    TextView emptyText;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    WeatherAdapter weatherAdapter = new WeatherAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadData();

            }
        });
    }

    private void loadData() {

        emptyText.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        RetrofitComponent retrofitComponent = DaggerRetrofitComponent.builder()
                .retrofitModule(new RetrofitModule()).build();

        Retrofit retrofit = retrofitComponent.provideRetrofit();

        RestBackendInterface restBackendInterface = retrofit.create(RestBackendInterface.class);
        Call<Mmweather> call = restBackendInterface.getWeather();
        call.enqueue(new Callback<Mmweather>() {
            @Override
            public void onResponse(Response<Mmweather> response, Retrofit retrofit) {
                town = response.body().getTown();

                weatherAdapter.setItems(town.getForecasts());
                recyclerView.setAdapter(weatherAdapter);

                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
