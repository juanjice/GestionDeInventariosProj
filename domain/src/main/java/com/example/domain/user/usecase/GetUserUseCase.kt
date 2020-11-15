package com.example.domain.user.usecase


import com.example.domain.asset.model.Asset
import com.example.domain.user.model.User
import com.example.domain.user.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetUserUseCase(private val userRepository: UserRepository) {

    fun execute(email:String,password:String): Single<User>{

        return userRepository.getUser(email,password).subscribeOn(Schedulers.io())

    }

}