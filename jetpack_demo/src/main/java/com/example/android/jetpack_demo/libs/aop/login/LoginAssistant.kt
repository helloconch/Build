package com.example.android.jetpack_demo.libs.aop.login

class LoginAssistant {
    companion object {
        private var loginAssistant: LoginAssistant? = null
        fun getInstance(): LoginAssistant {
            if (loginAssistant == null) {
                synchronized(LoginAssistant::class) {
                    if (loginAssistant == null) {
                        loginAssistant = LoginAssistant()
                    }
                }
            }
            return loginAssistant!!
        }

    }

    var login: ILogin? = null

}

