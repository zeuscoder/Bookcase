package com.zeus.bookcase.app.api;

import com.zeus.bookcase.app.model.GitModel;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by zeus_coder on 2015/10/2.
 */
public interface MyAPI {

    @GET("/users/{user}")
    public void getFeed(@Path("user")String user, retrofit.Callback<GitModel> response);
}
