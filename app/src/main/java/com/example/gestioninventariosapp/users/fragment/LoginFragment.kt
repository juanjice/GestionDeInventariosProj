package com.example.gestioninventariosapp.users.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast

import androidx.navigation.fragment.findNavController
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.users.viewmodel.UserViewModel
import dagger.android.support.DaggerFragment

import kotlinx.android.synthetic.main.fragment_login.*
import androidx.lifecycle.Observer
import javax.inject.Inject

class LoginFragment :  DaggerFragment()  {
    @Inject
    lateinit var viewmodel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_button.setOnClickListener {
            if(entry_user_email.text.toString()=="" || entry_user_password.text.toString()=="" ){
                Toast.makeText(getActivity(),"Fill all the fields !",Toast.LENGTH_LONG).show()
            }else{

                Log.e("give pass",entry_user_password.text.toString()+" "+entry_user_email.text.toString())
                viewmodel.verifyaccount(
                    entry_user_email.text.toString(),
                    entry_user_password.text.toString()
                )
            }
            //findNavController().navigate(R.id.action_login_to_home)
        }
        dont_have_account_button.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_createAccount)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel.onVeryfiedAccount().observe(viewLifecycleOwner, Observer { user_ret->
           if (user_ret.id=="invalid"){
               Log.e("user invalido",user_ret.toString())
               Toast.makeText(getActivity(),"Invalid User!",Toast.LENGTH_LONG).show()
           }else{
               Log.i("user valido",user_ret.toString())
               val args = Bundle().apply {
                   putString("userEmail", user_ret.email)
                   putString("userPassword", user_ret.password)
               }
               findNavController().navigate(R.id.action_login_to_home,args)

           }
        })
    }

}