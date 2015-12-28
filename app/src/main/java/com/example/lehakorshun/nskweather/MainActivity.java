package com.example.lehakorshun.nskweather;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lehakorshun.nskweather.ItemDecoration.DividerItemDecoration;
import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.component.AppComponent;
import com.example.lehakorshun.nskweather.component.DaggerMainComponent;
import com.example.lehakorshun.nskweather.component.MainComponent;
import com.example.lehakorshun.nskweather.interfaces.RestBackendInterface;
import com.example.lehakorshun.nskweather.model.Mmweather;
import com.example.lehakorshun.nskweather.model.Town;
import com.example.lehakorshun.nskweather.modules.MainModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    Town town;

    @Bind(R.id.emptyText)
    TextView emptyText;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    @Inject WeatherAdapter weatherAdapter;

    @Inject Retrofit retrofit;
    //WeatherAdapter weatherAdapter = new WeatherAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupComponent(App.get(this).component());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));

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

        /*MainComponent mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule()).build();

        Retrofit retrofit = mainComponent.provideRetrofit();*/

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

    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule())
                .build()
                .inject(this);
    }
}
