package com.demos.henrique.mypaymentslibrary.dto

import com.demos.henrique.mypaymentslibrary.model.SelfValidator
import com.google.gson.annotations.SerializedName

open class BillingAddress(

    @field:SerializedName("address2")
    val address2: String? = null,

    @field:SerializedName("address1")
    val address1: String? = null,

    @field:SerializedName("countryCode")
    val countryCode: String? = null,

    @field:SerializedName("postalCode")
    val postalCode: String? = null,

    @field:SerializedName("state")
    val state: String? = null
) : SelfValidator {
    override fun isValid(): Boolean =
        !address1.isNullOrEmpty() &&
                !address2.isNullOrEmpty() &&
                !countryCode.isNullOrEmpty() &&
                !postalCode.isNullOrEmpty()
}