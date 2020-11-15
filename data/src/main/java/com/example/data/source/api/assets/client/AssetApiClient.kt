package com.example.data.source.api.assets.client


import com.example.data.source.api.assets.entity.AssetApiEntity
import com.example.data.source.api.assets.entity.AssetToApi
import com.example.data.source.api.commons.SingleCallback
import com.example.domain.asset.model.Asset
import io.reactivex.rxjava3.core.Single


class AssetApiClient(private val apiService: AssetApiService) {

    fun getAssets() =
        Single.create<List<AssetApiEntity>> {
            val call =apiService.getAllAssets()
            val callback= SingleCallback<List<AssetApiEntity>>(it)
            call.enqueue(callback)
        }
    //asset:Asset
    fun createAsset(asset: Asset):Single<AssetApiEntity>{
      val assetToApi=AssetToApi(asset.name,asset.cantidad.toString(),asset.descripcion,asset.idUser,asset.tipo)

        return Single.create{
            val call=apiService.createOneAsset(

            assetToApi
            )
            val callback=SingleCallback<AssetApiEntity>(it)
            call.enqueue(callback)
        }
    }


}