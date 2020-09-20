package com.omi.demograph.home.network

import com.omi.demograph.constants.APPURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit:Retrofit? = null

    fun getInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(APPURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit as Retrofit
    }

}