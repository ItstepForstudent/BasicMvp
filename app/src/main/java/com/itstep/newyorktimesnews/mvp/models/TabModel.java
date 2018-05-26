package com.itstep.newyorktimesnews.mvp.models;

import android.content.Context;

import com.itstep.newyorktimesnews.api.NewYorkApi;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.mvp.contracts.TabContract;
import com.itstep.newyorktimesnews.realmmodels.RealmNews;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

public class TabModel implements TabContract.model{
    @Inject
    NewYorkApi api;

    public TabModel(Context ctx){
        App.get(ctx).injector().inject(this);
    }




    @Override
    public Observable<List<RealmNews>> getSportNews(String type) {
        return Observable.fromCallable(()->{
            List<RealmNews> list = new LinkedList<>();
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            try{
             List<RealmNews> _storage = realm.where(RealmNews.class)
                    .equalTo("type",type)
                    .equalTo("category","Sports")
                    .findAll();
             list = realm.copyFromRealm(_storage);

            }catch (Exception e){}
            realm.commitTransaction();
            realm.close();
            return list;
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<RealmNews>> updateNews(String type) {
        return api.getNews("Sports", type)
                .map(n->n.getNews())
                .map(news->{
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();

                    try {
                        realm.where(RealmNews.class)
                                .equalTo("type", type)
                                .equalTo("category", "Sports").findAll().deleteAllFromRealm();
                    }catch (Exception ignored){}

                    List<RealmNews> _news= new LinkedList<>();
                    Observable.fromIterable(news).map(news1->new RealmNews(
                            news1.getTitle(),
                            news1.getMedia().get(0).getMediaMetadata().get(1).getUrl(),
                            news1.getUrl(),
                            "Sports",
                            type
                    )).subscribe(_news::add);

                    realm.copyToRealmOrUpdate(_news);

                    realm.commitTransaction();
                    realm.close();
                    return _news;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
