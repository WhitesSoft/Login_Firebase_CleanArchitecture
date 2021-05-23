package com.darksoft.kotlin_login_firebase.presentation.login.presenter

import com.darksoft.kotlin_login_firebase.domain.interactor.loginInteractor.SignIn
import com.darksoft.kotlin_login_firebase.presentation.login.LoginContrato

class LoginPresenter(signIn: SignIn): LoginContrato.LoginPresenter {

    //Inicializamos la vista
    var vista: LoginContrato.LoginView? = null

    //Llamanos a la interface
    var signIn : SignIn? = null
    init{
        this.signIn = signIn
    }

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
        signIn?.SignInCorreo(email, password, object: SignIn.SignInCallBack{

            //Si logeo correctamente vamos a la nueva activity
            override fun onSignInSucces() {
                if(isViewAttached()){
                    vista?.showHideProgressBar()
                    vista?.navigateToMain()

                }
            }
            //Si no logeo correctamente le mostramos el error
            override fun onSignInFailure(mensajeError: String) {
                if(isViewAttached()){
                    vista?.showHideProgressBar()
                    vista?.showError(mensajeError)
                }
            }
        })
    }

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }
}