package com.example.homecenterapp.ui.adapter.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homecenterapp.R

class ItemHolder(holder: View) : RecyclerView.ViewHolder(holder) {
    val ivMas = itemView.findViewById<ImageView>(R.id.imageViewMas)
    val ivMenos = itemView.findViewById<ImageView>(R.id.imageViewMenos)
    val tvNombreItem = itemView.findViewById<TextView>(R.id.tvNombre)
    val tvCantidad = itemView.findViewById<TextView>(R.id.tvCantidad)
}