package com.example.homecenterapp.data

import com.example.homecenterapp.model.Item
import com.example.homecenterapp.model.response.ItemServerResponse

class MockItemDataSet {

    fun crearListaDeItems(): List<ItemServerResponse> {
        return listOf(
            ItemServerResponse("Silla", "Es una silla", 25, "para sentarse"),
            ItemServerResponse("Comedor","Mesa para comer",80,"Mesa redonda de camelot"),
            ItemServerResponse("Escritorio","xxxxxx",30,"en forma de l")
        )
    }
}