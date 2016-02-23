package com.augustosandim.foodstock.models;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by augustosandim on 10/02/16.
 */
@Database(name = FoodStockDB.NAME, version = FoodStockDB.VERSION, foreignKeysSupported = true)
public class FoodStockDB {
    public static final String NAME = "FoodStockDataBase";

    public static final int VERSION = 1;
}
