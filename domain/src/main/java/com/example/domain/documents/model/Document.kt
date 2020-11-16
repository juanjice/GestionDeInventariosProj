package com.example.domain.documents.model

data class Document(
    val id: String?,
    val name:String?,
    val cantidad:Int?,
    val idUser:String?,
    val fecha: String?,
    val persona_asociada:String?
)