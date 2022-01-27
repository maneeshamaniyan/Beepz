package com.example.beepz.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*Created by Maneesha on 25/01/2022*/
//data class containing order details
class BZOrder : Serializable {
    @Expose
    @SerializedName("orderId")
    val orderId: Int? = null

    @Expose
    @SerializedName("customerId")
    val customerId: Int? = null

    @Expose
    @SerializedName("category")
    val category: BZCategory? = null

    @Expose
    @SerializedName("orderTrack")
    val orderTrack: BZOrderTrack? = null

    @Expose
    @SerializedName("car")
    val car: BZCar? = null

    @Expose
    @SerializedName("bookingDate")
    val bookingDate: String? = null
}
