package com.codepath.nytimessearch.models;


public class ApiResponse {

    public NewsResponse getResponse() {
        return response;
    }

    public void setResponse(NewsResponse response) {
        this.response = response;
    }

    public NewsResponse response;
    public String status;
    public String copyright;

}