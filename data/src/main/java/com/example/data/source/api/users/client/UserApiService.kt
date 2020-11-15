package com.example.data.source.api.users.client


import com.example.data.source.api.users.entity.UserApiEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {
    @GET("users/real")
    fun getUser(
        @Query("email") email:String,
        @Query("password") password:String
    ): Call<UserApiEntity>
}