package com.example.actives.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actives.R;
import com.example.actives.adapter.ActiveStockAdapter;
import com.example.actives.data.ActiveStockData;
import com.example.actives.presenter.ActiveStockPresenter;
import com.example.actives.view.IActiveStockView;

public class MainActivity extends AppCompatActivity implements IActiveStockView {
    private Button btnParse;

    private ActiveStockPresenter activeStockPresenter;

    private ActiveStockAdapter activeStockAdapter;

    private RecyclerView rvInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParse = findViewById(R.id.btnParse);
        rvInfo = findViewById(R.id.rvInfo);


        activeStockPresenter = new ActiveStockPresenter();
        activeStockPresenter.setView(this);

        activeStockAdapter = new ActiveStockAdapter(this);

        rvInfo.setHasFixedSize(true);
        rvInfo.setLayoutManager(new LinearLayoutManager(this));
        rvInfo.setAdapter(activeStockAdapter);

        btnParse.setOnClickListener(v -> {
            activeStockPresenter.parseActiveStock();
        });

    }

    @Override
    public void loadActiveStock(ActiveStockData activeStockData) {
        activeStockAdapter.setStockDataList(activeStockData);
        activeStockAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
