package com.example.homecenterapp.data.repository.extension

import com.example.homecenterapp.model.Item
import com.example.homecenterapp.model.response.ItemServerResponse

fun List<ItemServerResponse>.toItems(): List<Item> {
    val result = ArrayList<Item>()
    this.forEach {
        result.add(Item(it.nombre, it.descripcion,it.cantidad,
            it.tipo))
    }
    return result
}

fun ItemServerResponse.toItem(): Item {
    return Item(this.nombre, this.descripcion,this.cantidad,
        this.tipo)
}