package com.itstep.newyorktimesnews.realmmodels;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by virus on 27.05.2018.
 */

@RealmClass
public class RealmNews extends RealmObject {
    String name;
    String imageUrl;
    String url;
    String category;
    String type;

    public RealmNews() {}

    public RealmNews(String name, String imageUrl, String url, String category, String type) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.url = url;
        this.category = category;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
