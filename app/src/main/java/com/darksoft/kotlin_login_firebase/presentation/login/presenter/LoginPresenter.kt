package com.darksoft.kotlin_login_firebase.presentation.login.presenter

import com.darksoft.kotlin_login_firebase.presentation.login.LoginContrato

class LoginPresenter(): LoginContrato.LoginPresenter {

    //Inicializamos la vista
    var vista: LoginContrato.LoginView? = null

    override fun attachView(view: LoginContrato.LoginView) {
        this.vista = view
    }

    override fun dettachView() {
        vista = null
    }

    override fun isViewAttached(): Boolean {
        return vista != null
    }

    override fun signInUserCorreo(email:String, password:String) {
        vista?.showProgressBar()
        vista?.showError("Entraste")
    }

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }
}