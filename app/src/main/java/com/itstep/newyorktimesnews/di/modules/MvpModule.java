package com.itstep.newyorktimesnews.di.modules;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;
import com.itstep.newyorktimesnews.mvp.contracts.TabContract;
import com.itstep.newyorktimesnews.mvp.models.MainModel;
import com.itstep.newyorktimesnews.mvp.models.TabModel;
import com.itstep.newyorktimesnews.mvp.presenters.MainPresenter;
import com.itstep.newyorktimesnews.mvp.presenters.TabPresenter;
import com.itstep.newyorktimesnews.utils.Constants;

import javax.inject.Named;
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
    @Provides @Singleton public MainContract.model injectMainContractModel(Context ctx){
        return new MainModel(ctx);
    }


    @Provides @Singleton @Named(Constants.Api.MOST_MAILED_NEWS)
    public TabContract.presenter provideMailedTabPresenter(Context context){
        Log.v("__TAG","Instance mailed");
        return new TabPresenter(context,Constants.Api.MOST_MAILED_NEWS);
    }
    @Provides @Singleton @Named(Constants.Api.MOST_SHARED_NEWS)
    public TabContract.presenter provideSharedTabPresenter(Context context){
        Log.v("__TAG","Instance shared");

        return new TabPresenter(context,Constants.Api.MOST_SHARED_NEWS);
    }
    @Provides @Singleton @Named(Constants.Api.MOST_VIEWED_NEWS)
    public TabContract.presenter provideViewedTabPresenter(Context context){
        Log.v("__TAG","Instance viewed");

        return new TabPresenter(context,Constants.Api.MOST_VIEWED_NEWS);
    }
    @Provides @Singleton
    public TabContract.presenter provideTabPresenter(@Named(Constants.Api.MOST_MAILED_NEWS) TabContract.presenter presenter){
        return presenter;
    }

    @Provides @Singleton
    public TabContract.model provideTabContractModel(Context context){
        return new TabModel(context);
    }


}
