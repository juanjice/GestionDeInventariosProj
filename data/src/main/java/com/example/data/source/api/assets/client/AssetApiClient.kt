package com.example.data.source.api.assets.client

import android.util.Log
import com.example.data.source.api.assets.entity.AssetApiEntity
import com.example.data.source.api.assets.entity.AssetToApi
import com.example.data.source.api.commons.CompletableCallback
import com.example.data.source.api.commons.SingleCallback
import com.example.domain.asset.model.Asset
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody

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
      //val jsonInString=gson.toJson(assetToApi)
        return Single.create{
            val call=apiService.createOneAsset(
                //assetToApi.name,
                //assetToApi.cantidad,
                //assetToApi.descripcion,
                //assetToApi.idUser,
                //assetToApi.tipo
                //Gson().toJson(assetToApi)
            assetToApi
            )
            val callback=SingleCallback<AssetApiEntity>(it)
            call.enqueue(callback)
        }
    }


}