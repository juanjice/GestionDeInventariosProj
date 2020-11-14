package com.example.data.di

import com.example.data.repository.AssetRepositoryImpl
import com.example.data.source.api.assets.client.AssetApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataAssetModule {

    @Singleton
    @Provides
    internal fun provideAssetsRepository(
        assetApiClient: AssetApiClient
    ) = AssetRepositoryImpl(assetApiClient)

}
