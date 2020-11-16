package com.example.gestioninventariosapp.assets.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.asset.model.Asset
import com.example.domain.asset.usecase.CreateAssetUseCase
import com.example.domain.asset.usecase.GetAssetsUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class AssetsViewModel
@Inject
constructor(
    private val getAssetsUseCase: GetAssetsUseCase,
    private val createAssetUseCase: CreateAssetUseCase

) : BaseViewModel(){
    private val onsuccess=MutableLiveData<Boolean>()

    fun createAsset(name:String,descripcion:String,idUser:String,cantidad:Int,tipo:String){
        compositeDisposable.add(
            createAssetUseCase.execute(name,descripcion,idUser,cantidad,tipo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<Asset>() {

                    override fun onError(e: Throwable?) {
                        onsuccess.value=false

                    }

                    override fun onSuccess(t: Asset?) {
                        onsuccess.value=true
                        Log.i("este es el articulo",t.toString())
                    }
                }))


    }
    private val assetsLiveData= MutableLiveData<List<Asset>>()

    fun verData(idUser:String){
        compositeDisposable.add(
            getAssetsUseCase.execute(idUser)
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

    fun getOncreatedAssetData():LiveData<Boolean> = onsuccess
}

