package com.example.homecenterapp.domain

import com.example.homecenterapp.data.ApiClient
import com.example.homecenterapp.data.MockItemDataSet
import com.example.homecenterapp.model.Item
import com.example.homecenterapp.model.response.ItemServerResponse
import kotlinx.coroutines.Deferred

class ItemUseCase {

    // VERIFICAR SI Deferred SIRVE PARA HACER UPDATE, DELETE Y SAVE

    private val itemsDataSet = MockItemDataSet()
    private val apiClient = ApiClient.instance

    fun getInventarioListMock(): List<ItemServerResponse>? {
        return itemsDataSet.crearListaDeItems()
    }

    fun getInventarioList(): Deferred<List<ItemServerResponse>>? {
        return apiClient?.getInventarioApi()?.getListInventario()
    }

    fun getItemDetail(itemId: String): Deferred<ItemServerResponse>? {
        return apiClient?.getInventarioApi()?.getDetailInventario(itemId)
    }

    fun saveItem(item: Item): Deferred<ItemServerResponse>? {
        return apiClient?.getInventarioApi()?.saveItem(item)
    }

    fun deleteItem(itemId: String): Deferred<ItemServerResponse>? {
        return apiClient?.getInventarioApi()?.deleteItemInventario(itemId)
    }

    fun updateItem(item: Item): Deferred<ItemServerResponse>? {
        return apiClient?.getInventarioApi()?.updateItem(item)
    }
}