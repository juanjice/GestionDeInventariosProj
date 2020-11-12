package com.example.data.source.api.assets.entity

import com.example.domain.asset.model.Asset

data class AssetApiEntity(
    val id: String,
    val name:String,
    val tipo:String,
    val descripcion:String,
    val cantidad:Int
)
fun AssetApiEntity.mapToDomain(): Asset =
    Asset(id,name,tipo,descripcion,cantidad)
fun List<AssetApiEntity>.mapToDomain(): List<Asset> =map { it.mapToDomain() }