package com.restaurant;

import android.content.Intent;
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



public class drinks_fragment extends Fragment {

    private TextView numberOfItems;
    private ArrayList<food_item> drinks = new ArrayList<food_item>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_item_list_fragment, container, false);
        ListView list=view.findViewById(R.id.listview);

        String [] namesArr= getResources().getStringArray(R.array.drinks_names);
        String [] priceArr= getResources().getStringArray(R.array.drinks_prices);
        int[] imgs= help.drinks_imgs;
        for(int i=0;i<namesArr.length;i++){
            drinks.add(new food_item(imgs[i],namesArr[i],"EGP "+priceArr[i]));
        }
        DrinksListViewAdapter ad =new DrinksListViewAdapter(getContext(),drinks);
        list.setAdapter(ad);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),DrinkOrder.class);
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
                    basketFragment basketFrag = new basketFragment();
                    // bdl ama n3ml kol l stoor d tany mmln n3ml function t3mlo w hta5od parameter l fragment
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.coordinator_layout,basketFrag);
                    //back in history of opened fragments
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            }
        });




        return view;
    }


}