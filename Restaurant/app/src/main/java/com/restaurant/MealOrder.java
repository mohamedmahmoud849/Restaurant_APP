package com.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MealOrder extends AppCompatActivity {
    private TextView quantity ;
    private String pos_price;
    private int size = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_order);


        String [] namesArr= getResources().getStringArray(R.array.meals_names);
        String [] descArr= getResources().getStringArray(R.array.meals_descs);
        String [] priceArr= getResources().getStringArray(R.array.meals_prices);
        String [] mpriceArr= getResources().getStringArray(R.array.mmeals_prices);
        String [] lpriceArr= getResources().getStringArray(R.array.lmeals_prices);
        int[] imgs= help.imgs;
        Bundle extras = getIntent().getExtras();
        int i =extras.getInt("position");
        pos_price = priceArr[i];


        RadioGroup r =(RadioGroup) findViewById(R.id.radio_group);
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView total=(TextView) findViewById(R.id.total);
                quantity=(TextView) findViewById(R.id.quantity);
                switch (checkedId){

                    case R.id.medium_check:
                        pos_price = mpriceArr[i];
                        double num = Double.parseDouble(quantity.getText().toString());
                        double price =  Double.parseDouble(pos_price);
                        double all = num * price ;
                        size = 1;
                        total.setText("EGP "+String.valueOf(all));
                        Toast.makeText(MealOrder.this, String.valueOf(size), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.large_check:
                        pos_price = lpriceArr[i];
                        num = Double.parseDouble(quantity.getText().toString());
                        price =  Double.parseDouble(pos_price);
                        all = num * price ;
                        size = 2;
                        total.setText("EGP "+String.valueOf(all));
                        Toast.makeText(MealOrder.this, String.valueOf(size), Toast.LENGTH_SHORT).show();
                        break;
                }


            }

        });





        ImageView img =(ImageView) findViewById(R.id.meal_img);
        img.setImageResource(imgs[i]);

        TextView mealname= (TextView) findViewById(R.id.meal_name);
        mealname.setText(namesArr[i]);

        TextView mealdesc= (TextView) findViewById(R.id.meal_desc);
        mealdesc.setText(descArr[i]);

        TextView mealprice= (TextView) findViewById(R.id.meal_price);
        mealprice.setText("EGP "+priceArr[i]);

        TextView mealprice_s= (TextView) findViewById(R.id.small_meal_price);
        TextView mealprice_m= (TextView) findViewById(R.id.medium_meal_price);
        TextView mealprice_l= (TextView) findViewById(R.id.large_meal_price);

        mealprice_s.setText("EGP "+priceArr[i]);
        mealprice_m.setText("EGP "+mpriceArr[i]);
        mealprice_l.setText("EGP "+lpriceArr[i]);

        TextView total=(TextView) findViewById(R.id.total);
        total.setText("EGP "+priceArr[i]);

        String [] MnamesArr= getResources().getStringArray(R.array.meals_names);
        for(int j=0;j<help.position.size();j++){
        if(help.type.get(j)==1 && MnamesArr[help.position.get(j)].equals(mealname.getText()) ){
            TextView quantity= (TextView) findViewById(R.id.quantity);
            quantity.setText(help.quantity.get(j));

        }
        }


        TextView increase = (TextView) findViewById(R.id.increase);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView quantity= (TextView) findViewById(R.id.quantity);
                int num =Integer.parseInt(quantity.getText().toString());
                ++num;
                quantity.setText(String.valueOf(num));
                TextView total=(TextView) findViewById(R.id.total);
                double price= Double.parseDouble(pos_price);
                double sum = num*price;
                String total_price =String.valueOf(sum);
                total.setText("EGP "+total_price);
            }
        });
        TextView decrease = (TextView) findViewById(R.id.decrease);
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView quantity= (TextView) findViewById(R.id.quantity);

                int num =Integer.parseInt(quantity.getText().toString());
                if (num>1){num--;
                    quantity.setText(String.valueOf(num));
                    TextView total=(TextView) findViewById(R.id.total);
                    Float sum = num*Float.parseFloat(pos_price);
                    total.setText("EGP "+String.valueOf(sum));}
            }
        });




        LinearLayout addToCard = (LinearLayout) findViewById(R.id.add_to_card);
        addToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView quantity= (TextView) findViewById(R.id.quantity);

                if(help.position.size()<1){
                    help.position.add(i);
                    help.quantity.add(quantity.getText().toString());
                    help.type.add(1);
                    help.size.add(size);

                }else{
                    int flag = help.position.size();
                    int[] index = new int[3];
                    int[] sizes = new int[3];
                    boolean same_meal_check = false ;
                    boolean meal_check = false ;
                    int right_index = 0;
                    for(int k = 0 ; k < flag ; k++){
                        if(mealname.getText().toString().equals(MnamesArr[help.position.get(k)]) && help.size.get(k) == 0){
                            System.out.println(mealname.getText().toString().equals(MnamesArr[help.position.get(k)]));
                            index[0] = k;
                            sizes[0] = 0;
                            meal_check = true;
                        }else if(mealname.getText().toString().equals(MnamesArr[help.position.get(k)]) && help.size.get(k) == 1){
                            index[1] = k;
                            sizes[1] = 1;
                            meal_check = true;
                        }else if(mealname.getText().toString().equals(MnamesArr[help.position.get(k)]) && help.size.get(k) == 2){
                            index[2] = k;
                            sizes[2] = 2;
                            meal_check = true;
                        }

                    }//end of for
                    if (meal_check){
                        for(int b =0 ;b<3;b++){
                            if(sizes[b]==size){
                                same_meal_check = true;
                                right_index = b;
                            }
                        }
                        if (same_meal_check){
                            help.quantity.set(index[right_index],quantity.getText().toString());
                        }else{
                            help.position.add(i);
                            help.quantity.add(quantity.getText().toString());
                            help.type.add(1);
                            help.size.add(size);

                        }


                    }else{

                        help.position.add(i);
                        help.quantity.add(quantity.getText().toString());
                        help.type.add(1);
                        help.size.add(size);

                    }




                        /*if(MnamesArr[i].equals(MnamesArr[help.position.get(k)]) && size == help.size.get(k)){
                            help.quantity.set(k,quantity.getText().toString());
                        }else if (MnamesArr[i].equals(MnamesArr[help.position.get(k)]) && size != help.size.get(k)){
                            help.position.add(i);
                            help.quantity.add(quantity.getText().toString());
                            help.type.add(1);
                            help.size.add(size);
                        }else if (!MnamesArr[i].equals(MnamesArr[help.position.get(k)]) ){
                            help.position.add(i);
                            help.quantity.add(quantity.getText().toString());
                            help.type.add(1);
                            help.size.add(size);

                        }*/





                    }






                finish();
            }
        });


    }
}