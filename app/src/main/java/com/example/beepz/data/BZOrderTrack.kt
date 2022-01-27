package com.example.beepz.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*Created by Maneesha on 25/01/2022*/
//data class containing order tracking details
class BZOrderTrack :Serializable {
    @Expose
    @SerializedName("orderTrackId")
    val orderTrackId: Int?=null

    @Expose
    @SerializedName("name")
    val name: String?=null

    @Expose
    @SerializedName("details")
    val details: String?=null

    @Expose
    @SerializedName("level")
    val level: Integer?=null

    @Expose
    @SerializedName("image")
    val image: String?=null
}
