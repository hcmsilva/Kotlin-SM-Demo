package com.demos.henrique.mypaymentslibrary.dto

import com.google.gson.annotations.SerializedName

class AuthorizePaymentRequestDto(

    @field:SerializedName("transactionReference")
    val transactionReference: String? = null,

    @field:SerializedName("instruction")
    val instruction: Instruction? = null
)