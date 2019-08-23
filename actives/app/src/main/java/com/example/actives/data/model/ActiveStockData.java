package com.example.actives.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Angelina Fedorova
 */

public class ActiveStockData {
    @SerializedName("mostActiveStock")
    @Expose
    private List<MostActiveStock> mostActiveStocks = null;

    public ActiveStockData() {
    }

    public ActiveStockData(List<MostActiveStock> mostActiveStocks)  {
        this.mostActiveStocks = mostActiveStocks;
    }

    public List<MostActiveStock> getMostActiveStocks() {
        return mostActiveStocks;
    }

    public void setMostActiveStocks(List<MostActiveStock> mostActiveStocks) {
        this.mostActiveStocks = mostActiveStocks;
    }
}
