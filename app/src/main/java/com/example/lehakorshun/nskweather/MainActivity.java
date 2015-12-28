package com.example.lehakorshun.nskweather;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lehakorshun.nskweather.ItemDecoration.DividerItemDecoration;
import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.component.AppComponent;
import com.example.lehakorshun.nskweather.component.DaggerMainComponent;
import com.example.lehakorshun.nskweather.interfaces.MainViewInterface;
import com.example.lehakorshun.nskweather.interfaces.RestBackendInterface;
import com.example.lehakorshun.nskweather.model.Mmweather;
import com.example.lehakorshun.nskweather.model.Town;
import com.example.lehakorshun.nskweather.modules.MainModule;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements MainViewInterface{

    Town town;
    Callback<Mmweather> retroditCallback = new Callback<Mmweather>() {
        @Override
        public void onResponse(Response<Mmweather> response, Retrofit retrofit) {
            if (response.body() != null) {
                town = response.body().getTown();
                weatherAdapter.setItems(town.getForecasts());
                recyclerView.setAdapter(weatherAdapter);
                showItems();
            } else {
                showEmptyText();
                showFailureDialog();
                try {
                    Log.d("111", "error: " + response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    @Bind(R.id.emptyText)
    TextView emptyText;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @OnClick(R.id.fab)
    public void onClick() {
        loadData();
    }

    @Inject WeatherAdapter weatherAdapter;

    @Inject Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLibraries();
        initToolbar();
        showEmptyText();
        initRecyclerView();
    }

    private void initLibraries() {
        ButterKnife.bind(this);
        setupComponent(App.get(this).component());
    }

    private void loadData() {
        showProgress();
        RestBackendInterface restBackendInterface = retrofit.create(RestBackendInterface.class);
        Call<Mmweather> call = restBackendInterface.getWeather();
        call.enqueue(retroditCallback);

    }

    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showFailureDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setMessage("Server error").setTitle("Error").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void showProgress() {
        emptyText.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showItems() {
        emptyText.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyText() {
        emptyText.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }
}
