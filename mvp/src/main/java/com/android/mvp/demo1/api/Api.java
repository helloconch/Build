package com.android.mvp.demo1.api;

import com.android.mvp.demo1.entity.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String ENDPOINT = "http://api.icndb.com";

    @GET("/jokes/random/10")
    Observable<Response> getItems(@Query("firstName") String firstName,
                                  @Query("lastName") String lastName);
}
