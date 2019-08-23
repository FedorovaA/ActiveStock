package com.example.actives.network.service;

import com.example.actives.data.model.ActiveStockData;
import com.example.actives.util.Constants;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Angelina Fedorova
 */

public interface IActiveStockService {

    /**
     * Получение данных с апи
     * @return акции
     */
    @GET(Constants.API_POINT)
    Single<ActiveStockData> getAllActiveStock();
}
