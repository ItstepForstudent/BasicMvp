package com.itstep.newyorktimesnews.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.itstep.newyorktimesnews.mvp.views.TabViewFragment;
import com.itstep.newyorktimesnews.utils.Constants;

public class TabsAdapter extends FragmentStatePagerAdapter {
    final static int countTabs = 3;
    private String category ;

    public TabsAdapter(FragmentManager fm,String category) {
        super(fm);
        this.category = category;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return TabViewFragment.newInstance(category, Constants.Api.MOST_VIEWED_NEWS);
            case 1: return TabViewFragment.newInstance(category, Constants.Api.MOST_SHARED_NEWS);
            case 2: return TabViewFragment.newInstance(category, Constants.Api.MOST_MAILED_NEWS);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "MOST VIEWED";
            case 1: return "MOST SHARED";
            case 2: return "MOST MAILED";
        }
        return null;
    }

    @Override
    public int getCount() {
        return countTabs;
    }
}
