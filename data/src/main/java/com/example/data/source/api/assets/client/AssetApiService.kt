package com.example.data.source.api.assets.client

import com.example.data.source.api.assets.entity.AssetApiEntity
import com.example.data.source.api.assets.entity.AssetToApi
import com.example.domain.asset.model.Asset
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface AssetApiService {
    @GET("assets/user")
    fun getAllAssets(
        @Query("idUser") isUser:String
    ): Call<List<AssetApiEntity>>
    @Headers("Content-Type: application/json")
    @POST("assets")
    fun createOneAsset(@Body
                       asset: AssetToApi
    ):Call<AssetApiEntity>
   // @FormUrlEncoded
   // @POST("assets/")
   // fun createOneAsset(
   //     @Field("name") name:String,
   //     @Field("cantidad") cantidad:String,
   //     @Field("descripcion") descripcion:String,
   //     @Field("idUser") idUser:String,
   //     @Field("tipo") tipo:String
   //     ):Call<Any>

}