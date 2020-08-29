package com.example.gestioninvproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1:Button =findViewById(R.id.button3)
        btn1.setOnClickListener { view ->
            Toast.makeText(this,"Click en el boton 1",Toast.LENGTH_SHORT).show()
        }
        val tv2:TextView=findViewById(R.id.textview1)
        tv2.setOnClickListener(this)
        }

    override fun onClick(p0: View?) {
        Toast.makeText(this,"Click en el boton 1",Toast.LENGTH_SHORT).show()
    }
}
