package com.demos.henrique.kotlinpaymentsdemo.aisles

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.demos.henrique.kotlinpaymentsdemo.R
import com.demos.henrique.kotlinpaymentsdemo.aisles.AislesContract.AislesViewContract
import com.demos.henrique.kotlinpaymentsdemo.aisles.ui.AisleAdapter
import com.demos.henrique.kotlinpaymentsdemo.model.AisleItem
import com.demos.henrique.mypaymentslibrary.utils.PaymentUtilities
import kotlinx.android.synthetic.main.activity_aisles.*

class AislesActivity : AppCompatActivity(), AislesViewContract {

    lateinit var mPresenter: AislesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aisles)

        mPresenter = AislesPresenter(this)
        recycler_view.adapter = AisleAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mPresenter.updateDataList()
    }

    override fun displayDataList(list: MutableList<AisleItem>) =
        (recycler_view.adapter as AisleAdapter).setData(mPresenter.getDataList())//make Async

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //for fragments
        //super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PaymentUtilities.PAYMENT_OPCODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, R.string.purchase_successful, Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, R.string.purchase_failed, Toast.LENGTH_SHORT).show()
        }
    }
}
