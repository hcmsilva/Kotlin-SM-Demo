package com.demos.henrique.mypaymentslibrary.dto


import com.demos.henrique.mypaymentslibrary.model.SelfValidator
import com.google.gson.annotations.SerializedName


open class Instruction(

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("paymentInstrument")
    val paymentInstrument: PaymentInstrument? = null,

    @field:SerializedName("value")
    val value: Value? = null
) : SelfValidator {
    override fun isValid(): Boolean {
        return if(value == null || paymentInstrument == null || description == null)
                    false
        else
            !description.isNullOrEmpty() && value.isValid() && paymentInstrument.isValid()
    }
}