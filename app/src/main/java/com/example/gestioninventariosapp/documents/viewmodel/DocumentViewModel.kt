package com.example.gestioninventariosapp.documents.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.documents.model.Document
import com.example.domain.documents.usecase.GetDocumentsUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject




class DocumentViewModel
@Inject
constructor(
    private val getDocumentUseCase: GetDocumentsUseCase

) : BaseViewModel(){
    private val onsuccess= MutableLiveData<Boolean>()

   /* fun createDocument(name:String,descripcion:String,idUser:String,cantidad:Int,tipo:String){
        compositeDisposable.add(
            createDocumentUseCase.execute(name,descripcion,idUser,cantidad,tipo)
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


    }*/
    private val documentLiveData= MutableLiveData<List<Document>>()

    fun verData(idUser:String){
        compositeDisposable.add(
            getDocumentUseCase.execute(idUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Document>>() {
                    override fun onSuccess(t: List<Document>?) {
                        documentLiveData.value = t
                    }

                    override fun onError(e: Throwable?) {

                    }
                })

        )


    }

    fun getDocumentLiveData(): LiveData<List<Document>> = documentLiveData

    fun getOncreatedAssetData(): LiveData<Boolean> = onsuccess
}
