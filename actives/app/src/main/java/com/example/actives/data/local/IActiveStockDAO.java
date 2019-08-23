package com.example.actives.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.actives.data.model.MostActiveStock;
import com.example.actives.util.Constants;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Angelina Fedorova
 */
@Dao
public interface IActiveStockDAO {

    /**
     * Добавление данных в базу
     * @param mostActiveStocks список акций
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MostActiveStock> mostActiveStocks);


    /**
     * Выборка данных из базы
     * @return список акций
     */
    @Query("SELECT * FROM " + Constants.TABLE_NAME)
    Single<List<MostActiveStock>> getAll();
}
