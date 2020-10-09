package com.example.homecenterapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.homecenterapp.R

import com.example.homecenterapp.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val loginBtn : Button =findViewById(R.id.login_button)
        loginBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.i("APP","el usuario a entrado al login")
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }


}


