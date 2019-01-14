package com.demos.henrique.kotlinpaymentsdemo.splash

interface SplashContract {
    interface SplashView {
        fun setupViews()
        fun goToAisles()
    }

    interface SplashPresenter {
        fun goShopping()
    }
}