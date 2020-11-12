package com.example.gestioninventariosapp.assets.di

import com.example.data.repository.asset.AssetRepositoryImpl
import com.example.domain.asset.usecase.GetAssetsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AssetModule {

    @Singleton
    @Provides
    internal fun provideGetAssetUseCase(
        assetRepositoryImpl: AssetRepositoryImpl
    ): GetAssetsUseCase= GetAssetsUseCase(assetRepositoryImpl)

}