package com.example.gestioninventariosapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.users.viewmodel.UserViewModel
import dagger.android.support.DaggerFragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewmodel: UserViewModel
    lateinit var args:Bundle
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

        var email = arguments?.getString("userEmail")
        var password = arguments?.getString("userPassword")
        Log.i("user inf",email+"  "+password)

        viewmodel.verifyaccount(
            password?:"",
            email?:""
        )
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
        var email = arguments?.getString("userEmail")
        var password = arguments?.getString("userPassword")
        Log.i("user inf",email+"  "+password)
        viewmodel.onVeryfiedAccount().observe(viewLifecycleOwner, Observer { user_ret->
            text_view_prueba.setText(user_ret.id)
            args = Bundle().apply {
                putString("userId", user_ret.id)
            }
        })

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