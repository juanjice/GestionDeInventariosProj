package com.example.data.source.api.documents.client


import com.example.data.source.api.commons.SingleCallback
import com.example.data.source.api.documents.entity.DocumentApiEntity
import io.reactivex.rxjava3.core.Single


class DocumentApiClient(private val apiService: DocumentApiService) {

    fun getDocuments(idUser:String) =
        Single.create<List<DocumentApiEntity>> {
            val call =apiService.getAllDocuments(idUser)
            val callback=SingleCallback<List<DocumentApiEntity>>(it)
            call.enqueue(callback)
        }

}