package com.example.actives.data.util;

import com.example.actives.data.model.MostActiveStock;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Angelina Fedorova
 */

public interface IDataRepository {

    /**
     * Получение списка акций, вызывается после нажатия на кнопку "Show"
     * @return список акций
     */
    Single<List<MostActiveStock>> getActiveStock();

    /**
     * Сохранение данных в базу, вызывается после нажатия на кнопку "Parse"
     * @param activeStockData список акций
     */
    void saveActiveStock(List<MostActiveStock> activeStockData);
}
