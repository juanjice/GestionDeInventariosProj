package com.example.domain.documents.usecase


import com.example.domain.documents.model.Document
import com.example.domain.documents.repository.DocumentRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CreateDocumentUseCase(private val documentRepository: DocumentRepository) {

    fun execute(name:String?,cantidad:Int?,idUser:String?,fecha: String?,persona_asociada:String?): Single<Document> {
        val document= Document("",name,cantidad,idUser,fecha,persona_asociada)
        return documentRepository.createDocument(document).subscribeOn(Schedulers.io())
    }

}