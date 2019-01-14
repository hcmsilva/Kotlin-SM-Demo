package com.demos.henrique.mypaymentslibrary.api

import com.demos.henrique.mypaymentslibrary.api.PaymentsStateMachine.State
import com.demos.henrique.mypaymentslibrary.dto.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class PaymentsStateMachineTest {

    lateinit var mockRootActions: ActionLink
    lateinit var mockAuthorizedActions: ActionLink
    lateinit var mockSettledActions: ActionLink
    lateinit var mockCanceledActions: ActionLink

    @Before
    fun setupActions() {
        mockRootActions = ActionLink(
            PaymentsAuthorize(),
            null,
            null,
            PaymentsEvents(),
            null,
            listOf(),
            null,
            ResourceTree(),
            null,
            null
        )
        mockAuthorizedActions = ActionLink(
            null,
            PaymentsSettle(),
            PaymentsCancel(),
            PaymentsEvents(),
            PaymentsPartialSettle(),
            listOf(),
            null,
            null,
            null,
            null
        )
        mockSettledActions = ActionLink(
            null,
            null,
            null,
            PaymentsEvents(),
            null,
            listOf(),
            null,
            null,
            PaymentsRefund(),
            PaymentsPartialRefund()
        )
        mockCanceledActions = ActionLink(null, null, null, PaymentsEvents(), null, listOf())
    }

    @Test
    fun testStartingState(){
        val stateMachine = PaymentsStateMachine()
        val expectedResult = State.ROOT
        assertEquals(expectedResult, stateMachine.currState)
    }

    @Test
    fun testAvailableActionsRootState() {
        val stateMachine = PaymentsStateMachine()

        val availableActions = stateMachine.getAvailableActions()

        assertEquals(mockRootActions, availableActions)
    }

    @Test
    fun testAvailableActionsAuthorizedState() {
        val stateMachine = PaymentsStateMachine()
        stateMachine.currState = State.AUTHORIZED

        val availableActions = stateMachine.getAvailableActions()

        assertEquals(mockAuthorizedActions, availableActions)
    }

    @Test
    fun testAvailableActionsSettledState() {
        val stateMachine = PaymentsStateMachine()
        stateMachine.currState = State.SETTLED

        val availableActions = stateMachine.getAvailableActions()

        assertEquals(mockSettledActions, availableActions)
    }

    @Test
    fun testAvailableActionsCanceledState() {
        val stateMachine = PaymentsStateMachine()
        stateMachine.currState = State.CANCELED

        val availableActions = stateMachine.getAvailableActions()

        assertEquals(mockCanceledActions, availableActions)
    }
}