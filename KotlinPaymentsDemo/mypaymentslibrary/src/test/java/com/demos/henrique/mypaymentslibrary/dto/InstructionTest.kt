package com.demos.henrique.mypaymentslibrary.dto

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class InstructionTest {

    private var mockDescription: String? = null
    private var mockPaymentInstrument: PaymentInstrument? = mock(PaymentInstrument::class.java)
    private var mockValue: Value? = mock(Value::class.java)
    private lateinit var instruction: Instruction

    @Test
    fun whenDtoHasInvalidProperties_ThenIsValidReturnsFalse() {

        `when`(mockPaymentInstrument?.isValid()).thenReturn(false)
        `when`(mockValue?.isValid()).thenReturn(false)
        mockDescription = ""

        val instruction = Instruction(mockDescription, mockPaymentInstrument, mockValue)

        assert(!instruction.isValid())
    }

    @Test
    fun whenDtoHasValidProperties_ThenIsValidReturnsTrue() {

        `when`(mockPaymentInstrument?.isValid()).thenReturn(true)
        `when`(mockValue?.isValid()).thenReturn(true)
        mockDescription = "mock desc"

        val instruction = Instruction(mockDescription, mockPaymentInstrument, mockValue)

        assert(instruction.isValid())
    }

    @Test
    fun whenDtoHasSomeInvalidProperties_ThenIsValidReturnsFalse() {

        `when`(mockPaymentInstrument?.isValid()).thenReturn(false)
        `when`(mockValue?.isValid()).thenReturn(true)
        mockDescription = "mock desc"

        val instruction = Instruction(mockDescription, mockPaymentInstrument, mockValue)

        assert(!instruction.isValid())
    }
    //todo add different tests for combos of invalid mandatory properties
}