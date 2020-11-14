package com.example.gestioninventariosapp.assets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.asset.model.Asset
import com.example.domain.asset.usecase.GetAssetsUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class AssetsViewModel
@Inject
constructor(
    private val getAssetsUseCase: GetAssetsUseCase
) : BaseViewModel(){

    private val assetsLiveData= MutableLiveData<List<Asset>>()

    init {
        compositeDisposable.add(
            getAssetsUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Asset>>() {
                    override fun onSuccess(t: List<Asset>?) {
                        assetsLiveData.value = t
                    }

                    override fun onError(e: Throwable?) {

                    }
                })
        )

    }
    fun getAssetLiveData(): LiveData<List<Asset>> = assetsLiveData
}

