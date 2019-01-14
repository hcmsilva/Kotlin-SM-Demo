package com.demos.henrique.mypaymentslibrary.dto

import org.junit.Test

class BillingAddressTest {

    @Test
    fun whenDtoHasInvalidProperties_ThenIsValidReturnsFalse() {

        val address2: String? = null
        val address1: String? = null
        val countryCode: String? = null
        val postalCode: String? = null
        val state: String? = null

        val billingAddress = BillingAddress(address2, address1, countryCode, postalCode, state)

        assert(!billingAddress.isValid())
    }

    @Test
    fun whenDtoHasMandatoryProperties_ThenIsValidReturnsTrue() {

        val address2: String? = "aaaa"
        val address1: String? = "bbbb"
        val countryCode: String? = "cc"
        val postalCode: String? = "dddd"
        val state: String? = null

        val billingAddress = BillingAddress(address2, address2, countryCode, postalCode, state)

        assert(billingAddress.isValid())
    }

    //todo: add assertFails test for single mandatory properties missing
}