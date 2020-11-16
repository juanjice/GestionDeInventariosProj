package com.example.data.repository.asset

import com.example.data.source.api.assets.client.AssetApiClient
import com.example.data.source.api.assets.entity.mapToDomain
import com.example.domain.asset.model.Asset
import com.example.domain.asset.repository.AssetRepository
import io.reactivex.rxjava3.core.Single

class AssetRepositoryImpl (    private val assetApiClient:AssetApiClient):AssetRepository{
    override fun getAllAssets(idUser:String): Single<List<Asset>> =
        assetApiClient.getAssets(idUser)
            .map { it.mapToDomain() }


    override fun createAsset(asset: Asset): Single<Asset> =
        assetApiClient.createAsset(asset)
            .map { it.mapToDomain() }

}
