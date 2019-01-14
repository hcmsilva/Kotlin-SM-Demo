package com.demos.henrique.kotlinpaymentsdemo.sharedui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.demos.henrique.kotlinpaymentsdemo.sharedui.CustomBaseAdapter.CustomListable

abstract class BaseViewHolder<T : CustomListable>(item: View) : RecyclerView.ViewHolder(item) {

    abstract fun bindHolder(item: T)
}