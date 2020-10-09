package com.example.homecenterapp.data.repository

import com.example.homecenterapp.model.Item
import com.example.homecenterapp.model.response.ItemServerResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.Body
import retrofit2.http.Path

interface InventarioApi {

    // VERIFICAR SI Deferred SIRVE PARA HACER UPDATE, DELETE Y SAVE

    @GET("list_inventario")
    fun getListInventario(): Deferred<List<ItemServerResponse>>

    @GET("detail_inventario/{itemId}")
    fun getDetailInventario(@Path("itemId") itemId: String): Deferred<ItemServerResponse>

    @POST("create_inventario")
    fun saveItem(@Body request: Item): Deferred<ItemServerResponse>

    @POST("create_inventario")
    fun updateItem(@Body request: Item): Deferred<ItemServerResponse>

    @DELETE("eliminar_inventario")
    fun deleteItemInventario(@Path("itemId") itemId: String): Deferred<ItemServerResponse>

}
