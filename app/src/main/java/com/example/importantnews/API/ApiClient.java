package com.example.importantnews.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://newsapi.org/v2/"; // the api source, where all the information comes from
    private static ApiClient apiClient;
    private static Retrofit retrofit;

    private ApiClient(){ // the client
        // retrofit class: is where we’ll create a Retrofit instance
        // and define the base URL that our app will use for all of its HTTP requests
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){//method which can be used by only one thread at a time.
        if (apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }


    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }
}