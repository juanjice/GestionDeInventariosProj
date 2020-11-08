package com.example.gestioninvetariosapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homecenterapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assetsButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_assets)
        }
        documentsButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_documents)
        }
        input_assetButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_addItem)
        }
        output_assetButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_RemoveItem)
        }

    }



}