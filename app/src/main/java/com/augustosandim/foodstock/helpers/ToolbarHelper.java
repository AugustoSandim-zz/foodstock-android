package com.augustosandim.foodstock.helpers;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.augustosandim.foodstock.R;

/**
 * Created by augustosandim on 10/02/16.
 */
public class ToolbarHelper {
    public static void setup(AppCompatActivity activity,Toolbar toolbar, int titleRes, boolean homeAsUpIndicator) {
        ToolbarHelper.setup(activity, toolbar, activity.getResources().getString(titleRes), homeAsUpIndicator);
    }

    public static void setup(AppCompatActivity activity, Toolbar toolbar, String titleRes, boolean homeAsUpIndicator) {
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        ((TextView) toolbar.findViewById(R.id.textview_toolbar_title)).setText(titleRes);

        if(actionBar != null) {
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(homeAsUpIndicator);
        }
        ((TextView) toolbar.findViewById(R.id.textview_toolbar_title)).setText(titleRes);
    }

    public static void setup(AppCompatActivity activity, Toolbar toolbar, String titleRes, int iconRes) {
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();

        if(actionBar != null) {
            actionBar.setTitle("");
            actionBar.setLogo(iconRes);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView textView = (TextView) toolbar.findViewById(R.id.textview_toolbar_title);
        int paddingLeft = (int) 16d;
        textView.setPadding(paddingLeft, 0, 0, 0);
        textView.setText(titleRes);
    }

    public static void setupCustom(AppCompatActivity activity, Toolbar toolbar, boolean homeAsUpIndicator) {
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(homeAsUpIndicator);
        }
    }

}
