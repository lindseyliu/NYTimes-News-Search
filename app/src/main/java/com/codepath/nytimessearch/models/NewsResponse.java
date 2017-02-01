package com.codepath.nytimessearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lindseyl on 1/30/17.
 */

public class NewsResponse {

    public Meta meta;
    @SerializedName("docs")
    List<News> newsList = null;

    // public constructor is necessary for collections
    public NewsResponse() {
        newsList = new ArrayList<News>();
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
