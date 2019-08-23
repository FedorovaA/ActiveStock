package com.example.actives.ui.presenter;

import android.content.Context;
import android.os.Bundle;

import com.example.actives.App;
import com.example.actives.network.service.IActiveStockService;
import com.example.actives.network.RestApi;
import com.example.actives.base.BasePresenter;
import com.example.actives.data.local.ActiveStockDB;
import com.example.actives.data.util.DataRepository;
import com.example.actives.ui.view.IActiveStockView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Angelina Fedorova
 */

public class ActiveStockPresenter extends BasePresenter<IActiveStockView> implements IActiveStockPresenter {
    private static final String TAG = ActiveStockPresenter.class.getName();

    private IActiveStockService stockService;

    private CompositeDisposable compositeDisposable;

    private DataRepository dataRepository;

    private Context context;

    public ActiveStockPresenter(Context context) {
        this.context = context;
        stockService = RestApi.createService(IActiveStockService.class);
        dataRepository = new DataRepository(ActiveStockDB.getDatabase(this.context));
        compositeDisposable = new CompositeDisposable();

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
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    @Override
    public void parseActiveStock() {
        if (App.isNetworkAvailable()) {
            compositeDisposable.add(
                    stockService.getAllActiveStock()
                            .doOnSuccess(activeStockData -> dataRepository.saveActiveStock(activeStockData.getMostActiveStocks()))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(activeStockData -> view.showMessage("Added to DB"),
                                    throwable -> {
                                        view.showMessage(throwable.getMessage());
                                        throwable.printStackTrace();
                                    }));
        } else {
            view.showMessage("Connect to the internet");
        }
    }

    @Override
    public void showActiveStock() {
        compositeDisposable.add(dataRepository.getActiveStock()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(mostActiveStocks -> {
            if (mostActiveStocks.size() == 0) {
                view.showMessage("Press PARSE");
            } else {
                view.loadActiveStock(mostActiveStocks);
            }
            }, throwable -> {
            view.showMessage(throwable.getMessage());
            throwable.printStackTrace();
        }
        ));
    }
}
