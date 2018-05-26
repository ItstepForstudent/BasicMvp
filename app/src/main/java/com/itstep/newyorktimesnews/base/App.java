package com.itstep.newyorktimesnews.base;

import android.app.Application;
import android.content.Context;

import com.itstep.newyorktimesnews.di.components.AppComponent;
import com.itstep.newyorktimesnews.di.components.DaggerAppComponent;
import com.itstep.newyorktimesnews.di.modules.MvpModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new  RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    public AppComponent injector(){
        if(component==null)
            component= DaggerAppComponent.builder()
                    .mvpModule(new MvpModule(this))
                    .build();
        return component;
    }

    public static App get(Context ctx){
        return (App) ctx.getApplicationContext();
    }
}
