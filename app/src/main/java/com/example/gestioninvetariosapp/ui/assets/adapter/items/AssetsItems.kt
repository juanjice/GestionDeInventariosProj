package com.example.gestioninvetariosapp.ui.assets.adapter.items

<<<<<<< Updated upstream:app/src/main/java/com/example/gestioninvetariosapp/ui/assets/adapter/items/AssetsItems.kt
import com.example.gestioninvetariosapp.data.Asset
import com.example.homecenterapp.R
=======
import com.example.domain.asset.model.Assets
import com.example.gestioninventariosapp.R
>>>>>>> Stashed changes:app/src/main/java/com/example/gestioninventariosapp/assets/item/AssetsItems.kt
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_assets.view.*


class AssetsItems(val asset: Asset): Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
       viewHolder.itemView.apply{
           textViewTittleAsset.text=asset.name
           textViewDescAssets.text=asset.descripcion
           textViewTotalAssets.text=asset.cantidad.toString()
           setOnClickListener {
               //TODO Add action
           }
       }
    }

    override fun getLayout()= R.layout.list_item_assets
}