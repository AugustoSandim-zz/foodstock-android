package com.augustosandim.foodstock.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * Created by augustosandim on 10/02/16.
 */
@ModelContainer
@Table(tableName = "foods", databaseName = FoodStockDB.NAME)
public class Food extends BaseModel {
    @Column(name = "id")
    @PrimaryKey(autoincrement = true)
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "expiration_date")
    public Date expirationDate;
    @Column(name = "brand")
    public String brand;
    @Column(name = "quantity")
    public int quantity;
    @Column(name = "weight")
    public Float weight;
    @Column(name = "imei")
    public String imei;
//    @Column(name = "image")
//    public TypedFile image;

//    @Column
//    @ForeignKey(saveForeignKeyModel = false)
//    Category category;
    public static List<Food> getAll(){
        return new Select()
                .from(Food.class)
                .orderBy("name ASC")
                .queryList();
    }

    public static String all(List<Food> foodList) {
        StringBuilder stringBuilder =  new StringBuilder();
        stringBuilder.append("name,");
        stringBuilder.append("expiration_date,");
        stringBuilder.append("brand,");
        stringBuilder.append("quantity,");
        stringBuilder.append("weight,");
        stringBuilder.append("imei");
        stringBuilder.append("\n");

        for (Food food:foodList) {
            stringBuilder.append(food.name);
            stringBuilder.append(",");
            stringBuilder.append(food.expirationDate);
            stringBuilder.append(",");
            stringBuilder.append(food.brand);
            stringBuilder.append(",");
            stringBuilder.append(food.quantity);
            stringBuilder.append(",");
            stringBuilder.append(food.weight);
            stringBuilder.append(",");
            stringBuilder.append(food.imei);
            stringBuilder.append("\n");
        }

        String foods = new String(stringBuilder);
        return foods;
    }

    public static Food getFood(long id) {
        return new Select().from(Food.class).where(Food$Table.ID + " = ?", id).querySingle();
    }
}
