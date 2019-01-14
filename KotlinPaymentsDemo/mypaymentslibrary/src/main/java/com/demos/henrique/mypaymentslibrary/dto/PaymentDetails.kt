package com.demos.henrique.mypaymentslibrary.dto

import com.demos.henrique.mypaymentslibrary.model.SelfValidator
import com.google.gson.annotations.SerializedName

open class PaymentDetails(

	@field:SerializedName("transactionReference")
	val transactionReference: String? = null,

	@field:SerializedName("instruction")
	val instruction: Instruction? = null
) : SelfValidator {
    override fun isValid(): Boolean {
        return transactionReference != null && instruction != null && instruction.isValid()
    }
}