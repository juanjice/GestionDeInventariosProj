package com.example.gestioninventariosapp.assets.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.source.api.assets.entity.AssetToApi
import com.example.domain.asset.model.Asset
import com.example.domain.asset.usecase.CreateAssetUseCase
import com.example.domain.asset.usecase.GetAssetsUseCase
import com.example.domain.documents.model.Document
import com.example.domain.documents.usecase.GetDocumentsUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class AssetsViewModel
@Inject
constructor(
    private val getAssetsUseCase: GetAssetsUseCase,
    private val getDocumentUseCase: GetDocumentsUseCase,
    private val createAssetUseCase: CreateAssetUseCase

) : BaseViewModel(){
    private val onsuccess=MutableLiveData<Boolean>()

    fun createAsset(name:String){
        compositeDisposable.add(
            createAssetUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Asset>() {

                    override fun onError(e: Throwable?) {
                        onsuccess.value=false
                    }

                    override fun onSuccess(t: Asset?) {
                        onsuccess.value=true
                    }
                }))


    }
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
        compositeDisposable.add(
            getDocumentUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Document>>(){
                    override fun onSuccess(t: List<Document>?) {
                        Log.e("lista de api",t.toString())
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("errorarse",e.toString())
                    }


                }
                )

        )

    }
    fun getAssetLiveData(): LiveData<List<Asset>> = assetsLiveData
    fun getOncreatedAssetData():LiveData<Boolean> = onsuccess
}

