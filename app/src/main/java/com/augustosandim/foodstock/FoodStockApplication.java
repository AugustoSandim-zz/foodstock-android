package com.augustosandim.foodstock;


import android.app.Application;
import android.content.Context;

import com.karumi.dexter.Dexter;
import com.raizlabs.android.dbflow.config.FlowManager;

public class FoodStockApplication extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        FlowManager.init(context);
        Dexter.initialize(context);
    }

    public static Context getContext() {
        return  context;
    }
}
