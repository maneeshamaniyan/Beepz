package com.example.beepz.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*Created by Maneesha on 25/01/2022*/
//data class containing car details
class BZCar : Serializable {
    @Expose
    @SerializedName("carId")
    val carId: Int?= null

    @Expose
    @SerializedName("vehicleNickName")
    val vehicleNickName: String? = null
}
