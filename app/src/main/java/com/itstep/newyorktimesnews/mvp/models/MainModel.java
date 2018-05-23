package com.itstep.newyorktimesnews.mvp.models;

import android.content.Context;
import android.util.Log;

import com.itstep.newyorktimesnews.api.NewYorkApi;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.entities.ApiResponse;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;
import com.itstep.newyorktimesnews.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainModel implements MainContract.model {
    @Inject
    NewYorkApi api;

    public MainModel(Context ctx){
        App.get(ctx).injector().inject(this);
    }
    @Override
    public Observable<List<News>> getSportViewNews() {
        return api.getNews("Sports", Constants.Api.MOST_VIEWED_NEWS)
                .subscribeOn(Schedulers.io())
                .map(n->n.getNews())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext((ObservableSource<? extends List<News>>) x->new ArrayList<>());
    }

}
