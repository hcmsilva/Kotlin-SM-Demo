package com.demos.henrique.mypaymentslibrary.api

import com.demos.henrique.mypaymentslibrary.dto.PaymentDetails

open class ApiClient(open val stateMachine: PaymentsStateMachine) : ApiService {
    override fun initPaymentOperations(authHeader: String): Boolean {
        if (!validateAuthHeader(authHeader))
            return false

        val availableActions = stateMachine.getAvailableActions()
        return availableActions.paymentsAuthorize != null
    }

    override fun authorizePayment(paymentDetails: PaymentDetails?, authHeader: String): Boolean {
        if (
            !validateAuthHeader(authHeader) || paymentDetails == null ||
            !paymentDetails.isValid() ||
            stateMachine.getAvailableActions().paymentsAuthorize == null
        )
            return false
        else {
            stateMachine.currState = PaymentsStateMachine.State.AUTHORIZED
            return true
        }
    }

    override fun settlePayment(): Boolean {
        if (stateMachine.currState != PaymentsStateMachine.State.AUTHORIZED ||
            stateMachine.getAvailableActions().paymentsSettle == null
        )
            return false
        else {
            stateMachine.currState = PaymentsStateMachine.State.SETTLED
            return true
        }
    }

    private fun validateAuthHeader(authHeader: String?): Boolean = !authHeader.isNullOrEmpty()
}