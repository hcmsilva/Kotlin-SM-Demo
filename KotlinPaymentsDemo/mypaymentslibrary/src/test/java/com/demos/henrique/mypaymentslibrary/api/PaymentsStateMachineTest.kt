package com.demos.henrique.mypaymentslibrary.api

import com.demos.henrique.mypaymentslibrary.api.PaymentsStateMachine.State
import org.junit.Test

import org.junit.Assert.*

class PaymentsStateMachineTest {

    @Test
    fun testStartingState(){
        val stateMachine = PaymentsStateMachine()
        val expectedResult = State.ROOT
        assertEquals(expectedResult, stateMachine.currState)
    }
}