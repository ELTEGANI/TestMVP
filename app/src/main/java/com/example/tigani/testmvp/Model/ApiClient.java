package com.example.tigani.testmvp.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by altigani Gabir on 19/09/17.
 */

public class ApiClient
{
    public static ApiServiceLogin Apilogin()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://madret.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiServiceLogin.class);
    }

    public static ApiServiceRegisteration Apiregisteration()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://madret.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiServiceRegisteration.class);
    }

}