package com.example.data.di

import com.example.data.source.api.assets.client.AssetApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceApiModule {

    @Singleton
    @Provides
    internal fun provideAssetApiClient() = AssetApiClient()

}