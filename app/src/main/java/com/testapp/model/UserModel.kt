package com.example.testapp.model

import java.io.Serializable

data class UserModel(
    val results: ArrayList<UserDetailData>? = ArrayList(),
    val info: InfoData? = InfoData()
)

data class UserDetailData(
    val gender: String? = "",
    val name: UserNameData? = UserNameData(),
    val location: UserLocationData? = UserLocationData(),
    val email: String? = "",
    val login: UserLoginData? = UserLoginData(),
    val dob: DOBData? = DOBData(),
    val registered: RegisteredData? = RegisteredData(),
    val phone: String? = "",
    val cell: String? = "",
    val id: IdData? = IdData(),
    val picture: PictureData? = PictureData(),
    val nat: String? = ""
) : Serializable

data class UserNameData(
    val title: String? = "",
    val first: String? = "",
    val last: String? = ""
) : Serializable

data class UserLocationData(
    val street: StreetData? = StreetData(),
    val city: String? = "",
    val state: String? = "",
    val country: String? = "",
    val postcode: String? = "",
    val coordinates: CoordinatesData? = CoordinatesData(),
    val timezone: TimeZoneData? = TimeZoneData()
) : Serializable

data class StreetData(
    val number: String? = "",
    val name: String? = ""
) : Serializable

data class CoordinatesData(
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0
) : Serializable

data class TimeZoneData(
    val offset: String? = "",
    val description: String? = ""
) : Serializable

data class UserLoginData(
    val uuid: String? = "",
    val username: String? = "",
    val password: String? = "",
    val salt: String? = "",
    val md5: String? = "",
    val sha1: String? = "",
    val sha256: String? = ""
) : Serializable

data class DOBData(
    val date: String? = "",
    val age: String? = ""
) : Serializable

data class RegisteredData(
    val date: String? = "",
    val age: String? = ""
) : Serializable

data class IdData(
    val name: String? = "",
    val value: String? = ""
) : Serializable

data class PictureData(
    val large: String? = "",
    val medium: String? = "",
    val thumbnail: String? = ""
) : Serializable

data class InfoData(
    val seed: String? = "",
    val results: String? = "",
    val page: String? = "",
    val version: String? = ""
) : Serializable

