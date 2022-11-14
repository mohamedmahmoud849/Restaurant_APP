package com.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrinkOrder extends AppCompatActivity {

    private LinearLayout page;
    private String pos_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_order);

        page =(LinearLayout)findViewById(R.id.order_layout);
        String [] namesArr= getResources().getStringArray(R.array.drinks_names);
        String [] priceArr= getResources().getStringArray(R.array.drinks_prices);
        int[] imgs= help.drinks_imgs;
        Bundle extras = getIntent().getExtras();
        int i =extras.getInt("position");

        pos_price = priceArr[i];

        ImageView img =(ImageView) findViewById(R.id.drink_img);
        img.setImageResource(imgs[i]);

        TextView drinkname= (TextView) findViewById(R.id.drink_name);
        drinkname.setText(namesArr[i]);


        TextView drinkprice= (TextView) findViewById(R.id.drink_price);
        drinkprice.setText("EGP "+priceArr[i]);

        TextView total=(TextView) findViewById(R.id.total);
        total.setText("EGP "+priceArr[i]);


        TextView increase = (TextView) findViewById(R.id.increase);
        increase.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
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
            @SuppressLint("SetTextI18n")
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


        LinearLayout btn = (LinearLayout) findViewById(R.id.add_to_card);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView quantity= (TextView) findViewById(R.id.quantity);

                help.position.add(i);
                help.quantity.add(quantity.getText().toString());
                help.type.add(0);
                help.size.add(-1);
                finish();

            }
        });

    }
}