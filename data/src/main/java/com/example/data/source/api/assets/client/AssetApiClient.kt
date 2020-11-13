package com.example.data.source.api.assets.client

import com.example.data.source.api.assets.entity.AssetApiEntity
import com.example.data.source.api.commons.SingleCallback
import io.reactivex.rxjava3.core.Single

class AssetApiClient(private val apiService: AssetApiService) {

    fun getAssets() =
        Single.create<List<AssetApiEntity>> {
            val call =apiService.getAllAssets()
            val callback= SingleCallback<List<AssetApiEntity>>(it)
            call.enqueue(callback)
        }

}