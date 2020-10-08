package com.example.homecenterapp.domain

import com.example.homecenterapp.data.ItemDataSet
import com.example.homecenterapp.model.Item


class ItemUseCase {

    private val itemsDataSet = ItemDataSet()

    fun obtenerItems():List<Item>{
        return itemsDataSet.crearListaDeItems()
    }
}