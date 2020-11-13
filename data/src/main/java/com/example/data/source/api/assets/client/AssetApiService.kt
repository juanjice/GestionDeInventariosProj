package com.example.data.source.api.assets.client

import com.example.data.source.api.assets.entity.AssetApiEntity
import retrofit2.Call
import retrofit2.http.GET

interface AssetApiService {
    @GET("assets")
    fun getAllAssets(): Call<List<AssetApiEntity>>
}