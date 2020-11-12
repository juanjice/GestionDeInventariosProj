package com.example.data.source.api.assets.client

import com.example.data.source.api.assets.entity.AssetsApiEntity
import io.reactivex.rxjava3.core.Single

class AssetsApiClient {

    fun getAssets(): Single<List<AssetsApiEntity>> =
        Single.create<List<AssetsApiEntity>> {
            it.onSuccess(
                listOf(
                    AssetsApiEntity("1","Leche","Cajas","Leche deslactosada",1),
                    AssetsApiEntity("2","Pintura Industrial","Tanques de Galon","Pintura para maquinas de pintar la calle",2),
                    AssetsApiEntity("3","Alicates","Unidades","Alicates de ferreteria sencillos", 3 ),
                    AssetsApiEntity("4","Adornos Navideños","Cajas surtidas","Caja de adornos navideños variados",4),
                    AssetsApiEntity("5", "titulo5", "pesaasddo", "ricaurteasd", 5),
                    AssetsApiEntity("6", "titulo6", "pesaasddo", "ricaurasdte", 6)

                )
            )
        }

}