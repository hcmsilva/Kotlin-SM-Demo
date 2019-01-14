package com.demos.henrique.mypaymentslibrary.utils

import com.demos.henrique.mypaymentslibrary.dto.*
import com.demos.henrique.mypaymentslibrary.model.PurchaseInfo

class DummyGenerator {
    companion object {

        @JvmStatic
        fun getRootActions() = ActionLink(PaymentsAuthorize(),null, null, PaymentsEvents(), null, listOf(), null, ResourceTree(), null, null)

        @JvmStatic
        fun getAuthorizedActions() = ActionLink(null, PaymentsSettle(), PaymentsCancel(), PaymentsEvents(), PaymentsPartialSettle(), listOf(), null, null, null, null)

        @JvmStatic
        fun getSettledActions() = ActionLink(null, null, null, PaymentsEvents(), null, listOf(), null, null, PaymentsRefund(), PaymentsPartialRefund())

        @JvmStatic
        fun getCanceledActions() = ActionLink(null, null, null, PaymentsEvents(), null, listOf())

        @JvmStatic
        fun generateDummyPaymentDetails(purchaseInfo: PurchaseInfo): PaymentDetails {
            return PaymentDetails(
                (Math.random() * 100000).toString(),
                Instruction(
                    purchaseInfo.itemName,
                    PaymentInstrument("111", "Henrique", null, "visa", "4444333322221111", CardExpiryDate(12, 2034)),
                    Value(purchaseInfo.price, "GBP")
                )
            )
        }

        @JvmStatic
        fun generateDummyAuthHeader() = "ssiKWDNpasasc"
    }
}