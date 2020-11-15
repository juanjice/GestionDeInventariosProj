package com.example.gestioninventariosapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.gestioninventariosapp.R
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

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
        var userId = arguments?.getString("userIdFinal")
        val args = Bundle().apply {
            putString("userId", userId)
        }
        assetsButton.setOnClickListener {

            findNavController().navigate(R.id.action_home_to_assets,args)
        }
        documentsButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_documents)
        }
        input_assetButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_addItem,args)
        }
        output_assetButton.setOnClickListener {

            findNavController().navigate(R.id.action_home_to_RemoveItem)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var userId = arguments?.getString("userIdFinal")
        text_view_prueba.setText(userId)
    }



}