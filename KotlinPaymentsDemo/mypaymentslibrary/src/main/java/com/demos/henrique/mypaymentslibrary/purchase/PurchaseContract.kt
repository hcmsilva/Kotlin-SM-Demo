package com.demos.henrique.mypaymentslibrary.purchase

import com.demos.henrique.mylibrary.model.PurchaseInfo


interface PurchaseContract {

    interface PurchaseViewContract {
        fun displayPurchaseInfo(purchase: PurchaseInfo)
        fun displayPaymentCompleted()
        fun displayFailedPayment()
    }

    interface PurchasePresenterContract {
        fun authorizePaymentStart(): Unit
        fun settlePayment()
        fun getPurchase(): PurchaseInfo
    }
}