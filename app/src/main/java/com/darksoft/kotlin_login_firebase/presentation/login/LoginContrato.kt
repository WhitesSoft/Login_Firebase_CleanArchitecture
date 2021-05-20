package com.darksoft.kotlin_login_firebase.presentation.login

interface LoginContrato {

    //Interface para la vista
    interface LoginView{
        fun showError(mensajeError: String)
        fun showProgressBar()
        fun showHideProgressBar()
        fun signInCorreo()
        fun signInFacebook()
        fun signInGoogle()

        fun navigateToMain() //Este metodo navegara a la pantalla principal
        fun navigateToRegister() //Este metodo navegara a la pantalla de registro
    }

    //Interface para el presenter
    interface LoginPresenter{
        fun attachView(view: LoginView) //Adjunta la vista
        fun dettachView() //Desacopla la vista
        fun isViewAttached(): Boolean //Verifica si tiene una vista
        fun signInUserCorreo(email: String, password: String) //Iniciar Sesion
        fun checkEmptyFields(email: String, password: String): Boolean //Verificamos si los campos de texto estan vacios
    }
}