package com.example.homecenterapp.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homecenterapp.R

class ItemDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_detail, container, false)
    }
}