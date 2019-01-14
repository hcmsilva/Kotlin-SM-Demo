package com.demos.henrique.mypaymentslibrary.dto


import com.demos.henrique.mypaymentslibrary.model.SelfValidator
import com.google.gson.annotations.SerializedName


data class Instruction(

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("paymentInstrument")
    val paymentInstrument: PaymentInstrument? = null,

    @field:SerializedName("value")
    val value: Value? = null
) : SelfValidator {
    override fun isValid(): Boolean {
        return if(value == null)
                    false
        else
            !description.isNullOrEmpty() && value.isValid()
    }
}