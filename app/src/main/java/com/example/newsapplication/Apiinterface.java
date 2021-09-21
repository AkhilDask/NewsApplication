package com.example.newsapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface {
    String Baseurl="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<Mainnews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apikey") String apikey
    );


    @GET("top-headlines")
    Call<Mainnews> getcategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apikey") String apikey
    );
}
