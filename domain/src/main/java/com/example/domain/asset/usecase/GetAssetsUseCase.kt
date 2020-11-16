package com.example.domain.asset.usecase

import com.example.domain.asset.repository.AssetRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class GetAssetsUseCase(private val assetsRepository: AssetRepository) {

    fun execute(idUser:String) =
        assetsRepository.getAllAssets(idUser)
        .subscribeOn(Schedulers.io())
}