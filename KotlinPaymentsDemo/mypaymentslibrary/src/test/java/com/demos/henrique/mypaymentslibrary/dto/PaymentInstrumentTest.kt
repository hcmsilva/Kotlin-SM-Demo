package com.demos.henrique.mypaymentslibrary.dto

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class PaymentInstrumentTest {


    var cvc: String? = null
    var cardHolderName: String? = null
    val billingAddress= mock(BillingAddress::class.java)
    var type: String? = null
    var cardNumber: String? = null
    val cardExpiryDate: CardExpiryDate? = mock(CardExpiryDate::class.java)


    @Test
    fun whenDtoHasInvalidProperties_ThenIsValidReturnsFalse() {
        `when`(billingAddress.isValid()).thenReturn(false)
        `when`(cardExpiryDate?.isValid()).thenReturn(false)
        //other props default to null

        val payInstrument = PaymentInstrument(cvc, cardHolderName, billingAddress, type, cardNumber, cardExpiryDate)

        assert(!payInstrument.isValid())
    }

    @Test
    fun whenDtoHasValidProperties_ThenIsValidReturnsTrue() {
        `when`(billingAddress.isValid()).thenReturn(true)
        `when`(cardExpiryDate?.isValid()).thenReturn(true)
        cardNumber = "1111"
        cardHolderName = "Henrique"


        val payInstrument = PaymentInstrument(cvc, cardHolderName, billingAddress, type, cardNumber, cardExpiryDate)

        assert(payInstrument.isValid())
    }
}