package com.example.data.repository.user


import com.example.data.source.api.users.client.UserApiClient
import com.example.data.source.api.users.entity.mapToDomain
import com.example.domain.user.model.User
import com.example.domain.user.repository.UserRepository
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl( private val userApiClient: UserApiClient): UserRepository {
    override fun getUser(email:String,password:String): Single<User> {
        return userApiClient.isRealUser(email,password)
            .map { it.mapToDomain() }
    }

    override fun createUserIfIsPosible(user: User): Single<User> {
        return userApiClient.createUser(user).map { it.mapToDomain() }
    }


}