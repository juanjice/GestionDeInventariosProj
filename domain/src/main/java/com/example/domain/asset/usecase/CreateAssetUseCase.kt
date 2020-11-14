package com.example.domain.asset.usecase

import com.example.domain.asset.model.Asset
import com.example.domain.asset.repository.AssetRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CreateAssetUseCase(private val assetsRepository: AssetRepository ) {

    fun execute(): Single<Asset> =
    assetsRepository.createAsset()
    .subscribeOn(Schedulers.io())

}