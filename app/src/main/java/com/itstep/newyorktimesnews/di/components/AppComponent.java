package com.itstep.newyorktimesnews.di.components;

import com.itstep.newyorktimesnews.di.modules.ApiModule;
import com.itstep.newyorktimesnews.di.modules.MvpModule;
import com.itstep.newyorktimesnews.mvp.models.MainModel;
import com.itstep.newyorktimesnews.mvp.models.TabModel;
import com.itstep.newyorktimesnews.mvp.presenters.MainPresenter;
import com.itstep.newyorktimesnews.mvp.presenters.TabPresenter;
import com.itstep.newyorktimesnews.mvp.views.MainActivityView;
import com.itstep.newyorktimesnews.mvp.views.MainFragmentView;
import com.itstep.newyorktimesnews.mvp.views.TabViewFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MvpModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MainActivityView activityView);
    void inject(MainFragmentView fragmentView);
    void inject(MainPresenter presenter);
    void inject(MainModel model);

    void inject(TabModel target);
    void inject(TabPresenter target);
    void inject(TabViewFragment target);

}
