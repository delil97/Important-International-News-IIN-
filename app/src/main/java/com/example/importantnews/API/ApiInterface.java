package com.example.importantnews.API;

import com.example.importantnews.Models.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("top-headlines")
    Call<Headlines> getHeadlines( // here we get the headlines
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<Headlines> getSpecificData( // here we get specific data according to users search
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );



}