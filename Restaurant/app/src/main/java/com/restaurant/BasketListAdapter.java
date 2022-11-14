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

public class BasketListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<food_item> items;

    public BasketListAdapter(Context context, ArrayList<food_item> items){
        this.context= context;
        this.items=items;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
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
        view = LayoutInflater.from(context).inflate(R.layout.basket_item,null,false);
        ImageView itemIamge = view.findViewById(R.id.item_image) ;
        TextView itemName = view.findViewById(R.id.item_name);
        TextView itemQuantity = view.findViewById(R.id.quantity);
        TextView itemprice = view.findViewById(R.id.item_price);
        itemIamge.setImageResource(items.get(i).getImage());
        itemName.setText(items.get(i).getName());
        itemQuantity.setText(String.valueOf(items.get(i).getQuantity()));
        itemprice.setText(items.get(i).getPrice());
        return view;
    }
}
