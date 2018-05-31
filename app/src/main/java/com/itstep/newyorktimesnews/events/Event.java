package com.itstep.newyorktimesnews.events;

import com.itstep.newyorktimesnews.utils.Constants;

public class Event {
    Constants.EventNames name;

    public Event(Constants.EventNames name) {
        this.name = name;
    }

    public Constants.EventNames getName() {
        return name;
    }

    public void setName(Constants.EventNames name) {
        this.name = name;
    }
}
