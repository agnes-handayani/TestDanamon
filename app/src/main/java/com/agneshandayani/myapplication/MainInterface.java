package com.agneshandayani.myapplication;

import com.agneshandayani.myapplication.POJO.ResponseItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface MainInterface {
@GET("photos")
    Call<ResponseItem> getlist();

}
