package com.itstep.newyorktimesnews.mvp.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.adapters.NewsRvArapter;
import com.itstep.newyorktimesnews.adapters.TabsAdapter;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpFragmentView;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragmentView extends MvpFragmentView<MainContract.presenter> implements MainContract.view{


    @BindView(R.id.sliding_tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager pages;


    private void initTabs(){
        TabsAdapter adapter = new TabsAdapter(getFragmentManager(),"Sports");
        pages.setAdapter(adapter);
        tabLayout.setupWithViewPager(pages);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_layout,container,false);
        ButterKnife.bind(this,rootView);
        App.get(getContext()).injector().inject(this);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initTabs();
        super.onViewCreated(view, savedInstanceState);
    }




}
