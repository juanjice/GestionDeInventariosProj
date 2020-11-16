package com.example.data.source.api.users.entity

import com.example.domain.asset.model.Asset
import com.example.domain.user.model.User

data class UserApiEntity(
    val id:String?,
    val name:String,
    val email:String,
    val password:String

)
fun UserApiEntity.mapToDomain() =
    User(id?:"",name?:"",email,password)
fun List<UserApiEntity>.mapToDomain()=map { it.mapToDomain() }