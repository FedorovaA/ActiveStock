package com.example.actives.view;

import com.example.actives.data.ActiveStockData;

public interface IActiveStockView extends IBaseView {

    void loadActiveStock(ActiveStockData activeStockData);

    void showMessage(String message);
}
