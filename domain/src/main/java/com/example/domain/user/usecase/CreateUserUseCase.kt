package com.example.domain.user.usecase

import com.example.domain.asset.model.Asset
import com.example.domain.user.model.User
import com.example.domain.user.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CreateUserUseCase(private val userRepository: UserRepository) {

    fun execute(name:String,email:String,password:String): Single<User> {
        val user= User("",name,email,password)
        return userRepository.createUserIfIsPosible(user).subscribeOn(Schedulers.io())

    }

}