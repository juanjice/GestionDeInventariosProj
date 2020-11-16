package com.example.data.source.api.users.client


import com.example.data.source.api.assets.entity.AssetToApi
import com.example.data.source.api.users.entity.CreateUserToApi
import com.example.data.source.api.users.entity.UserApiEntity
import retrofit2.Call
import retrofit2.http.*

interface UserApiService {
    @GET("users/real")
    fun getUser(
        @Query("email") email:String,
        @Query("password") password:String
    ): Call<UserApiEntity>

    @Headers("Content-Type: application/json")
    @POST("users/")
    fun createUser(@Body user: CreateUserToApi ):Call<UserApiEntity>

}