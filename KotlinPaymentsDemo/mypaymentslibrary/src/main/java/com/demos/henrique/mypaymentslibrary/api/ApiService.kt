package com.demos.henrique.mypaymentslibrary.api

import com.demos.henrique.mypaymentslibrary.dto.PaymentDetails

interface ApiService {

    fun initPaymentOperations(authHeader: String): Boolean
    fun authorizePayment(paymentDetails: PaymentDetails, authHeader: String): Boolean
    fun settlePayment(): Boolean
}