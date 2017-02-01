package com.codepath.nytimessearch.interfaces;

import com.codepath.nytimessearch.models.ApiResponse;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by lindseyl on 1/30/17.
 */

public interface ApiEndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("articlesearch.json")
    Observable<ApiResponse> getResponse(@QueryMap Map<String, String> filters);
    // Calling with foo.list(ImmutableMap.of("foo", "bar", "kit", "kat")) yields /search?foo=bar&kit=kat.
}
