package com.example.domain.documents.repository

import com.example.domain.documents.model.Document
import io.reactivex.rxjava3.core.Single

interface DocumentRepository {
    fun getAllDocuments(): Single<List<Document>>
}