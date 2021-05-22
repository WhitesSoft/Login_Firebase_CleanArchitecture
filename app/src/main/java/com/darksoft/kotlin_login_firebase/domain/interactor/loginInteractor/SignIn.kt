package com.darksoft.kotlin_login_firebase.domain.interactor.loginInteractor

interface SignIn {

    interface SignInCallBack{
        fun onSignInSucces()
        fun onSignInFailure(mensajeError: String)
    }

    fun SignInCorreo(email: String, password: String, listener:SignInCallBack)
}