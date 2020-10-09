package com.example.homecenterapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.homecenterapp.R
import com.example.homecenterapp.R.layout.activity_registro
class RegistroActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_registro)
        val registerBtn : Button =findViewById(R.id.reg_button)
        registerBtn.setOnClickListener(this)
        val tvAlreadyCount : TextView =findViewById(R.id.already_count)
        tvAlreadyCount.setOnClickListener(this)
        val backButton : ImageButton =findViewById(R.id.back_button_reg)
        backButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.reg_button->print("asd")
                R.id.already_count->{
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.back_button_reg->{
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}