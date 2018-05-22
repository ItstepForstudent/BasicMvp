package com.itstep.newyorktimesnews.base.mvp;

public interface IMvpPresenter {
   void attachView(Object view);
   void detachView();
}
