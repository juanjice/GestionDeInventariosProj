package com.example.domain.documents.model

data class Document(
    val id: String,
    val name:String,
    val tipo:String,
    val descripcion:String,
    val cantidad:Int,
    val fecha: String,
    val persona_asociada:String
)