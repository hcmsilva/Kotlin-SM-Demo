package com.demos.henrique.kotlinpaymentsdemo.aisles

import com.demos.henrique.kotlinpaymentsdemo.model.AisleItem

interface AislesContract {

    interface AislesViewContract {
        fun displayDataList(list: MutableList<AisleItem>)
    }

    interface AislesPresenterContract {
        fun updateDataList()
        fun getDataList(): MutableList<AisleItem>
        fun buyItem(item: AisleItem)
    }
}