package com.example.gestioninventariosapp.users.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.asset.model.Asset
import com.example.domain.user.model.User
import com.example.domain.user.usecase.CreateUserUseCase
import com.example.domain.user.usecase.GetUserUseCase
import com.example.gestioninventariosapp.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class UserViewModel
@Inject
constructor(
   private val getUserUseCase: GetUserUseCase,
   private val createUserUseCase: CreateUserUseCase

) : BaseViewModel(){
    private val existeLiveData= MutableLiveData<User>()

    fun verifyaccount(email:String,password:String){
        compositeDisposable.add(
            getUserUseCase.execute(email,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<User>() {
                    override fun onError(e: Throwable?) {
                        Log.e(" error uiser from service", e.toString())
                    }

                    override fun onSuccess(t: User?) {
                        Log.e("List user service", t.toString())
                        existeLiveData.value=t
                    }
                }))
    }
    private val createExistLiveData= MutableLiveData<User>()

    fun createUserIfNoExist(name:String,email: String,password: String){
        compositeDisposable.add(
            createUserUseCase.execute(name,email,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<User>() {

                    override fun onError(e: Throwable?) {
                        Log.e(" error uiser from service", e.toString())
                    }

                    override fun onSuccess(t: User?) {
                        createExistLiveData.value=t
                    }
                }))


    }
    fun onVeryfiedCreateAccount():LiveData<User> = createExistLiveData
    fun onVeryfiedAccount(): LiveData<User> = existeLiveData
}