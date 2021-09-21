package com.example.newsapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiutilities {

    private static Retrofit retrofit=null;

    public static Apiinterface getApiInterface()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(Apiinterface.Baseurl).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Apiinterface.class);
    }
}
