package com.example.actives.presenter;

import android.os.Bundle;
import android.util.Log;

import com.example.actives.api.IActiveStockService;
import com.example.actives.api.RestApi;
import com.example.actives.data.ActiveStockData;
import com.example.actives.view.IActiveStockView;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ActiveStockPresenter extends BasePresenter<IActiveStockView> implements IActiveStockPresenter {
    private static final String TAG = ActiveStockPresenter.class.getName();

    private IActiveStockService stockService;

    public ActiveStockPresenter() {
        stockService = RestApi.createService(IActiveStockService.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void parseActiveStock() {
        stockService.getAllActiveStock()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ActiveStockData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ActiveStockData activeStockData) {
                        view.loadActiveStock(activeStockData);
                        view.showMessage("OK");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        view.showMessage(e.getMessage());
                        e.printStackTrace();
                    }
                });
    }
}
