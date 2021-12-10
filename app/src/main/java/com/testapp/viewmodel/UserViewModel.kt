package com.example.testapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.model.UserModel
import com.example.testapp.repository.UserRepository

class UserViewModel : ViewModel() {

    var userLiveData: MutableLiveData<UserModel>? = null

    fun getUser(): LiveData<UserModel>? {
        userLiveData = UserRepository.getUserApiCall()
        return userLiveData
    }

}