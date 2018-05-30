package com.itstep.newyorktimesnews.mvp.presenters;

import android.content.Context;

import com.itstep.newyorktimesnews.base.App;

import com.itstep.newyorktimesnews.base.mvp.MvpPresenter;
import com.itstep.newyorktimesnews.events.OpenDetailsEvent;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;
import com.itstep.newyorktimesnews.utils.DataBus;

import org.reactivestreams.Subscription;

import javax.inject.Inject;
import javax.inject.Named;

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
    }

}
