package com.example.domain.asset.usecase

import com.example.domain.asset.repository.AssetRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class CreateAssetUseCase(private val assetRepository: AssetRepository ) {

    //fun execute() =assetRepository.createAsset()
      //  .susbscribeOn(Schedulers.io())

}