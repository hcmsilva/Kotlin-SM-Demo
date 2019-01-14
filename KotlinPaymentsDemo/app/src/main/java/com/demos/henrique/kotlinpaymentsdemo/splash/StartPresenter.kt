package com.demos.henrique.kotlinpaymentsdemo.splash

import com.demos.henrique.kotlinpaymentsdemo.splash.SplashContract.SplashPresenter
import com.demos.henrique.kotlinpaymentsdemo.splash.SplashContract.SplashView

class StartPresenter(val view: SplashView) : SplashPresenter {

    override fun goShopping() = view.goToAisles()
}