package com.demos.henrique.mypaymentslibrary.dto

import com.google.gson.annotations.SerializedName

data class PaymentsPartialRefund(

    @field:SerializedName("href")
    val href: String? = null
)