package com.example.gestioninvetariosapp.ui.assets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gestioninvetariosapp.data.Asset

class AssetViewModel:ViewModel() {

    private val assets_liveData= MutableLiveData<List<Asset>>()
    fun getArticleLiveData(): LiveData<List<Asset>> = assets_liveData
    init {

        assets_liveData.value=listOf(
            Asset("1","Leche","Cajas de a docena","Leche deslactosada en caja",10),
            Asset("2","Pintura Industrial","Tanques de Galon","Pintura para maquinas de pintar la calle",25),
            Asset("3","Alicates","Unidades","Alicates de ferreteria sencillos",15),
            Asset("4","Adornos Navideños","Cajas surtidas","Caja de adornos navideños variados",21),
            Asset("5","titulo5","pesaasddo","ricaurteasd",1),
            Asset("6","titulo6","pesaasddo","ricaurasdte",3)

            )
    }

}

