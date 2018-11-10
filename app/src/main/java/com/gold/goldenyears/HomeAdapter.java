package com.gold.goldenyears;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

public class HomeAdapter extends FragmentStatePagerAdapter {

    final int NUM_PAGES = 4;
    final CharSequence[] tabTitles = {"Home", "Estimate", "Advise", "Budget"};


    public HomeAdapter(FragmentManager manager) {
        super(manager);
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeContent();
            case 1:
                return new EstimateContent();
            case 2:
                return new AdviseContent();
            case 3:
                return new BudgetContent();
            default:
                return null;
        }

    }

    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
