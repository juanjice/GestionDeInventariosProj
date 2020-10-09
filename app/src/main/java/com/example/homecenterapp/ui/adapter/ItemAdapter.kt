package com.example.homecenterapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homecenterapp.R
import com.example.homecenterapp.model.Item
import com.example.homecenterapp.ui.adapter.holder.ItemHolder


class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_info, parent, false)
        return ItemHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ItemHolder, position: Int) {
        val item: Item? = items[position]
        viewHolder.tvNombreItem.text = item?.nombre
        viewHolder.tvCantidad.text = item?.cantidad.toString()

        viewHolder.ivMas.setOnClickListener {
            viewHolder.tvCantidad.text = (viewHolder.tvCantidad.text.toString().toInt() + 1).toString()
        }

        viewHolder.ivMenos.setOnClickListener {
            if(viewHolder.tvCantidad.text.toString().toInt() > 0) {
                viewHolder.tvCantidad.text =
                    (viewHolder.tvCantidad.text.toString().toInt() - 1).toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}