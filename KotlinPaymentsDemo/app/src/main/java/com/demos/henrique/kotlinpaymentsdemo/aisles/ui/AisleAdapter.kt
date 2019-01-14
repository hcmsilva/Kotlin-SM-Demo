package com.demos.henrique.kotlinpaymentsdemo.aisles.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.demos.henrique.kotlinpaymentsdemo.R
import com.demos.henrique.kotlinpaymentsdemo.aisles.AislesActivity
import com.demos.henrique.kotlinpaymentsdemo.model.AisleItem
import com.demos.henrique.kotlinpaymentsdemo.sharedui.BaseViewHolder
import com.demos.henrique.kotlinpaymentsdemo.sharedui.CustomBaseAdapter

class AisleAdapter(private val hostActivity: AislesActivity) : CustomBaseAdapter<AisleItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<AisleItem> = AisleItemHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_row,
            parent,
            false
        )
    )

    override fun onBindViewHolder(p0: BaseViewHolder<AisleItem>, p1: Int) =
        (p0 as AisleItemHolder).bindHolder(mData[p1], hostActivity.mPresenter)
}