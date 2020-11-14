package com.example.domain.asset.usecase

import com.example.domain.asset.repository.AssetRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class GetAssetsUseCase(private val assetsRepository: AssetRepository) {

    fun execute() =
        assetsRepository.getAllAssets()
        .subscribeOn(Schedulers.io())
}