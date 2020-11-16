package com.example.gestioninventariosapp.ui.activities


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val navController = Navigation.findNavController(this, R.id.homeNavHostFragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

                R.id.assets, R.id.documents,R.id.addItem ->{
                    Log.i("Homemsg","Pinchaste sobre algo")
                    bottomMenu.visibility=View.VISIBLE
                }
                else -> bottomMenu.visibility=View.GONE
            }
        }
        bottomMenu.setupWithNavController(navController)



    }



}


