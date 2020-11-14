package com.example.data.di

import com.example.data.source.api.assets.client.AssetApiClient
import com.example.data.source.api.assets.client.AssetApiService
import com.example.data.source.api.documents.client.DocumentApiClient
import com.example.data.source.api.documents.client.DocumentApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataSourceApiModule {

    @Singleton
    @Provides
    internal fun provideRetrofit()=
        Retrofit.Builder()
            .baseUrl("https://us-central1-aspi-gestioninv.cloudfunctions.net/app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Singleton
    @Provides
    internal fun provideAssetApiClient(retrofit: Retrofit) =
        AssetApiClient(retrofit.create(AssetApiService::class.java))

    @Singleton
    @Provides
    internal  fun provideDocumentApiClient(retrofit:Retrofit)=
        DocumentApiClient(retrofit.create(DocumentApiService::class.java))

}