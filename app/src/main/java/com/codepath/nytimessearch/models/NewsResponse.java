package com.codepath.nytimessearch.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lindseyl on 1/30/17.
 */

public class NewsResponse {

    @SerializedName("docs")
    List<News> newsList;

    // public constructor is necessary for collections
    public NewsResponse() {
        newsList = new ArrayList<News>();
    }

    public static NewsResponse parseJSON(String response) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Gson gson = gsonBuilder.create();
        NewsResponse newsResponse = gson.fromJson(response, NewsResponse.class);
        return newsResponse;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
