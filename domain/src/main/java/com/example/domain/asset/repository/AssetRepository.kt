package com.example.domain.asset.repository

import com.example.domain.asset.model.Asset
import io.reactivex.rxjava3.core.Single

interface AssetRepository {
    fun getAllAssets(): Single<List<Asset>>
    fun createAsset(): Single<Asset>
}