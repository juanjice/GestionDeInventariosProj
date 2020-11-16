package com.example.gestioninventariosapp.documents.items


import android.util.Log
import android.widget.Toast
import com.example.domain.documents.model.Document
import com.example.gestioninventariosapp.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_document.view.*


class DocumentsItem(val document: Document): Item() {
        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            Log.i("asdasddsa",document.toString())
            viewHolder.itemView.apply{
                textViewTittleDocument.text=document.name
                textViewFechaDocument.text=document.fecha
                textViewTotalDocument.text=document.cantidad.toString()
                textViewPersonaDocument.text=document.persona_asociada
                output_asset_button.setOnClickListener{
                    Toast.makeText(getContext(),"This function is temporarily unavailable",
                        Toast.LENGTH_LONG).show()
                }
            }
        }

        override fun getLayout()= R.layout.list_item_document
}
