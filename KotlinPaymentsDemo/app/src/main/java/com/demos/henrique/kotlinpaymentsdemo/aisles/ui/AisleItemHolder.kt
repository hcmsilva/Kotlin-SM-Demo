package com.demos.henrique.kotlinpaymentsdemo.aisles.ui

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.demos.henrique.kotlinpaymentsdemo.R
import com.demos.henrique.kotlinpaymentsdemo.aisles.AislesPresenter
import com.demos.henrique.kotlinpaymentsdemo.model.AisleItem
import com.demos.henrique.kotlinpaymentsdemo.sharedui.BaseViewHolder

class AisleItemHolder(itemView: View) : BaseViewHolder<AisleItem>(itemView) {


    val productNameTv: TextView
    val productPriceTv: TextView
    val buyButton: ImageButton

    init {
        productNameTv = itemView.findViewById(R.id.product_name)
        productPriceTv = itemView.findViewById(R.id.product_price)
        buyButton = itemView.findViewById(R.id.buy_image_button)
    }

    override fun bindHolder(item: AisleItem) {
        productNameTv.text = item.name
        productPriceTv.text = "Price: GBP ${item.price}"
    }

    fun bindHolder(item: AisleItem, aislesPresenter: AislesPresenter) {
        bindHolder(item)
        buyButton.setOnClickListener { _ -> aislesPresenter.buyItem(item) }
    }
}