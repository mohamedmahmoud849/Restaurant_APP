package com.restaurant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class help {

    public static  int[] imgs={R.drawable.first_meal,R.drawable.sec_meal,
            R.drawable.third_meal,R.drawable.fourth_meal,R.drawable.fifth_meal,R.drawable.six_meal
    };

    public static  int[] drinks_imgs={R.drawable.pepsi_can,R.drawable.pepsi_liter,R.drawable.pepsi_dliter,R.drawable.pepsi_dcan
           ,R.drawable.up_can,R.drawable.up_liter,R.drawable.water
    };

    public static ArrayList<Integer> position =new ArrayList<Integer>();
    public static ArrayList<String> quantity =new ArrayList<String>();
    public static ArrayList<Integer> type =new ArrayList<Integer>();
    public static ArrayList<Integer> size =new ArrayList<Integer>();
}
