package com.example.gestioninventariosapp.documents.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.documents.model.Document
import com.example.domain.documents.usecase.CreateDocumentUseCase
import com.example.domain.documents.usecase.GetDocumentsUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject




class DocumentViewModel
@Inject
constructor(
    private val createDocumentUseCase: CreateDocumentUseCase,
    private val getDocumentUseCase: GetDocumentsUseCase

) : BaseViewModel(){
    private val onsuccess= MutableLiveData<Boolean>()

    fun createDocument(name:String?,cantidad:Int?,idUser:String?,fecha:String?,persona_asoc:String?){
        compositeDisposable.add(
            createDocumentUseCase.execute(name,cantidad,idUser,fecha,persona_asoc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<Document>() {

                    override fun onError(e: Throwable?) {
                        onsuccess.value=false
                        Log.i("no se creo por este motivo",e.toString())

                    }
                    override fun onSuccess(t: Document?) {
                        onsuccess.value=true
                        Log.i("se creo ",t.toString())
                    }
                }))
    }
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

    fun getOncreatedDocumentData(): LiveData<Boolean> = onsuccess
}
