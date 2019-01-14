package com.demos.henrique.kotlinpaymentsdemo.aisles

import com.demos.henrique.kotlinpaymentsdemo.aisles.AislesContract.AislesPresenterContract
import com.demos.henrique.kotlinpaymentsdemo.model.AisleItem
import com.demos.henrique.kotlinpaymentsdemo.utils.DummyGenerator
import com.demos.henrique.mypaymentslibrary.utils.PaymentUtilities

class AislesPresenter(private val aislesActivity: AislesActivity) : AislesPresenterContract {

    private val currDataList = mutableListOf<AisleItem>()
    override fun updateDataList() {
        currDataList.clear()
        currDataList += DummyGenerator.generateAisleItemList()
        aislesActivity.displayDataList(currDataList)
    }

    override fun getDataList() = currDataList

    override fun buyItem(item: AisleItem) {
        PaymentUtilities.pay(item.name, item.price, aislesActivity)
    }
}