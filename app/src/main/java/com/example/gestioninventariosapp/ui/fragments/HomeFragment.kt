package com.example.gestioninventariosapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.ui.prefs.MyPreference
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
        val myPreference=MyPreference(requireContext())
        val userid= myPreference.getUserId()
        val args = Bundle().apply {
             putString("userId", userid)
            }

        assetsButton.setOnClickListener {

            findNavController().navigate(R.id.action_home_to_assets, args)
        }
        documentsButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_documents)
        }
        input_assetButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_addItem, args)
        }
        group_peopleButton.setOnClickListener{
            Toast.makeText(getContext(),"This function is temporarily unavailable",Toast.LENGTH_LONG).show()
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val myPreference=MyPreference(requireContext())
        myPreference.setUserId(myPreference.getUserId())
        val realname= arguments?.getString("name")
        if(realname!=null){Toast.makeText(getContext(),"Welcome "+ realname,Toast.LENGTH_LONG).show()}
    }

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }




}