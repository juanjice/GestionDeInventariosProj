package com.example.data.source.api.users.client


import com.example.data.source.api.commons.SingleCallback
import com.example.data.source.api.users.entity.CreateUserToApi
import com.example.data.source.api.users.entity.UserApiEntity
import com.example.data.source.api.users.entity.UserToApi
import com.example.domain.user.model.User
import io.reactivex.rxjava3.core.Single

class UserApiClient(private val apiService: UserApiService) {


    fun isRealUser(email:String,password:String): Single<UserApiEntity> {
        val userToApi=UserToApi(email,password)
        return Single.create{
            val call=apiService.getUser(userToApi.email,userToApi.password)
            val callback=SingleCallback<UserApiEntity>(it)
            call.enqueue(callback)
        }
    }
    fun createUser(user:User):Single<UserApiEntity>{
        val createUserToApi=CreateUserToApi(user.name,user.email,user.password)
        return Single.create{
            val call=apiService.createUser(createUserToApi)
            val callback=SingleCallback<UserApiEntity>(it)
            call.enqueue(callback)
        }

    }



}