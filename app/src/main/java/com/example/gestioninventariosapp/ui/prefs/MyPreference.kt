package com.example.gestioninventariosapp.ui.prefs

import android.content.Context

class MyPreference(context:Context){
    val IDTOKEN="IDTOKEN"
    val USER_ID="userid"
    val preference=context.getSharedPreferences(IDTOKEN,Context.MODE_PRIVATE)

    fun getUserId(): String?{
        return preference.getString(USER_ID,"")
    }
    fun setUserId(string:String?){
        val editor=preference.edit()
        editor.putString(USER_ID,string)
        editor.apply()
    }

}