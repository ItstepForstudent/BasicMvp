package com.itstep.newyorktimesnews.di.modules;

import com.itstep.newyorktimesnews.api.NewYorkApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
                .build();
    }

    @Provides
    @Singleton
    NewYorkApi provideNewYorkApi(Retrofit retrofit){
        return retrofit.create(NewYorkApi.class);
    }

}
