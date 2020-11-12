package com.example.data.source.api.documents.entity

import com.example.domain.documents.model.Document
import com.google.gson.annotations.SerializedName

data class DocumentApiEntity(
    val postId:Int,
    @SerializedName("id")  val idDoc:Int,
    @SerializedName("name") val nameDoc:String,
    val email:String,
    @SerializedName("body") val contenido:String
)
fun DocumentApiEntity.mapToDomain(): Document=
    Document(
        idDoc.toString(),
         nameDoc?:"",
        nameDoc?:"",
        nameDoc?:"",
        postId?:12,
        contenido,
        email

    )


fun List<DocumentApiEntity>.mapToDomain() = this.map { it.mapToDomain() }