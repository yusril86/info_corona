package com.pareandroid.infocorona.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    private static final String BaSE_URL ="https://api.kawalcorona.com/";
    private static Retrofit retrofit;

        public static Retrofit getapi(){
            if (retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(BaSE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
}
