package com.demos.henrique.kotlinpaymentsdemo.sharedui

import android.support.v7.widget.RecyclerView
import com.demos.henrique.kotlinpaymentsdemo.sharedui.CustomBaseAdapter.CustomListable

abstract class CustomBaseAdapter<T : CustomListable> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    internal val mData: MutableList<T> = mutableListOf<T>()

    //this operation could be optimized in the future to replace only new entries in the list
    fun setData(list: MutableList<T>) {
        mData.clear()
        mData.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = mData.size

    abstract override fun onBindViewHolder(p0: BaseViewHolder<T>, p1: Int)

    override fun getItemViewType(position: Int) = mData[position].getType()

    interface CustomListable {
        fun getType(): Int
    }
}