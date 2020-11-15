package com.example.data.di

import com.example.data.repository.asset.AssetRepositoryImpl
import com.example.data.repository.user.UserRepositoryImpl
import com.example.data.source.api.users.client.UserApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataUserModule {
    @Singleton
    @Provides
    internal fun provideAssetsRepository(
        userApiClient:UserApiClient
    ) = UserRepositoryImpl(userApiClient)

}