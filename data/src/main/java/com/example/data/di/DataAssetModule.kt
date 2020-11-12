package com.example.data.di

import com.example.data.repository.AssetsRepositoryImpl
import com.example.data.source.api.assets.client.AssetsApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataAssetModule {

    @Singleton
    @Provides
    internal fun provideAssetsRepository(
        assetApiClient: AssetsApiClient
    ): AssetsRepositoryImpl = AssetsRepositoryImpl(assetApiClient)

}
