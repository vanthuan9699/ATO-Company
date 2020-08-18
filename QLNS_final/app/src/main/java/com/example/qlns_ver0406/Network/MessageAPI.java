package com.example.qlns_ver0406.Network;

public class MessageAPI {
    public static ApiService getService(){
        return MessageClient.getmRetrofitClient().create(ApiService.class);
    }
}
