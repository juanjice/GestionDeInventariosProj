package com.example.data.source.api.assets.client

import com.example.data.source.api.assets.entity.AssetApiEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AssetApiService {
    @GET("assets")
    fun getAllAssets(): Call<List<AssetApiEntity>>
    //@Headers("Content-Type: application/json")
    //@POST("assets")
    //fun createAsset(@Body asset:AssetForApi):Call<AssetApiEntity>
}