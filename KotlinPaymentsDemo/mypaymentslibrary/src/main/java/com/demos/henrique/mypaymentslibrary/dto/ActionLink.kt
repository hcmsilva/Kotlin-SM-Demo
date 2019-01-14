package com.demos.henrique.mypaymentslibrary.dto

import com.google.gson.annotations.SerializedName

data class ActionLink(

    @field:SerializedName("payments:authorize")
    val paymentsAuthorize: PaymentsAuthorize? = null,

    @field:SerializedName("payments:settle")
    val paymentsSettle: PaymentsSettle? = null,

    @field:SerializedName("payments:cancel")
    val paymentsCancel: PaymentsCancel? = null,

    @field:SerializedName("payments:events")
    val paymentsEvents: PaymentsEvents? = null,

    @field:SerializedName("payments:partialSettle")
    val paymentsPartialSettle: PaymentsPartialSettle? = null,

    @field:SerializedName("curies")
    val curies: List<CuriesItem?>? = null,

    @field:SerializedName("tokens:tokens")
    val tokensTokens: TokensTokens? = null,

    @field:SerializedName("resourceTree")
    val resourceTree: ResourceTree? = null,

    @field:SerializedName("payments:refund")
    val paymentsRefund: PaymentsRefund? = null,

    @field:SerializedName("payments:partialRefund")
    val paymentsPartialRefund: PaymentsPartialRefund? = null
)