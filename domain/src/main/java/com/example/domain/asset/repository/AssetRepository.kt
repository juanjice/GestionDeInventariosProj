package com.example.domain.asset.repository

import com.example.domain.asset.model.Asset
import io.reactivex.rxjava3.core.Single

interface AssetRepository {
    fun getAllAssets(idUser:String): Single<List<Asset>>
    fun createAsset(asset: Asset): Single<Asset>
}