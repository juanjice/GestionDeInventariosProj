package com.example.domain.user.repository


import com.example.domain.user.model.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUser(user:User): Single<User>
}