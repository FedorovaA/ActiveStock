package com.example.actives.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.actives.data.model.MostActiveStock;
import com.example.actives.util.Constants;

/**
 * Created by Angelina Fedorova
 */

@Database(entities = {MostActiveStock.class}, version = 1, exportSchema = false)
public abstract class ActiveStockDB extends RoomDatabase {

    public abstract IActiveStockDAO activeStockDAO();

    private static ActiveStockDB instance;

    public static ActiveStockDB getDatabase(Context context) {
        if (instance == null) {
            synchronized (ActiveStockDB.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                    ActiveStockDB.class, Constants.DB_NAME)
                    .build();
                }
            }
        }
        return instance;
    }
}
