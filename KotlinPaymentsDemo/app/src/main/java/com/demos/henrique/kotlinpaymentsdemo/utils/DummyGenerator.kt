package com.demos.henrique.kotlinpaymentsdemo.utils

import com.demos.henrique.kotlinpaymentsdemo.model.AisleItem

class DummyGenerator {
    companion object {
        @JvmStatic
        fun generateAisleItemList() = mutableListOf(
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains"),
            AisleItem("Veggies"), AisleItem("Sides"), AisleItem("Dessert"), AisleItem("Drinks"), AisleItem("Mains")
        )
    }
}