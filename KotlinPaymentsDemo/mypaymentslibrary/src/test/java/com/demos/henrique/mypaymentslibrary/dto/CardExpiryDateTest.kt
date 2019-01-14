package com.demos.henrique.mypaymentslibrary.dto

import org.junit.Test

class CardExpiryDateTest {

    @Test
    fun whenDtoHasInvalidProperties_ThenIsValidReturnsFalse() {
        val month: Int? = null
        val year: Int? = null

        val cardExpDate = CardExpiryDate(month, year)

        assert(!cardExpDate.isValid())
    }

    @Test
    fun whenDtoHasInvalidMonth_ThenIsValidReturnsFalse() {
        val month: Int? = null
        val year: Int? = 2019

        val cardExpDate = CardExpiryDate(month, year)

        assert(!cardExpDate.isValid())
    }

    @Test
    fun whenDtoHasInvalidYear_ThenIsValidReturnsFalse() {
        val month: Int? = 12
        val year: Int? = null

        val cardExpDate = CardExpiryDate(month, year)

        assert(!cardExpDate.isValid())
    }

    @Test
    fun whenDtoHasMandatoryProperties_ThenIsValidReturnsTrue() {
        val month: Int? = 12
        val year: Int? = 2019

        val cardExpDate = CardExpiryDate(month, year)

        assert(cardExpDate.isValid())
    }
}