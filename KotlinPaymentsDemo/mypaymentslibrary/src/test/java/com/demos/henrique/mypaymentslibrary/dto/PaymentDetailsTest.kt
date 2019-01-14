package com.demos.henrique.mypaymentslibrary.dto

import org.junit.Test

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class PaymentDetailsTest {

    private var mockTransactionRef: String? = null
    private var mockInstruction = mock(Instruction::class.java)


    @Test
    fun whenDtoHasInvalidProperties_ThenIsValidReturnsFalse() {

        `when`(mockInstruction?.isValid()).thenReturn(false)
        mockTransactionRef = null

        val pDetails = PaymentDetails(mockTransactionRef, mockInstruction)

        assert(!pDetails.isValid())
    }

    @Test
    fun whenDtoHasValidProperties_ThenIsValidReturnsTrue() {

        `when`(mockInstruction?.isValid()).thenReturn(true)
        mockTransactionRef = "ref029"

        val pDetails = PaymentDetails(mockTransactionRef, mockInstruction)

        assert(pDetails.isValid())
    }

    @Test
    fun whenDtoHasInvalidInstruction_ThenIsValidReturnsFalse() {
        `when`(mockInstruction?.isValid()).thenReturn(false)
        mockTransactionRef = "ref029"

        val pDetails = PaymentDetails(mockTransactionRef, mockInstruction)

        assert(!pDetails.isValid())
    }

    @Test
    fun whenDtoHasInvalidReference_ThenIsValidReturnsFalse() {
        `when`(mockInstruction?.isValid()).thenReturn(true)
        mockTransactionRef = null

        val pDetails = PaymentDetails(mockTransactionRef, mockInstruction)

        assert(!pDetails.isValid())
    }
}