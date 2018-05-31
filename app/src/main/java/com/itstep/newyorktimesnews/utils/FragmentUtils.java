package com.itstep.newyorktimesnews.utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentUtils {
    FragmentManager manager;
    String instance_tag;
    int rootViewId;

    public FragmentUtils(FragmentManager manager, int rootViewId,String instance_tag) {
        this.manager = manager;
        this.instance_tag=instance_tag;
        this.rootViewId = rootViewId;
    }
    public void replace(Fragment f,boolean backstack){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(rootViewId,f,instance_tag);
        if(backstack) transaction.addToBackStack(f.getTag());
        transaction.commit();
    }
    public Fragment getPreviousInstance(){
        return manager.findFragmentByTag(instance_tag);
    }

}
