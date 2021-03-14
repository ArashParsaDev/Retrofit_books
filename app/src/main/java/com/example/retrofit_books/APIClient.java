package com.example.retrofit_books;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    //gabel fahm kardan json baraye retrofit

    public static Retrofit retrofit ;

    public static Retrofit getApiClient(String url){

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
