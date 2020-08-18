package com.example.qlns_ver0406.Network;

import com.example.qlns_ver0406.Model.Message;
import com.example.qlns_ver0406.Model.MessageLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user/dangnhap")
    Call<MessageLogin> login(@Field("username") String username, @Field("password") String password);

    @GET("user/chamcong")
    Call<Message> getData(@Header("__atohrmak__") String accesskey);
}