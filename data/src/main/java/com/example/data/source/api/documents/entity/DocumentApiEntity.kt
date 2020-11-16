package com.example.data.source.api.documents.entity

import com.example.domain.documents.model.Document
import com.google.gson.annotations.SerializedName

data class DocumentApiEntity(
   val id:String,
   val name:String,
   val cantidad:String,
   val idUser :String,
   val fecha :String,
   val persona_asociada:String
)
fun DocumentApiEntity.mapToDomain(): Document=
    Document(
        id,
        name,
        cantidad.toInt(),
        idUser,
        fecha,
        persona_asociada
    )


fun List<DocumentApiEntity>.mapToDomain() = this.map { it.mapToDomain() }