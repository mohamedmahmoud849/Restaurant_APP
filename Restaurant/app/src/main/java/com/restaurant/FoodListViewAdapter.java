package com.restaurant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodListViewAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<food_item> meals;

    public FoodListViewAdapter(Context context, ArrayList<food_item> meals){
        this.context= context;
        this.meals=meals;

    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public Object getItem(int i) {
        return meals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"InflateParams", "ViewHolder"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //this line is getting me the layout i want to access to change
        // the data to my array by getting the context and inflate by the id of listitem
        view = LayoutInflater.from(context).inflate(R.layout.food_item,null,false);
        ImageView mealIamge = view.findViewById(R.id.meal_img) ;
        TextView mealName = view.findViewById(R.id.meal_name);
        TextView mealDesc = view.findViewById(R.id.meal_desc);
        TextView mealPrice = view.findViewById(R.id.meal_price);
        mealIamge.setImageResource(meals.get(i).getImage());
        mealName.setText(meals.get(i).getName());
        mealDesc.setText(meals.get(i).getDescription());
        mealPrice.setText(meals.get(i).getPrice());
        return view;
    }
}
