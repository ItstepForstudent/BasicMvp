package com.itstep.newyorktimesnews.mvp.contracts;

import com.itstep.newyorktimesnews.base.mvp.IMvpPresenter;
import com.itstep.newyorktimesnews.base.mvp.MvpModel;
import com.itstep.newyorktimesnews.base.mvp.MvpView;
import com.itstep.newyorktimesnews.entities.News;

import java.util.List;

import io.reactivex.Observable;


public interface MainContract {
    interface view extends MvpView{
        void showMessage();
    }
    interface model extends MvpModel{
        Observable<List<News>> getSportViewNews();
    }
    interface presenter extends IMvpPresenter {

    }
}
