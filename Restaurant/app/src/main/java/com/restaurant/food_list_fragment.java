package com.restaurant;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class food_list_fragment extends Fragment {

    private TextView numberOfItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_item_list_fragment, container, false);
        ListView list=view.findViewById(R.id.listview);
        ArrayList<food_item> meals = new ArrayList<food_item>();
        String [] namesArr= getResources().getStringArray(R.array.meals_names);
        String [] descArr= getResources().getStringArray(R.array.meals_descs);
        String [] priceArr= getResources().getStringArray(R.array.meals_prices);
        int[] imgs= help.imgs;
        for(int i=0;i<namesArr.length;i++){
            meals.add(new food_item(imgs[i],namesArr[i],descArr[i],"EGP "+priceArr[i]));
        }
        FoodListViewAdapter ad =new FoodListViewAdapter(getContext(),meals);
        list.setAdapter(ad);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),MealOrder.class);
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });



        LinearLayout viewBasket = view.findViewById(R.id.view_card);
        viewBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(help.position.size() < 1){


                }
                else{
                    /*int quantity=0;
                    for(int j=0; j < help.quantity.size();j++){
                        quantity=quantity+Integer.parseInt(help.quantity.get(j));
                    }
                    Toast.makeText(getContext(),String.valueOf(quantity) , Toast.LENGTH_SHORT).show();*/
                        basketFragment basketFragment = new basketFragment();
                        // bdl ama n3ml kol l stoor d tany mmln n3ml function t3mlo w hta5od parameter l fragment
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.coordinator_layout,basketFragment);
                        //back in history of opened fragments
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();


                }
            }
        });



        return view;
    }

    @Override
    public void onStart() {
        View view = getView();
        ListView list=view.findViewById(R.id.listview);
        ArrayList<food_item> meals = new ArrayList<food_item>();
        String [] namesArr= getResources().getStringArray(R.array.meals_names);
        String [] descArr= getResources().getStringArray(R.array.meals_descs);
        String [] priceArr= getResources().getStringArray(R.array.meals_prices);
        int[] imgs= help.imgs;
        for(int i=0;i<namesArr.length;i++){
            meals.add(new food_item(imgs[i],namesArr[i],descArr[i],"EGP "+priceArr[i]));
        }
        FoodListViewAdapter ad =new FoodListViewAdapter(getContext(),meals);
        list.setAdapter(ad);
        super.onStart();
    }
}