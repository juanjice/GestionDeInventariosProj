package com.example.gestioninventariosapp.users.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.asset.model.Asset
import com.example.domain.user.model.User
import com.example.domain.user.usecase.GetUserUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class UserViewModel
@Inject
constructor(
   private val getUserUseCase: GetUserUseCase

) : BaseViewModel(){
    private val existeLiveData= MutableLiveData<User>()
    private val usersErrorLiveData = MutableLiveData<Unit>()

    fun verifyaccount(email:String,password:String){
        compositeDisposable.add(
            getUserUseCase.execute(email,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<User>() {
                    override fun onError(e: Throwable?) {
                       usersErrorLiveData.value=Unit
                    }

                    override fun onSuccess(t: User?) {
                        existeLiveData.value=t
                    }
                }))
    }

    fun onVeryfiedAccount(): LiveData<User> = existeLiveData
}