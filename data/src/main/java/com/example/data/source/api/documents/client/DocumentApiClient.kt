package com.example.data.source.api.documents.client


import com.example.data.source.api.assets.entity.AssetApiEntity
import com.example.data.source.api.assets.entity.AssetToApi
import com.example.data.source.api.commons.SingleCallback
import com.example.data.source.api.documents.entity.DocumentApiEntity
import com.example.data.source.api.documents.entity.DocumentToApi
import com.example.domain.asset.model.Asset
import com.example.domain.documents.model.Document
import io.reactivex.rxjava3.core.Single


class DocumentApiClient(private val apiService: DocumentApiService) {

    fun getDocuments(idUser:String) =
        Single.create<List<DocumentApiEntity>> {
            val call =apiService.getAllDocuments(idUser)
            val callback=SingleCallback<List<DocumentApiEntity>>(it)
            call.enqueue(callback)
        }
    fun createDocument(document: Document):Single<DocumentApiEntity>{
        val documentToApi=
            DocumentToApi(document.name,document.cantidad.toString(),document.idUser,document.fecha,document.persona_asociada)
        return Single.create{
            val call=apiService.createOneDocument(
                documentToApi
            )
            val callback=SingleCallback<DocumentApiEntity>(it)
            call.enqueue(callback)
        }
    }

}