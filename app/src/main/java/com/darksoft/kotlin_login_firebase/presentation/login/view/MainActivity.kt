package com.darksoft.kotlin_login_firebase.presentation.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.darksoft.kotlin_login_firebase.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciarSesion()
    }

    private fun btnIniciarSesion() {
        val nameUser = findViewById<EditText>(R.id.edtxNameUser)
        val password = findViewById<EditText>(R.id.edtxPasswordUser)
        val btnIniciar = findViewById<Button>(R.id.btn_iniciarSesion)
        val btnGoogle = findViewById<Button>(R.id.btn_google)
        val btnFacebook = findViewById<Button>(R.id.btn_facebook)

        btnIniciar.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        })

        btnGoogle.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        })

        btnFacebook.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        })

    }
}