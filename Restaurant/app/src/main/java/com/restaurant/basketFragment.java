package com.restaurant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class basketFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_basket, container, false);
        ListView list=view.findViewById(R.id.listview);
        ArrayList<food_item> items = new ArrayList<food_item>();

        String [] namesArr= getResources().getStringArray(R.array.drinks_names);
        String [] priceArr= getResources().getStringArray(R.array.drinks_prices);
        int[] imgs= help.drinks_imgs;
        String [] MnamesArr= getResources().getStringArray(R.array.meals_names);
        String [] MpriceArr= getResources().getStringArray(R.array.meals_prices);
        String [] MmpriceArr= getResources().getStringArray(R.array.mmeals_prices);
        String [] MlpriceArr= getResources().getStringArray(R.array.lmeals_prices);
        int[] Mimgs= help.imgs;

        for(int i=0;i<help.position.size();i++){

            if (help.type.get(i) == 0){

                items.add(new food_item(imgs[help.position.get(i)],namesArr[help.position.get(i)],
                        priceArr[help.position.get(i)]
                        ,Integer.parseInt(help.quantity.get(i))));

            }else if (help.type.get(i) == 1){
                switch (help.size.get(i)){
                    case 0:
                        items.add(new food_item(Mimgs[help.position.get(i)],MnamesArr[help.position.get(i)],
                                MpriceArr[help.position.get(i)]
                                ,Integer.parseInt(help.quantity.get(i))));
                        break;
                    case 1:
                        items.add(new food_item(Mimgs[help.position.get(i)],MnamesArr[help.position.get(i)],
                                MmpriceArr[help.position.get(i)]
                                ,Integer.parseInt(help.quantity.get(i))));
                        break;
                    case 2:
                        items.add(new food_item(Mimgs[help.position.get(i)],MnamesArr[help.position.get(i)],
                                MlpriceArr[help.position.get(i)]
                                ,Integer.parseInt(help.quantity.get(i))));
                        break;

                }


            }






        }
        BasketListAdapter ad =new BasketListAdapter(getContext(),items);
        list.setAdapter(ad);

        Button addAnother = view.findViewById(R.id.add_more);
        addAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food_fragment foodFragment = new Food_fragment();
                // bdl ama n3ml kol l stoor d tany mmln n3ml function t3mlo w hta5od parameter l fragment
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.coordinator_layout,foodFragment);
                //back in history of opened fragments
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        Button pay = view.findViewById(R.id.buy);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payFragment payFragment = new payFragment();
                // bdl ama n3ml kol l stoor d tany mmln n3ml function t3mlo w hta5od parameter l fragment
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.coordinator_layout,payFragment);
                //back in history of opened fragments
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        TextView basketTotal  = view.findViewById(R.id.basket_total);
        double quan = 0;
        double price = 0;
        for(int n = 0 ; n < help.position.size() ; n++){

            switch (help.size.get(n)) {
                case -1 :
                    price += Double.parseDouble(help.quantity.get(n).toString()) * Double.parseDouble(priceArr[help.position.get(n)]);
                    break;
                case 0 :
                    price += Double.parseDouble(help.quantity.get(n).toString()) * Double.parseDouble(MpriceArr[help.position.get(n)]);
                    break;
                case 1 :
                    price += Double.parseDouble(help.quantity.get(n).toString()) * Double.parseDouble(MmpriceArr[help.position.get(n)]);
                    break;

                case 2 :
                    price += Double.parseDouble(help.quantity.get(n).toString()) * Double.parseDouble(MlpriceArr[help.position.get(n)]);
                    break;


            }

        }

        basketTotal.setText("EGP "+String.valueOf(price));

        TextView TotalAmount  = view.findViewById(R.id.total_amount);
        TotalAmount.setText("EGP "+String.valueOf(price + 18));

        return view;
    }



}