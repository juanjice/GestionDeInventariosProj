package com.example.data.source.api.assets.client

import com.example.data.source.api.assets.entity.AssetApiEntity
import io.reactivex.rxjava3.core.Single

class AssetApiClient {

    fun getAssets(): Single<List<AssetApiEntity>> =
        Single.create<List<AssetApiEntity>> {
            it.onSuccess(
                listOf(
                    AssetApiEntity("1","Leche","Cajas","Leche deslactosada",1),
                    AssetApiEntity("2","Pintura Industrial","Tanques de Galon","Pintura para maquinas de pintar la calle",2),
                    AssetApiEntity("3","Alicates","Unidades","Alicates de ferreteria sencillos", 3 ),
                    AssetApiEntity("4","Adornos Navideños","Cajas surtidas","Caja de adornos navideños variados",4),
                    AssetApiEntity("5", "titulo5", "pesaasddo", "ricaurteasd", 5),
                    AssetApiEntity("6", "titulo6", "pesaasddo", "ricaurasdte", 6)

                )
            )
        }

}