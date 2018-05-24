package com.itstep.newyorktimesnews.mvp.models;

import android.content.Context;
import android.util.Log;

import com.itstep.newyorktimesnews.api.NewYorkApi;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.entities.ApiResponse;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;
import com.itstep.newyorktimesnews.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainModel implements MainContract.model {
    Context context;
    public MainModel(Context ctx){
        context=ctx;
    }

}
