package com.example.actives.ui.presenter;

/**
 * Created by Angelina Fedorova
 */

public interface IActiveStockPresenter {

    /**
     * Событие парсинга данных с апи и сохранение в БД
     */
    void parseActiveStock();

    /**
     * Событие показа данных на экране из БД
     */
    void showActiveStock();
}
