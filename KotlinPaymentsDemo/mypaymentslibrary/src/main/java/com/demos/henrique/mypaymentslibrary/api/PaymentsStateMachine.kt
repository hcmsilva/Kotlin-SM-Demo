package com.demos.henrique.mypaymentslibrary.api

import com.demos.henrique.mypaymentslibrary.dto.ActionLink
import com.demos.henrique.mypaymentslibrary.utils.DummyGenerator


open class PaymentsStateMachine {

    open var currState: State = State.ROOT

    enum class State {
        ROOT,
        AUTHORIZED,
        SETTLED,
        CANCELED
    }

    open fun getAvailableActions(): ActionLink =
        when (currState) {
            PaymentsStateMachine.State.ROOT -> DummyGenerator.getRootActions()
            PaymentsStateMachine.State.AUTHORIZED -> DummyGenerator.getAuthorizedActions()
            PaymentsStateMachine.State.SETTLED -> DummyGenerator.getSettledActions()
            PaymentsStateMachine.State.CANCELED -> DummyGenerator.getCanceledActions()
        }
}