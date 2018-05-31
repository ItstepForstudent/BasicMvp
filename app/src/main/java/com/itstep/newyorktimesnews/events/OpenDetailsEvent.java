package com.itstep.newyorktimesnews.events;

import com.itstep.newyorktimesnews.utils.Constants;

public class OpenDetailsEvent extends Event {
    String url;
    public OpenDetailsEvent(Constants.EventNames name, String url) {
        super(name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
