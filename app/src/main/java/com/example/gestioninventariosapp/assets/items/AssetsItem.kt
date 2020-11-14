package com.example.gestioninventariosapp.assets.items


import android.content.DialogInterface
import com.example.domain.asset.model.Asset
import com.example.gestioninventariosapp.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_assets.view.*


class AssetsItem(val asset: Asset): Item() {
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