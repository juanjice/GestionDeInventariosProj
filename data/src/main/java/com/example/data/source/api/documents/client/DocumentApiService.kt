package com.example.data.source.api.documents.client

import com.example.data.source.api.documents.entity.DocumentApiEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DocumentApiService {
    @GET("documents/user")
    fun getAllDocuments(@Query("idUser") isUser:String):Call<List<DocumentApiEntity>>
}