package com.itstep.newyorktimesnews.mvp.presenters;

import android.content.Context;

import com.itstep.newyorktimesnews.base.App;

import com.itstep.newyorktimesnews.base.mvp.MvpPresenter;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;

import javax.inject.Inject;

public class MainPresenter extends MvpPresenter<MainContract.view> implements MainContract.presenter {
    Context ctx;
    @Inject MainContract.model model;
    public MainPresenter(Context ctx){
        this.ctx=ctx;
        App.get(ctx).injector().inject(this);
    }

    @Override
    public void attachView(Object view) {
        super.attachView(view);
        updateNews();
    }
    public void updateNews(){
        model.getSportViewNews().subscribe(n->getView().showNews(n));
    }
}
