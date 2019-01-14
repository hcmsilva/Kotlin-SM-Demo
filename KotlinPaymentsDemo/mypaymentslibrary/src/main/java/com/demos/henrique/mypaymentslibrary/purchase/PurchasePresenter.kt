package com.demos.henrique.mypaymentslibrary.purchase

import com.demos.henrique.mypaymentslibrary.api.ApiClient
import com.demos.henrique.mypaymentslibrary.model.PurchaseInfo
import com.demos.henrique.mypaymentslibrary.purchase.PurchaseContract.PurchasePresenterContract
import com.demos.henrique.mypaymentslibrary.utils.DummyGenerator

class PurchasePresenter(
    private val view: PurchaseContract.PurchaseViewContract,
    private val purchaseInfo: PurchaseInfo,
    private val apiClient: ApiClient
) : PurchasePresenterContract {


    init {
        view.displayPurchaseInfo(purchaseInfo)
    }

    override fun authorizePaymentStart() {

        if (!apiClient.initPaymentOperations(DummyGenerator.generateDummyAuthHeader()))
            return

        val pInfo = DummyGenerator.generateDummyPaymentDetails(purchaseInfo)
        val authHead = DummyGenerator.generateDummyAuthHeader()
        if (apiClient.authorizePayment(pInfo, authHead))
            settlePayment()
        else
            view.displayFailedPayment()
    }

    override fun settlePayment() {
        if (apiClient.settlePayment())
            view.displayPaymentCompleted()
        else {
            view.displayFailedPayment()
        }
    }

    override fun getPurchase() = purchaseInfo
}