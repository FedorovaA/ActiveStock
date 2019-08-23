package com.example.actives.data.util;

import com.example.actives.data.model.MostActiveStock;
import com.example.actives.data.local.ActiveStockDB;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Angelina Fedorova
 */

public class DataRepository implements IDataRepository{

    private ActiveStockDB activeStockDB;

    public DataRepository() {
    }

    public DataRepository(ActiveStockDB activeStockDB) {
        this.activeStockDB = activeStockDB;
    }

    @Override
    public Single<List<MostActiveStock>> getActiveStock() {
        return activeStockDB.activeStockDAO().getAll();
    }

    @Override
    public void saveActiveStock(List<MostActiveStock> mostActiveStocks) {
        activeStockDB.activeStockDAO().insertAll(mostActiveStocks);
    }
}
