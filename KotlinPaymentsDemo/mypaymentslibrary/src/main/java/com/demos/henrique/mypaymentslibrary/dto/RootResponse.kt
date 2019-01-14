package com.demos.henrique.mypaymentslibrary.dto


import com.google.gson.annotations.SerializedName


data class RootResponse(

	@field:SerializedName("_links")
	val actionLink: ActionLink? = null
)