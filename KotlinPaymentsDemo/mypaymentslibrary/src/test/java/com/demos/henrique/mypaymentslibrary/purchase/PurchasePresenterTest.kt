package com.demos.henrique.mypaymentslibrary.purchase

import com.demos.henrique.mypaymentslibrary.api.ApiClient
import com.demos.henrique.mypaymentslibrary.api.PaymentsStateMachine
import com.demos.henrique.mypaymentslibrary.model.PurchaseInfo
import com.demos.henrique.mypaymentslibrary.utils.DummyGenerator
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*

class PurchasePresenterTest {

    private lateinit var presenter: PurchasePresenter
    private val mockView = mock(PurchaseContract.PurchaseViewContract::class.java)
    private val mockPurchaseInfo = mock(PurchaseInfo::class.java)
    private val mockApiClient = mock(ApiClient::class.java)

    @Before
    fun setup() {
        presenter = PurchasePresenter(mockView, mockPurchaseInfo, mockApiClient)
    }

    @Test
    fun authorizePaymentStartSuccessful() {
        `when`(mockPurchaseInfo.itemName).thenReturn("dummy")
        `when`(mockPurchaseInfo.price).thenReturn(999)
        `when`(mockApiClient.stateMachine).thenReturn(PaymentsStateMachine())
        `when`(mockApiClient.initPaymentOperations(DummyGenerator.generateDummyAuthHeader()))
            .thenReturn(true)
        `when`(
            mockApiClient.authorizePayment(
                ArgumentMatchers.any(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(true)
        `when`(mockApiClient.settlePayment()).thenReturn(true)

        presenter.authorizePaymentStart()

        verify(mockView, times(0)).displayFailedPayment()
    }

    @Test
    fun authorizePaymentStartFailed() {
        `when`(mockPurchaseInfo.itemName).thenReturn("dummy")
        `when`(mockPurchaseInfo.price).thenReturn(999)
        `when`(mockApiClient.stateMachine).thenReturn(PaymentsStateMachine())
        `when`(mockApiClient.initPaymentOperations(DummyGenerator.generateDummyAuthHeader()))
            .thenReturn(true)
        `when`(
            mockApiClient.authorizePayment(
                ArgumentMatchers.any(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(false)
        `when`(mockApiClient.settlePayment()).thenReturn(true)

        presenter.authorizePaymentStart()

        verify(mockView, times(1)).displayFailedPayment()
    }

    @Test
    fun settlePaymentSuccessful() {

        `when`(mockPurchaseInfo.itemName).thenReturn("dummy")
        `when`(mockPurchaseInfo.price).thenReturn(999)
        `when`(mockApiClient.stateMachine).thenReturn(PaymentsStateMachine())
        `when`(mockApiClient.initPaymentOperations(DummyGenerator.generateDummyAuthHeader()))
            .thenReturn(true)
        `when`(
            mockApiClient.authorizePayment(
                ArgumentMatchers.any(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(true)
        `when`(mockApiClient.settlePayment()).thenReturn(true)

        presenter.authorizePaymentStart()

        verify(mockView, times(0)).displayFailedPayment()
        verify(mockView, times(1)).displayPaymentCompleted()
    }


    @Test
    fun settlePaymentFailed() {

        `when`(mockPurchaseInfo.itemName).thenReturn("dummy")
        `when`(mockPurchaseInfo.price).thenReturn(999)
        `when`(mockApiClient.stateMachine).thenReturn(PaymentsStateMachine())
        `when`(mockApiClient.initPaymentOperations(DummyGenerator.generateDummyAuthHeader()))
            .thenReturn(true)
        `when`(
            mockApiClient.authorizePayment(
                ArgumentMatchers.any(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(true)
        `when`(mockApiClient.settlePayment()).thenReturn(false)

        presenter.authorizePaymentStart()

        verify(mockView, times(0)).displayPaymentCompleted()
        verify(mockView, times(1)).displayFailedPayment()
    }
}