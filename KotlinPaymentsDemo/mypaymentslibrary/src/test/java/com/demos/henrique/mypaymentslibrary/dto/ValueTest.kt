package com.demos.henrique.mypaymentslibrary.dto

import org.junit.Test

import org.junit.Assert.*

class ValueTest {

    var amount: Int? = null
    var currency: String? = null

    @Test
    fun whenDtoHasInvalidProperties_ThenIsValidReturnsFalse() {
        //props default to null

        val myValue = Value(amount, currency)
        assert(!myValue.isValid())
    }

    @Test
    fun whenDtoHasValidProperties_ThenIsValidReturnsTrue() {

        amount = 12
        currency = "GBP"

        val myValue = Value(amount, currency)
        assert(myValue.isValid())
    }
}