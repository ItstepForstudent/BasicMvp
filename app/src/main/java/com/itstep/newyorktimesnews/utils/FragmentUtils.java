package com.itstep.newyorktimesnews.utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentUtils {
    FragmentManager manager;
    int rootViewId;

    public FragmentUtils(FragmentManager manager, int rootViewId) {
        this.manager = manager;
        this.rootViewId = rootViewId;
    }
    public void replace(Fragment f,boolean backstack){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(rootViewId,f);
        if(backstack) transaction.addToBackStack(f.getTag());
        transaction.commit();
    }

}
