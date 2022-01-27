package com.example.beepz.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*Created by Maneesha on 25/01/2022*/
class BZApiClient {
    companion object {
        var BASE_URL: String = "https://beepz.ae/api/v1/Get/Customer/"
        val getClient: BZApiInterface
            get() {

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit.create(BZApiInterface::class.java)

            }
    }
}