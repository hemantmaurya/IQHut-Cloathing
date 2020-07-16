package com.example.iqhutclothing;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIs {

    String LOGINURL = "http://192.168.0.105/iqhutlogin/";
    @FormUrlEncoded
    @POST("login.php?")
    Call<String> getUserLogin(

            @Field("username") String username,
            @Field("password") String password
    );

}

