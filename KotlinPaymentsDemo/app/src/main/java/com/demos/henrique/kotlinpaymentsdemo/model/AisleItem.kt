package com.demos.henrique.kotlinpaymentsdemo.model

import com.demos.henrique.kotlinpaymentsdemo.sharedui.CustomBaseAdapter.CustomListable
import kotlin.math.roundToInt

data class AisleItem(val name: String) : CustomListable {
    val price: Int = (Math.random() * 10).roundToInt()

    override fun getType(): Int = 0
}
