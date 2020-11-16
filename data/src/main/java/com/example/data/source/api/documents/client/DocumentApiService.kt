package com.example.data.source.api.documents.client

import com.example.data.source.api.assets.entity.AssetApiEntity
import com.example.data.source.api.documents.entity.DocumentApiEntity
import com.example.data.source.api.documents.entity.DocumentToApi
import retrofit2.Call
import retrofit2.http.*

interface DocumentApiService {
    @GET("documents/user")
    fun getAllDocuments(@Query("idUser") isUser:String):Call<List<DocumentApiEntity>>
    @Headers("Content-Type: application/json")
    @POST("documents")
    fun createOneDocument(@Body
                       document: DocumentToApi
    ):Call<DocumentApiEntity>
}