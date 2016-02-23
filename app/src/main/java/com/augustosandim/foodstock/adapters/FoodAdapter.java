package com.augustosandim.foodstock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.augustosandim.foodstock.R;
import com.augustosandim.foodstock.models.Food;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by augustosandim on 17/02/16.
 */
public class FoodAdapter extends ArrayAdapter<Food> {


    private final Context context;
    private final List<Food> foods;

    public FoodAdapter(Context context, List<Food> foods) {
        super(context, -1, foods);
       this.context = context;
       this.foods = foods;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater viewInflater;
            viewInflater =LayoutInflater.from(getContext());
            view = viewInflater.inflate(R.layout.list_item_foods, null);
        }

        Food food = getItem(position);

        if (food != null) {
            TextView textViewFoodName = (TextView) view.findViewById(R.id.textview_food_name);
            TextView textViewFoodBrand = (TextView) view.findViewById(R.id.textview_food_brand);
            TextView textViewFoodExpirationDate = (TextView) view.findViewById(R.id.textview_food_expiration_date);
            TextView textViewFoodQuantity = (TextView) view.findViewById(R.id.textview_food_quantity);

            if (textViewFoodName != null){
                textViewFoodName.setText(food.name);
            }
            if (textViewFoodBrand != null) {
                textViewFoodBrand.setText(food.brand);
            }
            if (textViewFoodExpirationDate != null) {
                String date = food.expirationDate.toString();
                textViewFoodExpirationDate.setText(date);
            }
            if (textViewFoodQuantity != null) {
                textViewFoodQuantity.setText(String.valueOf(food.quantity));
            }
        }

        return  view;
    }

}
