package com.example.data.repository.asset

import com.example.data.source.api.assets.client.AssetApiClient
import com.example.data.source.api.assets.entity.mapToDomain
import com.example.domain.asset.model.Asset
import com.example.domain.asset.repository.AssetRepository
import io.reactivex.rxjava3.core.Single

class AssetRepositoryImpl (
    private val assetApiClient:AssetApiClient
):AssetRepository{
    override fun getAssets(): Single<List<Asset>> =
    assetApiClient.getAssets()
    .map { it.mapToDomain() }
}
