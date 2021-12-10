package com.example.testapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testapp.model.UserModel
import com.example.testapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRepository {

    val userModel = MutableLiveData<UserModel>()

    fun getUserApiCall(): MutableLiveData<UserModel> {

        val call = RetrofitClient.apiInterface.getUser()

        call.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<UserModel>,
                response: Response<UserModel>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()
                userModel.value = data
            }
        })

        return userModel
    }
}