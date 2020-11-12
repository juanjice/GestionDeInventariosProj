package com.example.data.source.api.documents.client

import com.example.data.source.api.documents.entity.DocumentApiEntity
import retrofit2.Call
import retrofit2.http.GET

interface DocumentApiService {
    @GET("/comments")
    fun getAllDocuments():Call<List<DocumentApiEntity>>
}