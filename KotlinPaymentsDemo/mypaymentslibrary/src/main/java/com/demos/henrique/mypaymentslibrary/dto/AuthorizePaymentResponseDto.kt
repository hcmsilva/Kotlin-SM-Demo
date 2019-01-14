package com.demos.henrique.mypaymentslibrary.dto

import com.google.gson.annotations.SerializedName

data class AuthorizePaymentResponseDto(

    @field:SerializedName("_links")
    val actionLink: ActionLink? = null,

    @field:SerializedName("outcome")
    val outcome: String? = null
)