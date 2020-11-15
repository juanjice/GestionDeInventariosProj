package com.example.gestioninventariosapp.users.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.ui.prefs.MyPreference
import com.example.gestioninventariosapp.users.viewmodel.UserViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_sing_up.*
import javax.inject.Inject


class SingUpFragment : DaggerFragment() {
    @Inject
    lateinit var viewmodel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sing_up, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        singup_button.setOnClickListener {
            if(entry_register_email.text.toString()=="" ||
                entry_register_name.text.toString()=="" ||
                entry_register_password.text.toString()==""
            ){
                Toast.makeText(getActivity(),"Fill all the fields !", Toast.LENGTH_LONG).show()
            }else{
                viewmodel.createUserIfNoExist(
                    entry_register_name.text.toString(),
                    entry_register_email.text.toString(),
                    entry_register_password.text.toString()
                )

            }
        }
        i_have_account_button.setOnClickListener {
            findNavController().navigate(R.id.action_createAccount_to_login)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel.onVeryfiedCreateAccount().observe(viewLifecycleOwner, Observer { user_ret->
            if (user_ret.id=="invalid"){
                Toast.makeText(getActivity()," You already have an account!",Toast.LENGTH_LONG).show()
            }else{
                val myPreference= MyPreference(requireContext())
                myPreference.setUserId(user_ret.id)
                findNavController().navigate(R.id.action_createAccount_to_home)

            }
        })
    }

}