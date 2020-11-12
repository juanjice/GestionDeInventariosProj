package com.example.data.di

import com.example.data.repository.documents.DocumentRepositoryImpl
import com.example.data.source.api.documents.client.DocumentApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataDocumentsModule {
    @Singleton
    @Provides
    internal fun provideDocumentsRepository(
        documentApiClient: DocumentApiClient
    )=DocumentRepositoryImpl(documentApiClient)
}