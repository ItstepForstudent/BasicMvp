package com.itstep.newyorktimesnews.mvp.presenters;

import android.content.Context;

import com.itstep.newyorktimesnews.base.mvp.MvpPresenter;
import com.itstep.newyorktimesnews.mvp.contracts.DetailsContract;

import javax.inject.Inject;

/**
 * Created by virus on 24.05.2018.
 */

public class DetailsPresenter extends MvpPresenter implements DetailsContract.presenter {

    Context context;

    @Inject
    public DetailsPresenter(Context context){
        this.context=context;
    }
}
