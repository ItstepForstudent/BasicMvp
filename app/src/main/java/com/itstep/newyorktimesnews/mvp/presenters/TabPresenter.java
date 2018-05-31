package com.itstep.newyorktimesnews.mvp.presenters;

import android.content.Context;
import android.util.Log;

import com.itstep.newyorktimesnews.ViewModel.CategoryVM;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.events.SelectCategoryEvent;
import com.itstep.newyorktimesnews.utils.Constants;
import com.itstep.newyorktimesnews.utils.DataBus;
import com.itstep.newyorktimesnews.base.mvp.MvpPresenter;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.mvp.contracts.TabContract;
import com.itstep.newyorktimesnews.realmmodels.RealmNews;
import com.itstep.newyorktimesnews.events.OpenDetailsEvent;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class TabPresenter extends MvpPresenter<TabContract.view> implements TabContract.presenter {
    Context ctx;
    @Inject
    TabContract.model model;
    @Inject
    CategoryVM categoryVM;

    @Inject DataBus dataBus;

    List<RealmNews> newsList=null;
    String type;
    Disposable selectCatDisp;
    String category = "Sports";


    public TabPresenter(Context ctx,@Nullable String type) {
        this.ctx = ctx;
        this.type=type;
        App.get(ctx).injector().inject(this);


    }




    @Override
    public void attachView(Object view) {
        super.attachView(view);
        category = categoryVM.getCategory();
        updateNews();
        getView().onCardClick().subscribe(url->dataBus.sendEvent(new OpenDetailsEvent(Constants.EventNames.OPEN_DETAILS,url)));
        selectCatDisp = dataBus.getBus(Constants.EventNames.SELECT_CATEGORY)
                .map(e->(SelectCategoryEvent)e)
                .subscribe(e->{
                    newsList =null;
                    category = e.getCategory();
                    updateNews();
                });
    }

    public void updateNews() {
        if(newsList==null) {
            model.getSportNews(type,category).subscribe(n -> {
                getView().showNews(newsList = n);
                model.updateNews(type,category).subscribe(x -> getView().showNews(newsList = x),e->{});
            });
        }else
            getView().showNews(newsList);
    }

    @Override
    public void detachView() {
        super.detachView();
        if(selectCatDisp!=null) selectCatDisp.dispose();
    }
}
