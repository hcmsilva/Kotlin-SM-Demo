package com.demos.henrique.mypaymentslibrary.dto


import com.demos.henrique.mypaymentslibrary.model.SelfValidator
import com.google.gson.annotations.SerializedName


open class PaymentInstrument(

    @field:SerializedName("cvc")
    val cvc: String? = null,

    @field:SerializedName("cardHolderName")
    val cardHolderName: String? = null,

    @field:SerializedName("billingAddress")
    val billingAddress: BillingAddress? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("cardNumber")
    val cardNumber: String? = null,

    @field:SerializedName("cardExpiryDate")
    val cardExpiryDate: CardExpiryDate? = null
) : SelfValidator {
    override fun isValid(): Boolean {
        return !cardNumber.isNullOrEmpty() &&
                !cardHolderName.isNullOrEmpty() &&
                (cardExpiryDate?.isValid() ?: false) && //mandatory so defaults to false
                (billingAddress?.isValid() ?: true)     //optional so defaults to true
    }
}