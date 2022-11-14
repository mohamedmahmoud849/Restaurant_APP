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

public class DrinksListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<food_item> drinks;

    public DrinksListViewAdapter(Context context, ArrayList<food_item> drinks){
        this.context= context;
        this.drinks=drinks;

    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public Object getItem(int i) {
        return drinks.get(i);
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
        view = LayoutInflater.from(context).inflate(R.layout.drink_item,null,false);
        ImageView drinkIamge = view.findViewById(R.id.drink_image) ;
        TextView drinkName = view.findViewById(R.id.drink_name);
        TextView drinkPrice = view.findViewById(R.id.drink_price);
        drinkIamge.setImageResource(drinks.get(i).getImage());
        drinkName.setText(drinks.get(i).getName());
        drinkPrice .setText(drinks.get(i).getPrice());

        return view;
    }
}
