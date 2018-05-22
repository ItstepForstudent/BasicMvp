package com.itstep.newyorktimesnews.di.modules;

import android.app.Application;
import android.content.Context;

import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;
import com.itstep.newyorktimesnews.mvp.presenters.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {
    protected final Application mApp;
    public MvpModule(Application app){
        mApp=app;
    }
    @Provides public Context provedeContext(){
        return mApp;
    }
    @Singleton @Provides public MainContract.presenter provideMainContractPresenter(Context ctx){
        return new MainPresenter(ctx);
    }
}
