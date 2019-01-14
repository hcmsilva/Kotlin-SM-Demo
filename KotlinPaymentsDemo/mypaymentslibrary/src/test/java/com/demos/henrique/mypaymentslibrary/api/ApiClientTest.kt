package com.demos.henrique.mypaymentslibrary.api

import com.demos.henrique.mypaymentslibrary.dto.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ApiClientTest {

    private val mockActionsStMachine = mock(PaymentsStateMachine::class.java)
    private val mockPaymentDetails = mock(PaymentDetails::class.java)
    private lateinit var apiClient: ApiClient

    private val mockRootActions =
        ActionLink(PaymentsAuthorize(), null, null, PaymentsEvents(), null, listOf(), null, ResourceTree(), null, null)
    private val mockAuthorizedActions = ActionLink(
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
    private val mockSettledActions = ActionLink(
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
    private val mockCanceledActions = ActionLink(null, null, null, PaymentsEvents(), null, listOf())

    @Test
    fun initPaymentOperationsWithInvalidAuthHeaderFails() {

        val mockAuthHeaderFail = ""
        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.ROOT)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockRootActions)

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false
        assertEquals(expectedResult, apiClient.initPaymentOperations(mockAuthHeaderFail))
    }

    @Test
    fun initPaymentOperationsWithValidAuthHeaderSuccess() {

        val mockAuthHeaderSuccess = "123"
        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.ROOT)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockRootActions)

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = true
        assertEquals(expectedResult, apiClient.initPaymentOperations(mockAuthHeaderSuccess))
    }

    @Test
    fun authorizePaymentWithInvalidAuthHeaderFails() {

        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.ROOT)
        `when`(mockPaymentDetails.isValid()).thenReturn(true)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockRootActions)
        val mockAuthHeaderFail = ""

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false

        assertEquals(expectedResult, apiClient.authorizePayment(mockPaymentDetails, mockAuthHeaderFail))
    }

    @Test
    fun authorizePaymentWithInvalidPaymentDetailsFails() {

        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.ROOT)
        `when`(mockPaymentDetails.isValid()).thenReturn(false)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockRootActions)
        val mockAuthHeaderSuccess = "123"

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false

        assertEquals(expectedResult, apiClient.authorizePayment(mockPaymentDetails, mockAuthHeaderSuccess))
    }

    @Test
    fun authorizePaymentWithValidParametersInRootState() {

        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.ROOT)
        `when`(mockPaymentDetails.isValid()).thenReturn(true)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockRootActions)
        val mockAuthHeaderSuccess = "123"

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = true

        assertEquals(expectedResult, apiClient.authorizePayment(mockPaymentDetails, mockAuthHeaderSuccess))
    }

    @Test
    fun authorizePaymentWithValidParametersInAuthorizedState() {

        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.AUTHORIZED)
        `when`(mockPaymentDetails.isValid()).thenReturn(true)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockAuthorizedActions)
        val mockAuthHeaderSuccess = "123"

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false

        assertEquals(expectedResult, apiClient.authorizePayment(mockPaymentDetails, mockAuthHeaderSuccess))
    }

    @Test
    fun authorizePaymentWithValidParametersInSettledState() {

        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.SETTLED)
        `when`(mockPaymentDetails.isValid()).thenReturn(true)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockSettledActions)
        val mockAuthHeaderSuccess = "123"

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false

        assertEquals(expectedResult, apiClient.authorizePayment(mockPaymentDetails, mockAuthHeaderSuccess))
    }

    @Test
    fun authorizePaymentWithValidParametersInCancelledState() {

        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.CANCELED)
        `when`(mockPaymentDetails.isValid()).thenReturn(true)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockCanceledActions)
        val mockAuthHeaderSuccess = "123"

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false

        assertEquals(expectedResult, apiClient.authorizePayment(mockPaymentDetails, mockAuthHeaderSuccess))
    }

    @Test
    fun settlePaymentInAuthorizedStateSuccess() {
        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.AUTHORIZED)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockAuthorizedActions)

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = true
        assertEquals(expectedResult, apiClient.settlePayment())
    }

    @Test
    fun settlePaymentInRootStateFail() {
        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.ROOT)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockRootActions)

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false
        assertEquals(expectedResult, apiClient.settlePayment())
    }

    @Test
    fun settlePaymentInCanceledStateFail() {
        `when`(mockActionsStMachine.currState).thenReturn(PaymentsStateMachine.State.CANCELED)
        `when`(mockActionsStMachine.getAvailableActions()).thenReturn(mockCanceledActions)

        apiClient = ApiClient(mockActionsStMachine)

        val expectedResult = false
        assertEquals(expectedResult, apiClient.settlePayment())
    }


    @Test
    fun successfullAuthorizePaymentChangesStateMachineToAuthorizedState() {

        `when`(mockPaymentDetails.isValid()).thenReturn(true)
        val mockHeadersSuccess = "123"

        apiClient = ApiClient(PaymentsStateMachine())
        apiClient.initPaymentOperations(mockHeadersSuccess)
        apiClient.authorizePayment(mockPaymentDetails, mockHeadersSuccess)

        val expectedResult = PaymentsStateMachine.State.AUTHORIZED
        assertEquals(expectedResult, apiClient.stateMachine.currState)
    }

    @Test
    fun successfullSettlePaymentChangesStateMachineToSettledState() {

        `when`(mockPaymentDetails.isValid()).thenReturn(true)
        val mockHeadersSuccess = "123"

        apiClient = ApiClient(PaymentsStateMachine())
        apiClient.initPaymentOperations(mockHeadersSuccess)
        apiClient.authorizePayment(mockPaymentDetails, mockHeadersSuccess)

        val expectedResult = PaymentsStateMachine.State.SETTLED
        apiClient.settlePayment()
        assertEquals(expectedResult, apiClient.stateMachine.currState)
    }
}