package com.example.data.source.api.assets.entity

import com.example.domain.asset.model.Asset

data class AssetApiEntity(
    val id: String,
    val name:String,
    val tipo:String,
    val descripcion:String,
    val cantidad:String,
    val idUser:String

)
fun AssetApiEntity.mapToDomain() =
    Asset(id,name,cantidad.toInt(),descripcion,idUser,tipo)
fun List<AssetApiEntity>.mapToDomain() =map { it.mapToDomain() }