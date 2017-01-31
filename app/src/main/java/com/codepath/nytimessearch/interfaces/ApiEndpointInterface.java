package com.codepath.nytimessearch.interfaces;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lindseyl on 1/30/17.
 */

public interface ApiEndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("/users/{username}")
    Observable<User> getUser(@Path("username") String username);

    @GET("/group/{id}/users")
    Observable<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("/users/new")
    Observable<User> createUser(@Body User user);
}
