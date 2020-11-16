package com.example.domain.asset.usecase

import com.example.domain.asset.model.Asset
import com.example.domain.asset.repository.AssetRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CreateAssetUseCase(private val assetsRepository: AssetRepository ) {

    fun execute(name:String,descripcion:String,idUser:String,cantidad:Int,tipo:String): Single<Asset> {
        val asset=Asset("",name,cantidad,descripcion,idUser,tipo)
        return assetsRepository.createAsset(asset).subscribeOn(Schedulers.io())
    }

}