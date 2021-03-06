package com.itstep.newyorktimesnews.base.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpPresenter;
import com.itstep.newyorktimesnews.base.mvp.interfaces.MvpView;

import javax.inject.Inject;

public abstract class MvpFragmentView<T extends MvpPresenter>extends Fragment implements MvpView {

    @Inject protected T presenter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        presenter.detachView();
        presenter = null;
        super.onDestroyView();
    }


}
