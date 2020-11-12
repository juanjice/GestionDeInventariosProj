package com.example.gestioninventariosapp.assets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.asset.model.Assets
import com.example.domain.asset.usecase.GetAssetsUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class AssetViewModel
@Inject
constructor(
    private val getAssetsUseCase: GetAssetsUseCase
) : BaseViewModel(){

    private val assetsLiveData= MutableLiveData<List<Assets>>()

    init {
        compositeDisposable.add(
            getAssetsUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Assets>>() {
                    override fun onSuccess(t: List<Assets>?) {
                        assetsLiveData.value = t
                    }

                    override fun onError(e: Throwable?) {

                    }
                })
        )

    }
    fun getArticleLiveData(): LiveData<List<Assets>> = assetsLiveData
}

