package com.itstep.newyorktimesnews.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.itstep.newyorktimesnews.base.App;

import javax.inject.Inject;


public abstract class MvpActivityView<T extends IMvpPresenter> extends AppCompatActivity implements MvpView {
    @Inject
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
