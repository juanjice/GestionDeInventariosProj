package com.example.gestioninventariosapp.documents.di


import com.example.data.repository.documents.DocumentRepositoryImpl
import com.example.domain.documents.usecase.GetDocumentsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DocumentModule {

    @Singleton
    @Provides
    internal fun provideGetDocumentsUseCase(
        documentRepositoryImpl: DocumentRepositoryImpl
    ) = GetDocumentsUseCase(documentRepositoryImpl)

}