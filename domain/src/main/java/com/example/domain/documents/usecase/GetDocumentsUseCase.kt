package com.example.domain.documents.usecase

import com.example.domain.documents.model.Document
import com.example.domain.documents.repository.DocumentRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetDocumentsUseCase(private val documentRepository: DocumentRepository) {

    fun execute(idUser:String): Single<List<Document>> =
    documentRepository.getAllDocuments(idUser)
        .subscribeOn(Schedulers.io())

}