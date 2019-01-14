package com.demos.henrique.mypaymentslibrary.purchase

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.demos.henrique.mypaymentslibrary.R
import com.demos.henrique.mypaymentslibrary.api.ApiClient
import com.demos.henrique.mypaymentslibrary.api.PaymentsStateMachine
import com.demos.henrique.mypaymentslibrary.model.PurchaseInfo
import com.demos.henrique.mypaymentslibrary.purchase.PurchaseContract.PurchasePresenterContract
import com.demos.henrique.mypaymentslibrary.purchase.PurchaseContract.PurchaseViewContract
import com.demos.henrique.mypaymentslibrary.utils.PaymentUtilities
import kotlinx.android.synthetic.main.activity_purchase.*

open class PurchaseActivity : AppCompatActivity(), PurchaseViewContract {

    private lateinit var mPresenter: PurchasePresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)
        initPresenter()
        setupViews()
    }

    private fun initPresenter() {
        mPresenter = PurchasePresenter(
            this,
            PurchaseInfo(
                intent.getStringExtra(PaymentUtilities.DESCRIPTION_KEY),
                intent.getIntExtra(PaymentUtilities.PRICE_KEY, -1)
            ),
            ApiClient(PaymentsStateMachine())
        )
    }

    private fun setupViews() = confirm_purchase_button.setOnClickListener {
        displayAlertDialog(mPresenter.getPurchase())
    }

    override fun displayPurchaseInfo(purchase: PurchaseInfo) {
        content_description_tv.text = purchase.itemName
        price_value_tv.text = "GBP ${purchase.price}"
    }

    private fun displayAlertDialog(purchaseInfo: PurchaseInfo) {
        val alertDialogBuilder: AlertDialog.Builder? = this@PurchaseActivity.let {
            AlertDialog.Builder(it)
        }
        setupAlertDialog(alertDialogBuilder, purchaseInfo)
        alertDialogBuilder?.create()
        alertDialogBuilder?.show()
    }

    private fun setupAlertDialog(
        alertDialogBuilder: AlertDialog.Builder?,
        purchaseInfo: PurchaseInfo
    ) {
        alertDialogBuilder?.setCancelable(false)
        alertDialogBuilder?.setIcon(android.R.drawable.ic_dialog_alert)
        alertDialogBuilder?.setTitle(R.string.authorize_payment_confirmation)
        alertDialogBuilder?.setMessage("${purchaseInfo.itemName}  -  ${purchaseInfo.price}")

        alertDialogBuilder?.setPositiveButton(
            R.string.authorize_ok
        ) { _, _ -> mPresenter.authorizePaymentStart() }

        alertDialogBuilder?.setNegativeButton(
            R.string.deny
        ) { dialog, _ -> dialog.cancel() }
    }

    override fun displayPaymentCompleted() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun displayFailedPayment() {
        Toast.makeText(this, R.string.payment_unauthorized, Toast.LENGTH_LONG).show()
    }
}
