package com.example.beepz.webservice

import com.example.beepz.data.BZResponse
import retrofit2.Call
import retrofit2.http.GET

/*Created by Maneesha on 25/01/2022*/
interface BZApiInterface {
    @GET("active/request?CustomerId=34")
    fun getData(): Call<BZResponse>
}