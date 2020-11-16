package com.example.data.repository.documents

import com.example.data.source.api.documents.client.DocumentApiClient
import com.example.domain.documents.model.Document
import com.example.domain.documents.repository.DocumentRepository
import io.reactivex.rxjava3.core.Single
import com.example.data.source.api.documents.entity.mapToDomain

class DocumentRepositoryImpl(private val documentApiClient: DocumentApiClient): DocumentRepository {
    override fun getAllDocuments(idUser:String): Single<List<Document>> =
        documentApiClient.getDocuments(idUser)
            .map { it.mapToDomain() }


}