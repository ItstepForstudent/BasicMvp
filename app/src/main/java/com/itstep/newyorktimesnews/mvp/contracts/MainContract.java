package com.itstep.newyorktimesnews.mvp.contracts;


import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpModel;
import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpPresenter;
import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpView;
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
    interface presenter extends MvpPresenter {

    }
}
