package com.itstep.newyorktimesnews.mvp.contracts;

import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpModel;
import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpPresenter;
import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpView;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.realmmodels.RealmNews;

import java.util.List;

import io.reactivex.Observable;

public interface TabContract {
    interface view extends MvpView {
        void showNews(List<RealmNews> newsList);
        Observable<String> onCardClick();
    }
    interface model extends MvpModel {
        Observable<List<RealmNews>> getSportNews(String type, String category);
        Observable<List<RealmNews>> updateNews(String type, String category);
    }


    interface presenter extends MvpPresenter {

    }
}
