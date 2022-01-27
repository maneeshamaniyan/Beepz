package com.example.beepz.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*Created by Maneesha on 25/01/2022*/
//data class containing response data
data class BZResponse(
    @Expose
    @SerializedName("data")
    val data: BZData,
    @Expose
    @SerializedName("code")
    val code: Integer,
    @Expose
    @SerializedName("message")
    val categoryId: String,
    @Expose
    @SerializedName("isSuccess")
    val categoryName: Boolean,
)
