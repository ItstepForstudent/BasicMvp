package com.itstep.newyorktimesnews.base.mvp.interfaces;

/**
 * Created by virus on 22.05.2018.
 */

public interface MvpPresenter {
    void attachView(Object view);
    void detachView();
}
