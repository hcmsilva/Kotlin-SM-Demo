package com.demos.henrique.mypaymentslibrary.dto


import com.demos.henrique.mypaymentslibrary.model.SelfValidator
import com.google.gson.annotations.SerializedName


open class CardExpiryDate(

    @field:SerializedName("month")
    val month: Int? = null,

    @field:SerializedName("year")
    val year: Int? = null
) : SelfValidator {
    override fun isValid(): Boolean = month != null && year != null
}