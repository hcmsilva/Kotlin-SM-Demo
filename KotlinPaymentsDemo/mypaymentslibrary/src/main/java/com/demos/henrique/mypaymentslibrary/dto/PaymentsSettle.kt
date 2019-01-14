package com.demos.henrique.mypaymentslibrary.dto

import com.google.gson.annotations.SerializedName

data class PaymentsSettle(

    @field:SerializedName("href")
    val href: String? = null
)