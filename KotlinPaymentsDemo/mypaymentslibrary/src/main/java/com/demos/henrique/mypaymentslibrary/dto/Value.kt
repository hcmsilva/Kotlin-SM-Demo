package com.demos.henrique.mypaymentslibrary.dto


import com.demos.henrique.mypaymentslibrary.model.SelfValidator
import com.google.gson.annotations.SerializedName

open class Value(

    @field:SerializedName("amount")
    val amount: Int? = null,

    @field:SerializedName("currency")
    val currency: String? = null
) : SelfValidator {
    override fun isValid(): Boolean =
        amount != null && !currency.isNullOrEmpty()
}