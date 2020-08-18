package com.example.qlns_ver0406.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageClient {
    private static Retrofit mRetrofit;
    private static String base_url = "http://nhansu.ddns.net/api/";

    public MessageClient(){}
    public static Retrofit getmRetrofitClient(){
        if (mRetrofit == null){
            mRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
