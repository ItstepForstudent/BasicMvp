package com.itstep.newyorktimesnews.mvp.presenters;

import android.content.Context;
import android.util.Log;

import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpPresenter;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.mvp.contracts.TabContract;
import com.itstep.newyorktimesnews.realmmodels.RealmNews;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class TabPresenter extends MvpPresenter<TabContract.view> implements TabContract.presenter {
    Context ctx;
    @Inject
    TabContract.model model;
    List<RealmNews> newsList=null;
    String type;

    public TabPresenter(Context ctx,@Nullable String type) {
        this.ctx = ctx;
        this.type=type;
        App.get(ctx).injector().inject(this);
    }

    @Override
    public void attachView(Object view) {
        super.attachView(view);
        updateNews();
    }

    public void updateNews() {
        if(newsList==null) {
            model.getSportNews(type).subscribe(n -> {
                getView().showNews(newsList = n);
                model.updateNews(type).subscribe(x -> getView().showNews(newsList = x),e->{});
            });

        }else
            getView().showNews(newsList);
    }
}
