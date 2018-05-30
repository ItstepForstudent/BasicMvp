package com.itstep.newyorktimesnews.utils;

import com.itstep.newyorktimesnews.events.Event;

import io.reactivex.subjects.PublishSubject;

public class DataBus {
    PublishSubject<Event> subject = PublishSubject.create();
    public void sendEvent(Event event){
        if(subject.hasObservers()){
            subject.onNext(event);
        }
    }
    public PublishSubject<Event> getBus(){
        return subject;
    }
}
