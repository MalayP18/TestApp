package com.example.testapp.retrofit

import com.example.testapp.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/")
    fun getUser(): Call<UserModel>

}