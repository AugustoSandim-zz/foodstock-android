package com.augustosandim.foodstock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.augustosandim.foodstock.R;
import com.augustosandim.foodstock.helpers.DateHelper;
import com.augustosandim.foodstock.helpers.ToolbarHelper;
import com.augustosandim.foodstock.models.Food;
import com.augustosandim.foodstock.presenters.RegisterPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.jackmiras.nucleolus.helpers.RequiresPresenter;
import io.github.jackmiras.nucleolus.views.NucleolusAppCompatActivity;

@RequiresPresenter(RegisterPresenter.class)
public class RegisterActivity extends NucleolusAppCompatActivity<RegisterPresenter> {

    @Bind(R.id.edittext_food_name)
    public EditText name;

    @Bind(R.id.edittext_brand)
    public EditText brand;

    @Bind(R.id.edittext_expiration_date)
    public EditText expirationDate;

    @Bind(R.id.edittext_quantity)
    public EditText quantity;

    @Bind(R.id.button_save)
    public Button saveButton;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        ToolbarHelper.setup(this, toolbar, "Cadastrar Alimentos", true);
    }

    @OnClick(R.id.button_save)
    public void buttonSaveFood() {
        Food food = new Food();
        food.name = name.getText().toString();
        food.brand = brand.getText().toString();
        food.expirationDate = DateHelper.formatDate(expirationDate.getText().toString());
        food.quantity = Integer.parseInt(quantity.getText().toString());

        food.save();
        Toast.makeText(RegisterActivity.this,"Alimento cadastrado!",Toast.LENGTH_SHORT).show();
    }
}
