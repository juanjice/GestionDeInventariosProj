package com.example.homecenterapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.homecenterapp.R
import com.example.homecenterapp.R.layout.activity_login
class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_login)
        val loginBtn : Button =findViewById(R.id.login_button)
        loginBtn.setOnClickListener(this)
        val tvNotAlreadyCount : TextView =findViewById(R.id.not_already_count)
        tvNotAlreadyCount.setOnClickListener(this)
        val backButton : ImageButton =findViewById(R.id.back_button)
        backButton.setOnClickListener(this)
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
}