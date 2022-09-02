package com.vj.quatify.retrofit

import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL="https://zenquotes.io/api/"

interface QuatesApiInterface {

    @GET("quotes/")
    fun getQuates():Call<List<QuatesRet>>

}