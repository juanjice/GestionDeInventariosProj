package com.example.gestioninvetariosapp.ui.activities


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.homecenterapp.R
import com.example.homecenterapp.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val navController = Navigation.findNavController(this, R.id.homeNavHostFragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

                R.id.assets, R.id.documents,R.id.RemoveItem,R.id.addItem ->{
                    Log.i("Homemsg","Pinchaste sobre algo")
                    Log.i("typebot", destination.toString())
                    bottomMenu.visibility=View.VISIBLE
                }
                else -> bottomMenu.visibility=View.GONE
            }
        }
        bottomMenu.setupWithNavController(navController)



    }



}


