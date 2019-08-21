package com.example.actives.api;

import com.example.actives.data.ActiveStockData;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface IActiveStockService {

    @GET("api/v3/stock/actives")
    Single<ActiveStockData> getAllActiveStock();
}
