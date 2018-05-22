package com.itstep.newyorktimesnews.mvp.models;

import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;

import java.util.List;

import io.reactivex.Observable;

public class MainModel implements MainContract.model {

    @Override
    public Observable<List<News>> getSportViewNews() {
        return null;
    }
}
