package com.itstep.newyorktimesnews.mvp.views;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.adapters.NewsRvArapter;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpFragmentView;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.mvp.contracts.TabContract;
import com.itstep.newyorktimesnews.realmmodels.RealmNews;
import com.itstep.newyorktimesnews.utils.Constants;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class TabViewFragment extends Fragment implements TabContract.view{

    private static final String CATEGORY_ARG = "param1";
    private static final String TYPE_ARG = "param2";

    protected TabContract.presenter presenter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public Observable<String> onCardClick(){
        return newsRvArapter.onItemClick();
    }

    @BindView(R.id.newsRV)
    RecyclerView newsRecycler;

    NewsRvArapter newsRvArapter = new NewsRvArapter();

    private void initRecycler(){
        newsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRecycler.setAdapter(newsRvArapter);
    }



    private String categoryNews;
    private String typeNews;

    public static TabViewFragment newInstance(String category, String type) {
        TabViewFragment fragment = new TabViewFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_ARG, category);
        args.putString(TYPE_ARG, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryNews = getArguments().getString(CATEGORY_ARG);
            typeNews = getArguments().getString(TYPE_ARG);
        }
        this.setRetainInstance(true);
        App.get(getContext()).injector().inject(this);
        injectPresenter();
    }
    @Inject @Named(Constants.Api.MOST_VIEWED_NEWS) TabContract.presenter mostViewedPresenter;
    @Inject @Named(Constants.Api.MOST_SHARED_NEWS) TabContract.presenter mostSharedPresenter;
    @Inject @Named(Constants.Api.MOST_MAILED_NEWS) TabContract.presenter mostMailedPresenter;

    public void injectPresenter(){
        switch (this.typeNews){
            case Constants.Api.MOST_VIEWED_NEWS:
                this.presenter = mostViewedPresenter;
                break;
            case Constants.Api.MOST_SHARED_NEWS:
                this.presenter=mostSharedPresenter;
                break;
            case Constants.Api.MOST_MAILED_NEWS:
                this.presenter=mostMailedPresenter;
                break;
        }
        mostViewedPresenter=mostSharedPresenter=mostMailedPresenter=null;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_layout,container,false);
        ButterKnife.bind(this,rootView);
        initRecycler();
        return rootView;
    }

    @Override
    public void showNews(List<RealmNews> newsList) {
        newsRvArapter.setNewsList(newsList);
    }
}
