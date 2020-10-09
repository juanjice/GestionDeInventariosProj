package com.example.homecenterapp.model.response

import com.google.gson.annotations.SerializedName


data class ItemServerResponse(
    @SerializedName("nombre") val nombre: String = "",
    @SerializedName("descripcion") val descripcion: String = "",
    @SerializedName("cantidad") val cantidad: Int = 0,
    @SerializedName("tipo") val tipo: String = ""
)


