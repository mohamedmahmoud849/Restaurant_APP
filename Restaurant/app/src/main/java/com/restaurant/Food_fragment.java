package com.restaurant;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class Food_fragment extends Fragment {

    private static final int PAGER_LAYOUTS_COUNT = 2;
    private food_list_fragment frag;
    private drinks_fragment frag2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_fragment, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ViewPager viewPager = view.findViewById(R.id.view_pager);

        viewPager.setAdapter(new FragmentStatePagerAdapter(
                Objects.requireNonNull(getFragmentManager()), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                frag =new food_list_fragment();
                frag2 =new drinks_fragment();
                switch (position){

                    case 0 : return frag;
                    case 1 : return frag2;
                }
                return frag;
            }
            @Override
            public int getCount() {
                return PAGER_LAYOUTS_COUNT;
            }
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0 : return "Meals";
                    case 1 : return "Drinks";
                }
                return super.getPageTitle(position);
            }
        });

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


}

