package com.darksoft.kotlin_login_firebase.presentation.login.view


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.darksoft.kotlin_login_firebase.R
import com.darksoft.kotlin_login_firebase.base.BaseActivity
import com.darksoft.kotlin_login_firebase.presentation.login.LoginContrato
import com.darksoft.kotlin_login_firebase.presentation.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity(), LoginContrato.LoginView {

    //Instanciamos a LoginPresenter
    lateinit var presenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = LoginPresenter()
        presenter.attachView(this) //Le mandamos la vista al LoginPresenter

        btn_google.setOnClickListener {
            signInGoogle()
        }
        btn_facebook.setOnClickListener {
            signInFacebook()
        }
        btn_Correo.setOnClickListener {
            signInCorreo()
        }

    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun showError(mensajeError: String) {
        toast(this, mensajeError)
    }

    override fun showProgressBar() {
        progressBarLogin.visibility = View.VISIBLE
    }

    override fun showHideProgressBar() {
        progressBarLogin.visibility = View.GONE
    }

    override fun signInCorreo() {

        var email = edtxNameUser.text.toString().trim()
        var password = edtxPasswordUser.text.toString().trim()

        //Verificamos si los campos estan vacios
        if (presenter.checkEmptyFields(email, password)){
            toast(this, "Algunos campos estan vacios")
        } else{
            presenter.signInUserCorreo(email, password) //Enviamos los datos
        }


        /*toast(this, "Iniciaste sesión con correo")
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)*/
    }

    override fun signInFacebook() {
        toast(this, "Iniciaste sesion con Facebook")
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

    override fun signInGoogle() {
        toast(this, "Iniciaste sesion con Google")
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

    override fun navigateToMain() {
        TODO("Not yet implemented")
    }

    override fun navigateToRegister() {
        TODO("Not yet implemented")
    }
}