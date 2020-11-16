package com.example.gestioninventariosapp.assets.items



import android.os.Bundle
import androidx.navigation.findNavController
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
           textViewTypeAsset.text=asset.tipo.toString()
           val args = Bundle().apply {
               putString("name", asset.name)
               putInt("cantidad",asset.cantidad)
               putString("idUser", asset.idUser)
           }

           output_asset_button.setOnClickListener{
               findNavController().navigate(R.id.action_assets_to_documents,args)
           }
       }
    }

    override fun getLayout()= R.layout.list_item_assets
}