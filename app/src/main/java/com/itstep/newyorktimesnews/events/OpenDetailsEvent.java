package com.itstep.newyorktimesnews.events;

public class OpenDetailsEvent extends Event {
    String url;
    public OpenDetailsEvent(String name,String url) {
        super(name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
