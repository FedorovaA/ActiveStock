package com.example.actives.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ActiveStockData {
    @SerializedName("mostActiveStock")
    @Expose
    private ArrayList<MostActiveStock> mostActiveStocks = null;

    public ActiveStockData() {
    }

    public ActiveStockData(ArrayList<MostActiveStock> mostActiveStocks)  {
        this.mostActiveStocks = mostActiveStocks;
    }

    public ArrayList<MostActiveStock> getMostActiveStocks() {
        return mostActiveStocks;
    }

    public void setMostActiveStocks(ArrayList<MostActiveStock> mostActiveStocks) {
        this.mostActiveStocks = mostActiveStocks;
    }
}
