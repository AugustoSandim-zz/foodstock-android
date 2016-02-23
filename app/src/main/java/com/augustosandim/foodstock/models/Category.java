package com.augustosandim.foodstock.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by augustosandim on 10/02/16.
 */
@ModelContainer
@Table(tableName = "categories", databaseName = FoodStockDB.NAME)
public class Category extends BaseModel {

    @Column(name = "id")
    @PrimaryKey(autoincrement = true)
    public long id;
    @Column(name = "name")
    public String name;
}
