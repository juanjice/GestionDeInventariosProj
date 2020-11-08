package com.example.gestioninvetariosapp.ui.assets.adapter.items

import com.example.gestioninvetariosapp.data.Asset
import com.example.homecenterapp.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_assets.view.*


class AssetsItems(val asset: Asset): Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
       viewHolder.itemView.apply{
           textViewTittleAsset.text=asset.name
           textViewDescAssets.text=asset.descripcion
           textViewTotalAssets.text=asset.cantidad.toString()
       }
    }

    override fun getLayout()= R.layout.list_item_assets
}