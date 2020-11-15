package com.example.gestioninventariosapp.users.di

import com.example.data.repository.asset.AssetRepositoryImpl
import com.example.data.repository.user.UserRepositoryImpl
import com.example.domain.asset.usecase.CreateAssetUseCase
import com.example.domain.asset.usecase.GetAssetsUseCase
import com.example.domain.user.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserModule {

    @Singleton
    @Provides
    internal fun provideGetUserUseCase(
        userRepositoryImpl: UserRepositoryImpl
    )=GetUserUseCase(userRepositoryImpl)

}