package com.augustosandim.foodstock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.augustosandim.foodstock.R;
import com.augustosandim.foodstock.adapters.FoodAdapter;
import com.augustosandim.foodstock.helpers.ToolbarHelper;
import com.augustosandim.foodstock.models.Food;
import com.augustosandim.foodstock.presenters.MainPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.jackmiras.nucleolus.helpers.RequiresPresenter;
import io.github.jackmiras.nucleolus.views.NucleolusAppCompatActivity;

/**
 * Created by augustosandim on 10/02/16.
 */
@RequiresPresenter(MainPresenter.class)
public class MainActivity extends NucleolusAppCompatActivity<MainPresenter> {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listview_foods)
    ListView listFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ToolbarHelper.setup(this, toolbar, "Alimentos", false);

        final FoodAdapter foodAdapter = new FoodAdapter(this, Food.getAll());
        listFoods.setAdapter(foodAdapter);

    }

    @OnClick(R.id.fab_add_food)
    public void onAddFoodClicked() {
        startActivity(new Intent(this, RegisterActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }


}
