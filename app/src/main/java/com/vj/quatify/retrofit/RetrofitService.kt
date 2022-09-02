package com.vj.quatify.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object{
        private var INSTANCE:Retrofit?=null

        fun getInstance():Retrofit{
            if(INSTANCE==null){
                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            else
                return INSTANCE!!
        }
    }
}