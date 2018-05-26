package com.itstep.newyorktimesnews.mvp.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.adapters.TabsAdapter;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpFragmentView;
import com.itstep.newyorktimesnews.mvp.contracts.DetailsContract;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by virus on 24.05.2018.
 */

public class DetailsFragmentView extends MvpFragmentView<DetailsContract.presenter> implements DetailsContract.view {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_layout,container,false);
        App.get(getContext()).injector().inject(this);
        ButterKnife.bind(this,rootView);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }
}
