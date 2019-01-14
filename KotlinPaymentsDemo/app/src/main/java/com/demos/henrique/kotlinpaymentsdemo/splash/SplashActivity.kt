package com.demos.henrique.kotlinpaymentsdemo.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demos.henrique.kotlinpaymentsdemo.R
import com.demos.henrique.kotlinpaymentsdemo.aisles.AislesActivity
import com.demos.henrique.kotlinpaymentsdemo.splash.SplashContract.SplashPresenter
import com.demos.henrique.kotlinpaymentsdemo.splash.SplashContract.SplashView
import kotlinx.android.synthetic.main.section_gallery.*

class SplashActivity : AppCompatActivity(), SplashView {

    lateinit var mPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.section_gallery)

        mPresenter = StartPresenter(this)
        setupViews()
    }

    override fun setupViews() = start_button.setOnClickListener { _ -> this.goToAisles() }
    override fun goToAisles() = startActivity(Intent(this, AislesActivity::class.java))
}
