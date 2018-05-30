package com.example.practice.inshort.modal

import retrofit2.Call;
import retrofit2.http.GET;


interface RequestInterface {
    @GET("news")
    fun getJSON(): Call<JSONResponse>
}