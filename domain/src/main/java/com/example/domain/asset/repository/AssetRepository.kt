package com.example.domain.asset.repository

import com.example.domain.asset.model.Asset
import io.reactivex.rxjava3.core.Single

interface AssetRepository {
    fun getAssets(): Single<List<Asset>>
}