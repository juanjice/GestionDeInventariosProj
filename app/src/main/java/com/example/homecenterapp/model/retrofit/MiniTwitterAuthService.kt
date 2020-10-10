package com.example.homecenterapp.model.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.example.homecenterapp.model.authmodel.request.RequestLogin
import com.example.homecenterapp.model.authmodel.request.RequestSignup
import com.example.homecenterapp.model.authmodel.response.ResponseAuth

interface MiniTwitterAuthService {

    @POST("/auth/login")
    fun doLogin(@Body body: RequestLogin): Call<ResponseAuth>
    @POST("/auth/signup")
    fun doSignUp(@Body body: RequestSignup): Call<ResponseAuth>
}