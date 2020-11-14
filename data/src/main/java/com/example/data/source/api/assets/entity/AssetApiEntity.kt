package com.example.data.source.api.assets.entity

import com.example.domain.asset.model.Asset

data class AssetApiEntity(
    val id: String,
    val idUser:String,
    val name:String,
    val tipo:String,
    val descripcion:String,
    val cantidad:String,
    val nameproveedor:String
)
fun AssetApiEntity.mapToDomain() =
    Asset(id, name, tipo, descripcion,cantidad.toInt())
fun List<AssetApiEntity>.mapToDomain() =map { it.mapToDomain() }