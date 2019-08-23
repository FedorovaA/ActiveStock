package com.example.actives.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actives.R;
import com.example.actives.ui.adapter.ActiveStockAdapter;
import com.example.actives.ui.presenter.ActiveStockPresenter;
import com.example.actives.data.model.MostActiveStock;
import com.example.actives.ui.view.IActiveStockView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IActiveStockView {
    private Button btnParse, btnShow;

    private ActiveStockPresenter activeStockPresenter;

    private ActiveStockAdapter activeStockAdapter;

    private RecyclerView rvInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParse = findViewById(R.id.btnParse);
        btnShow = findViewById(R.id.btnShow);
        rvInfo = findViewById(R.id.rvInfo);


        activeStockPresenter = new ActiveStockPresenter(this);
        activeStockPresenter.setView(this);

        activeStockAdapter = new ActiveStockAdapter(this);

        rvInfo.setHasFixedSize(true);
        rvInfo.setLayoutManager(new LinearLayoutManager(this));
        rvInfo.setAdapter(activeStockAdapter);

        btnParse.setOnClickListener(v -> {
            activeStockPresenter.parseActiveStock();
        });

        btnShow.setOnClickListener(v -> {
            activeStockPresenter.showActiveStock();
        });

    }

    @Override
    protected void onDestroy() {
        activeStockAdapter = null;
        activeStockPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void loadActiveStock(List<MostActiveStock> mostActiveStocks) {
        activeStockAdapter.setStockDataList(mostActiveStocks);
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
