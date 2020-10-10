package com.example.homecenterapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.homecenterapp.R
import com.example.homecenterapp.R.layout.activity_login
import com.example.homecenterapp.model.retrofit.MiniTwitterAuthService

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(activity_login)
        //Declaramos valores para las cajas de texto y declaramos las funciones para cada action
        declareViewsandEvents()
        retrofitInit()
    }



    override fun onClick(v: View?) {

        if (v != null) {
            when(v.id){
                R.id.login_button->print("asd")
                R.id.not_already_count->{
                    val intent = Intent(this,RegistroActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.back_button->{
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
    fun declareViewsandEvents(){
        var email:EditText =findViewById(R.id.email_login)
        var pass:EditText =findViewById(R.id.password_login)
        var loginBtn : Button =findViewById(R.id.login_button)
        var tvNotAlreadyCount : TextView =findViewById(R.id.not_already_count)
        var backButton : ImageButton =findViewById(R.id.back_button)
        loginBtn.setOnClickListener(this)
        tvNotAlreadyCount.setOnClickListener(this)
        backButton.setOnClickListener(this)
    }
    fun retrofitInit(){

        var miniTwitterService:MiniTwitterAuthService

    }
}