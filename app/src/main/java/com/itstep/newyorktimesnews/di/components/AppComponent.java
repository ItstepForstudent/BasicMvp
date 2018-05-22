package com.itstep.newyorktimesnews.di.components;


import com.itstep.newyorktimesnews.base.mvp.IMvpPresenter;
import com.itstep.newyorktimesnews.base.mvp.MvpActivityView;
import com.itstep.newyorktimesnews.di.modules.ApiModule;
import com.itstep.newyorktimesnews.di.modules.MvpModule;
import com.itstep.newyorktimesnews.mvp.presenters.MainPresenter;
import com.itstep.newyorktimesnews.mvp.views.MainActivityView;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MvpModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MainActivityView activityView);
    void inject(MainPresenter presenter);

}
