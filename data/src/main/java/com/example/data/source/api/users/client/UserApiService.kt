package com.example.data.source.api.users.client

import com.example.data.source.api.assets.entity.AssetApiEntity
import com.example.data.source.api.users.entity.UserApiEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {
    @GET("users/by/{email}/password/{password}")
    fun getUser(@Path("email") email:String?,@Path("password") password:String?): Call<UserApiEntity>
}