package com.demos.henrique.mypaymentslibrary.utils

import android.app.Activity
import android.content.Intent
import com.demos.henrique.mypaymentslibrary.purchase.PurchaseActivity

class PaymentUtilities {
    companion object {

        @JvmStatic
        val PAYMENT_OPCODE = 7365
        @JvmStatic
        val DESCRIPTION_KEY = "description"
        @JvmStatic
        val PRICE_KEY = "price"

        @JvmStatic
        fun pay(description: String, price: Int, parentActivity: Activity) =
            parentActivity.startActivityForResult(
                getStarterIntent(description, price, parentActivity), PAYMENT_OPCODE
            )


        private fun getStarterIntent(description: String, price: Int, context: Activity) =
            Intent(context, PurchaseActivity::class.java).apply {
                putExtra(DESCRIPTION_KEY, description)
                putExtra(PRICE_KEY, price)
            }
    }
}