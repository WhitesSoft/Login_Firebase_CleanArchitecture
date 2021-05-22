package com.darksoft.kotlin_login_firebase.domain.interactor.loginInteractor

import com.google.firebase.auth.FirebaseAuth

class SignInInteractor: SignIn {

    private lateinit var auth: FirebaseAuth

    override fun SignInCorreo(email: String, password: String, listener: SignIn.SignInCallBack) {

        auth = FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful){
                listener.onSignInSucces()
            }else {
                listener.onSignInFailure(it.exception?.message!!)
            }
        }
    }
}