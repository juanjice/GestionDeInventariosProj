package com.example.domain.asset.usecase


import com.example.domain.asset.model.Assets
import com.example.domain.asset.repository.AssetsRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetAssetsUseCase(private val assetsRepository: AssetsRepository) {

    fun execute(): Single<List<Assets>> =
        assetsRepository.getAssets()
        .subscribeOn(Schedulers.io())
}