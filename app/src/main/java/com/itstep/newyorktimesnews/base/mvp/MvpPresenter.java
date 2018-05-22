package com.itstep.newyorktimesnews.base.mvp;


import com.itstep.newyorktimesnews.base.mvp.MvpView;

public class MvpPresenter<T extends MvpView> implements IMvpPresenter {

    private T view=null;
    private boolean attached =false;


    @Override
    public void attachView(Object view) {
        this.view = (T)view;
        attached=true;
    }

    public void detachView(){
        this.view = null;
        attached = false;
    }

    public T getView() {
        return view;
    }

    public boolean isAttached() {
        return attached;
    }
}
