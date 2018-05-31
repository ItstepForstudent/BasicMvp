package com.itstep.newyorktimesnews.utils;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsHtmlPreProcessor {
    private String url;

    public NewsHtmlPreProcessor(String url) {
        this.url = url;
    }

    private String processing(Document elem){
        return elem.outerHtml();
    }


    public Observable<String> startProcessing(){
        return Observable.fromCallable(()->Jsoup.connect(url).get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(this::processing);
    }


}
