package com.demos.henrique.mypaymentslibrary.purchase

import com.demos.henrique.mypaymentslibrary.model.PurchaseInfo


interface PurchaseContract {

    interface PurchaseViewContract {
        fun displayPurchaseInfo(purchase: PurchaseInfo)
        fun displayPaymentCompleted()
        fun displayFailedPayment()
    }

    interface PurchasePresenterContract {
        fun authorizePaymentStart()
        fun settlePayment()
        fun getPurchase(): PurchaseInfo
    }
}