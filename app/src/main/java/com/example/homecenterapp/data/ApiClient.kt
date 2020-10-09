package com.example.homecenterapp.data

import com.example.homecenterapp.data.repository.InventarioApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient private constructor() {

    private val inventarioApi: InventarioApi

    fun getInventarioApi(): InventarioApi {
        return inventarioApi
    }

    companion object {
        private const val BASE_URL = "http://www.google.com"

        @get:Synchronized
        var instance: ApiClient? = null
            get() {
                if (field == null) {
                    field = ApiClient()
                }
                return field
            }
            private set
    }

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        inventarioApi = retrofit.create<InventarioApi>(InventarioApi::class.java)
    }
}