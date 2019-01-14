package com.demos.henrique.mypaymentslibrary.dto

import com.google.gson.annotations.SerializedName

data class CuriesItem(

	@field:SerializedName("templated")
	val templated: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("href")
	val href: String? = null
)