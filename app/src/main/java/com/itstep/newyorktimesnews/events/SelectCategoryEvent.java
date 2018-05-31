package com.itstep.newyorktimesnews.events;

import com.itstep.newyorktimesnews.utils.Constants;

public class SelectCategoryEvent extends Event {
    String category;
    public SelectCategoryEvent(String category) {
        super(Constants.EventNames.SELECT_CATEGORY);
        this.category=category;

    }
    public String getCategory() {
        return category;
    }
}
