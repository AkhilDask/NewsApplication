package com.example.newsapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tab;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tab=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new Homefragment();
            case 1:
                return new Sportsfragment();
            case 2:
                return new Healthfragment();
            case 3:
                return new Sciencefragment();
            case 4:
                return new Entertainmentfragment();
            case 5:
                return new Technologyfragment();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tab;
    }
}
