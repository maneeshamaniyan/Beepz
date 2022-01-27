package com.example.beepz.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*Created by Maneesha on 25/01/2022*/
//data class containing list of orders
data class BZData(
    @Expose
    @SerializedName("data")
    val orderList: List<BZOrder>
)
