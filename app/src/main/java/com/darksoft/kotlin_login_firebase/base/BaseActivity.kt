package com.darksoft.kotlin_login_firebase.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//Esta clase es el padre MainActivity
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayout())
    }

    abstract fun getLayout(): Int

    //Metodo para simplificar el Toast
    fun Context.toast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(context, message, duration).show()
    }
}