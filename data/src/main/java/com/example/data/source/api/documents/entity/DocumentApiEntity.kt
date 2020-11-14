package com.example.data.source.api.documents.entity

import com.example.domain.documents.model.Document
import com.google.gson.annotations.SerializedName

data class DocumentApiEntity(
    @SerializedName("id")  val idDoc:String,
    @SerializedName("name") val nameDoc:String
)
fun DocumentApiEntity.mapToDomain(): Document=
    Document(
        idDoc,
         nameDoc?:"",
        nameDoc?:"",
        nameDoc?:"",
        idDoc.toInt()?:1,
        nameDoc?:"asd",
        nameDoc?:"asd"
    )


fun List<DocumentApiEntity>.mapToDomain() = this.map { it.mapToDomain() }