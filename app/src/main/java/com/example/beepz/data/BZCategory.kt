package com.example.beepz.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*Created by Maneesha on 25/01/2022*/
//data class containing category details
class BZCategory : Serializable {
    @Expose
    @SerializedName("categoryId")
    val categoryId: Int? = null

    @Expose
    @SerializedName("categoryName")
    val categoryName: String? = null

    @Expose
    @SerializedName("icon")
    val icon: String? = null

    @Expose
    @SerializedName("details")
    val details: String? = null
}